package model;

public class Complain {
	private int customerId;
	private String customerConcern;

	public Complain() {

	}

	public Complain(int customerId, String customerConcern) {
		this.customerId = customerId;
		this.customerConcern = customerConcern;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerConcern() {
		return customerConcern;
	}

	public void setCustomerConcern(String customerConcern) {
		this.customerConcern = customerConcern;
	}

}
