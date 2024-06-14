package kr.ac.uc.beverage_ordering_system.model;

import java.io.Serializable;

public class OrderModel implements Serializable {
    String customerName, beverage;
    int amount;

    public OrderModel(String customerName, String beverage, int amount) {
        this.customerName = customerName;
        this.beverage = beverage;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBeverage() {
        return beverage;
    }

    public int getAmount() {
        return amount;
    }
}
