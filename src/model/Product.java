package model;

public class Product {
    int productId;
    String productName;
    double price;
    int Qnty;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQnty() {
        return Qnty;
    }

    public void setQnty(int qnty) {
        Qnty = qnty;
    }

    @Override
    public String toString() {
        return "Product [Qnty=" + Qnty + ", price=" + price + ", productId=" + productId + ", productName="
                + productName + "]";
    }

}
