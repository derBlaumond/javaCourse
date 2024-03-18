package main;

import ledger.AccountManager;
import ledger.Accountant;
import ledger.JournalEntryQueue;

public class Main {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		AccountManager.init();
		JournalEntryQueue.init(1000000);						
		AccountManager.printAccounts();
		
		Accountant[] accountants = new Accountant[10];
		
		for (int i = 0; i < accountants.length; i++) {
			accountants[i] = new Accountant();
			accountants[i].setName("Accountant " + i);
			accountants[i].start();
		}
		
		for (int i = 0; i < accountants.length; i++) {
			try {
				accountants[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		AccountManager.printAccounts();
		System.out.println("" + AccountManager.getPostings() + " postings in " + (end-start) + "ms");
		
	}

}
