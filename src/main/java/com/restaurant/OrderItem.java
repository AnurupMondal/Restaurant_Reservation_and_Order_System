package com.restaurant;

/**
 * Represents a single item within an order.
 */
public class OrderItem {
    private String itemName;
    private int quantity;
    private double price;

    /**
     * Constructs a new OrderItem.
     *
     * @param itemName The name of the item.
     * @param quantity The quantity of the item.
     * @param price    The price per item.
     */
    public OrderItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Returns the name of the item.
     *
     * @return The item name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the price per item.
     *
     * @return The price.
     */
    public double getPrice() {
        return price;
    }
}