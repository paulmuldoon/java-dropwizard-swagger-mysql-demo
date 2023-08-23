package org.kainos.ea.cli;

public class Product implements Comparable<Product> {
    private int ProductID;
    private String Name;
    private String Description;
    private double Price;

    public Product(int productID, String name, String description, double price) {
        this.ProductID = productID;
        this.Name = name;
        this.Description = description;
        this.Price = price;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }

    @Override
    public String toString() {
        return "Product name:" +  this.getName() + "  Product price: £" + this.getPrice();
    }
}
