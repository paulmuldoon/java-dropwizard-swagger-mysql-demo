package org.kainos.ea.cli;
import java.util.Date;

public class Order {
    //order information variables
    private int orderID;
    private int customerID;
    private Date orderDate;

    public Order(int orderID, int customerID, Date orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
    }

    //get and set values for these variables
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order ID: " +  this.getOrderID() + "  Customer ID: " + this.getCustomerID() + "  Order Date: " + this.getOrderDate();
    }

}
