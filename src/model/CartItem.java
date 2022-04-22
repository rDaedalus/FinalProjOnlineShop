package model;

public class CartItem {
    int productId;
    String productName;
    Double productPrice;
    int productQty;

    public CartItem(int productId, String productName, Double productPrice, int productQty) {
        this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
        this.productQty = productQty;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
    
	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
}
