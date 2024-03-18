package ledger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import exceptions.AccountException;
import exceptions.AccountNotFoundException;
import exceptions.InvalidJournalEntryException;
import exceptions.InvalidSyntaxException;
import exceptions.UnequalBalanceException;
import util.Pair;


public class Accountant extends Thread{
	
	
	@Override
	public void run() {
		JournalEntryQueue buffer = JournalEntryQueue.getInstance();
		while (!isInterrupted() && buffer.getSize() > 0) {
			String entry = buffer.get();
			if (entry != null) {
				try {
					//System.out.println("Posting " + entry);
					postEntry(entry);
					AccountManager.incrementPostings();
				} catch (InvalidJournalEntryException e) {
					System.out.println("Invalid Syntax");
					e.printStackTrace();
				} catch (AccountException e) {
					System.out.println("Account exception, " + JournalEntryQueue.getInstance().getSize() + " postings remaining");
					e.printStackTrace();
					buffer.add(entry);
				}
			}
		}
	}
	
	private void postEntry(String journalEntry) throws InvalidJournalEntryException, AccountException {
		
		//check syntax and import 
		if (journalEntry.indexOf(";") == -1) throw new InvalidSyntaxException("Invalid syntax: ; missing in " + journalEntry);
		String[] debitCredit = journalEntry.split(";");
		if (debitCredit.length != 2) throw new InvalidSyntaxException("Invalid syntax: ; must split entry into two parts: " + journalEntry);
		
		List<Pair<Account, Integer>> debits = parseJournalEntry(debitCredit[0]);
		List<Pair<Account, Integer>> credits = parseJournalEntry(debitCredit[1]);
		
		//Ensure that debit value equals credit value
		int balance = 0;
		for (Pair<Account, Integer> p : debits) {
			balance += p.getSecond();
		}
		for (Pair<Account, Integer> p : credits) {
			balance -= p.getSecond();
		}
		if (balance != 0) throw new UnequalBalanceException("Unequal balance in: " + journalEntry);
		
		//Open Accounts in deterministic order
		ArrayList<Account> affectedAccounts = new ArrayList<>();
		for (Pair<Account, Integer> p : debits) {
			affectedAccounts.add(p.getFirst());
		}
		for (Pair<Account, Integer> p : credits) {
			affectedAccounts.add(p.getFirst());
		}
		affectedAccounts.sort(new Comparator<Account>() {
			@Override
			public int compare(Account o1, Account o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (int i = 0; i < affectedAccounts.size(); i++) {
			Account a = affectedAccounts.get(i);
			if (!a.open(this)) {
				throw new AccountException("Account " + a.getName() + " already opened by other Accountant");
			}
		}
		
		//Post entries
		AccountException error = null;
		try {
			for (Pair<Account, Integer> p : debits) {
				p.getFirst().debit(this, p.getSecond());
			}
			for (Pair<Account, Integer> p : credits) {
				p.getFirst().credit(this, p.getSecond());
			}
			commitTransaction(debits);
			commitTransaction(credits);
		
		} catch (AccountException e) {
			System.out.println(this.getName() + ": unable to post entry: " + e.getMessage() + ", " + journalEntry);
			abortTransaction(debits);
			abortTransaction(credits);
			error = e;
		} finally {
			//Ensure that all accounts are closed
			for (Pair<Account, Integer> p : debits) {
				p.getFirst().close(this);
			}
			for (Pair<Account, Integer> p : credits) {
				p.getFirst().close(this);
			}
		}		
		if (error != null) {
			throw error;
		}
	}
	
	private void abortTransaction(List<Pair<Account, Integer>> accounts) {
		for (Pair<Account, Integer> p : accounts) {
			p.getFirst().abort(this);
		}
	}
	
	private void commitTransaction(List<Pair<Account, Integer>> accounts) {
		for (Pair<Account, Integer> p : accounts) {
			p.getFirst().commit(this);
		}
	}
	
	private List<Pair<Account, Integer>> parseJournalEntry(String debitOrCreditPart) throws InvalidSyntaxException, AccountNotFoundException {
		
		List<Pair<Account, Integer>> accountsAndValues = new ArrayList<>();
		
		for (String accountAndValue : debitOrCreditPart.split(",")) {
			accountAndValue = accountAndValue.trim();
			if (accountAndValue.indexOf(" ") == -1) { 
				throw new InvalidSyntaxException("Invalid syntax: account name and value must be splitted by a space in " + accountAndValue);
			}
			String[] parts = accountAndValue.split(" ");
			if (parts.length != 2) {
				throw new InvalidSyntaxException("Invalid syntax: spaces are not allowed in account names: " + accountAndValue);
			}
			String accountName = parts[0];
			try {
				Account account = AccountManager.getAccount(accountName);
				Integer value = Integer.parseInt(parts[1]);				
				accountsAndValues.add(new Pair<>(account, value));
			} catch (AccountNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				throw new InvalidSyntaxException("Invalid syntax: given value is not an integer number: " + parts[1]);
			}			
		}
		return accountsAndValues;
	}

}
