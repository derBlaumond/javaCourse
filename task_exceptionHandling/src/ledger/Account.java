package ledger;

import exceptions.AccountException;

public abstract class Account {
	
	private String name;	
	private Boolean open = false;
	protected int value = 50000;
	protected int delta = 0;
	private Accountant accountant = null;
	
	public Account(String name) {
		this.name = name;
	}
	
	public abstract boolean credit(Accountant accountant, int value) throws AccountException;
	
	public abstract boolean debit(Accountant accountant, int value) throws AccountException;
	
	public boolean isLockedByAccountant(Accountant accountant) {
		if (this.accountant == accountant) {
			return true;
		}
		return false;
	}
	
	public boolean open(Accountant accountant) {
		synchronized (this.open) {
			if ((this.accountant == null && this.open==false) || (this.accountant == accountant)) {
				this.open = true;
				this.accountant = accountant;
				return true;
			}
			return false;
		}		
	}
	
	public boolean abort(Accountant accountant) {
		if (isLockedByAccountant(accountant)) {
			delta = 0;
			return true;
		}
		return false;
	}
	
	public boolean commit(Accountant accountant) {
		if (isLockedByAccountant(accountant)) {
			value += delta;
			delta = 0;
			return true;
		}
		return false;
	}
	
	public boolean close(Accountant accountant) {
		synchronized (this.open) {
			if (isLockedByAccountant(accountant)) {
				this.open = false;
				this.accountant = null;
				return true;
			}
			return false;
		}		
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {		
		return name + " (value=" + value + ", open=" + open + ")";
	}

}
