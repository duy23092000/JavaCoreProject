package javacoreproject;

public class Product {
    private int id;
    private String productName;
    private int productQuantity;
    private String productDescription;
    private double price;

    public Product() {
    }

    public Product(int id, String productName, int productQuantity, String productDescription, double price) {
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    public Product(String productName, int productQuantity, String productDescription, double price) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


