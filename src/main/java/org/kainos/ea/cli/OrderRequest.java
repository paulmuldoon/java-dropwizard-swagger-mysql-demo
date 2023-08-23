package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class OrderRequest {

    private int customerid;
    private Date orderdate;

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @JsonCreator
    public OrderRequest (
            @JsonProperty("customerid") int customerid,
            @JsonProperty("orderdate") Date orderdate) {
        this.customerid = customerid;
        this.orderdate = orderdate;
    }

}
