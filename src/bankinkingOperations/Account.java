package bankinkingOperations;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountId;
	private String accountname;
	public double balance;
	private List<Double> transactions;
	private List<Transfer> transfers;

	public Account(int accountId, String accountname) {
		super();
		this.accountId = accountId;
		this.accountname = accountname;
		this.balance = 0.0;
		this.transactions = new ArrayList<>();
		this.transfers = new ArrayList<>();
	}

	public Account() {
		super();
	}

	public void deposit(double amount) {
		balance += amount;
		transactions.add(amount);
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			transactions.add(-amount);
		}
	}

	public void scheduleTransfer(int transferId, int toAccountId, double amount) {
		if (amount <= balance) {
			balance -= amount;
			Transfer transfer = new Transfer(transferId, accountId, toAccountId, amount);
			transfers.add(transfer);
		}
	}

	public void checkStatus(int transferId) {
		Transfer transfer = transfers.stream().filter(t -> t.getTransferId() == transferId).findFirst().orElse(null);
		if (transfer != null) {
			transfer.setStatus("Completed");
		}
	}

	public void MergeAccounts(Account otherAccount) {
		this.balance += otherAccount.getBalance();
		this.transactions.addAll(otherAccount.getTransections());
	}

	public double getBalance() {
		return this.balance;
	}

	public List<Double> getTransections() {
		return transactions;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

}
