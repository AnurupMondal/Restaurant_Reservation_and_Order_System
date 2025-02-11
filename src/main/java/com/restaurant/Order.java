package com.restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer order containing multiple order items.
 */
public class Order {
    private static int orderCounter = 1;

    private String orderId;
    private String customerName;
    private List<OrderItem> items;

    /**
     * Constructs a new Order with an automatically generated order ID.
     *
     * @param customerName The name of the customer.
     */
    public Order(String customerName) {
        this.orderId = "ORD" + orderCounter++;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    /**
     * Returns the order ID.
     *
     * @return The order ID.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Returns the customer's name.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the list of order items.
     *
     * @return A list of order items.
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Adds an item to the order.
     *
     * @param item The OrderItem to add.
     */
    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    /**
     * Displays the order details on the console.
     */
    public void displayOrder() {
        System.out.println("\n=== Order Details ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println(" - " + item.getItemName() + " x " + item.getQuantity() + " @ $" + item.getPrice() + " each");
        }
        System.out.println();
    }
}