package ledger;

import exceptions.AmountInsufficientException;
import exceptions.AccountClosedException;

public class Liability extends Account {

	public Liability(String name) {
		super(name);
	}

	@Override
	public boolean credit(Accountant accountant, int value) throws AccountClosedException {
		if (isLockedByAccountant(accountant)) {
			if (!isOpen()) throw new AccountClosedException("Liability account " + toString() + " closed.");
			this.delta += value;
			return true;
		}
		return false;
	}

	@Override
	public boolean debit(Accountant accountant, int value) throws AccountClosedException, AmountInsufficientException {
		if (isLockedByAccountant(accountant)) {
			if (!isOpen()) throw new AccountClosedException("Liability account " + toString() + " closed.");
			if (this.value < value) throw new AmountInsufficientException("Amount insufficient on liability account " + toString());
			this.delta -= value;
			return true;
		}
		return false;
	}

}
