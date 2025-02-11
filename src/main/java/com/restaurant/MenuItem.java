package com.restaurant;

/**
 * Represents an item on the restaurant's menu.
 */
public class MenuItem {
    private String id;
    private String name;
    private double price;
    private String description;

    /**
     * Constructs a new MenuItem.
     *
     * @param id          The unique identifier for the menu item.
     * @param name        The name of the menu item.
     * @param price       The price of the menu item.
     * @param description A short description of the menu item.
     */
    public MenuItem(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Returns the unique identifier of the menu item.
     *
     * @return The menu item ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the menu item.
     *
     * @return The menu item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the menu item.
     *
     * @return The menu item price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the description of the menu item.
     *
     * @return The menu item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the menu item.
     *
     * @return A string representing the menu item.
     */
    @Override
    public String toString() {
        return id + ". " + name + " - $" + price + " (" + description + ")";
    }
}