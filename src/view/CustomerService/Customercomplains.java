package view.CustomerService;

public class Customercomplains {
	private int customerId;
	private String customerComplain;

	public Customercomplains() {
	}

	public Customercomplains(int customerId, String customerComplain) {
		this.customerId = customerId;
		this.customerComplain = customerComplain;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerComplain() {
		return customerComplain;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerComplain(String customerComplain) {
		this.customerComplain = customerComplain;
	}

}
