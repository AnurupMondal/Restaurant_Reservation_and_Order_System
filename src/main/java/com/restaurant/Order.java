package com.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private List<OrderItem> items;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void print() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println("  " + item.getItemName() + " x " + item.getQuantity() + " = " + item.getPrice() * item.getQuantity());
        }
        System.out.println("Total: " + getTotal());
    }

}
