package view.CustomerService;

public class Customercomplain {
	private int customerId;
	private String customerConcern;

	public Customercomplain() {

	}

	public Customercomplain(int customerId, String customerConcern) {

		this.customerId = customerId;
		this.customerConcern = customerConcern;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerConcern() {
		return customerConcern;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerConcern(String customerConcern) {
		this.customerConcern = customerConcern;
	}

}
