package bankinkingOperations;

public class Transfer {
	private int transferId;
	private int fromAccountId;
	private int toAccountId;
	private double amount;
	private String status;

	public Transfer(int transferId, int fromAccountId, int toAccountId, double amount) {
		super();
		this.transferId = transferId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.status = "Panding";
	}

	public Transfer() {
		super();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public int getTransferId() {
		return transferId;
	}
}
