package com.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Restaurant Reservation
 * and Order System command-line application.
 *
 * <p>This application allows users to create dine-in reservations,
 * place takeaway orders (with no fixed reservation time), view reservations,
 * and view orders. It also displays a restaurant menu from which orders can be placed.</p>
 */
public class Main {

    private static List<Reservation> reservations = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static List<MenuItem> menuItems = new ArrayList<>();

    /**
     * The main method starts the application and provides a command-line interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        initializeMenuItems();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("==================================");
            System.out.println("Restaurant Reservation and Order System");
            System.out.println("1. Create Reservation/Order");
            System.out.println("2. Place Order");
            System.out.println("3. View Reservations");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createReservation(scanner);
                    break;
                case "2":
                    placeOrder(scanner);
                    break;
                case "3":
                    viewReservations();
                    break;
                case "4":
                    viewOrders();
                    break;
                case "5":
                    exit = true;
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Initializes the restaurant menu items.
     */
    private static void initializeMenuItems() {
        menuItems.add(new MenuItem("1", "Burger", 5.99, "Classic beef burger with lettuce and tomato"));
        menuItems.add(new MenuItem("2", "Pizza", 8.99, "Cheese pizza with tomato sauce"));
        menuItems.add(new MenuItem("3", "Pasta", 7.49, "Pasta in creamy alfredo sauce"));
        menuItems.add(new MenuItem("4", "Salad", 4.99, "Fresh garden salad with vinaigrette dressing"));
        menuItems.add(new MenuItem("5", "Soda", 1.99, "Chilled carbonated drink"));
    }

    /**
     * Creates a reservation based on user input.
     * <p>
     * For dine-in reservations, the user is prompted to enter a reservation time
     * and table number. For takeaway orders, the reservation time is set to "Anytime"
     * and the user is prompted for a pickup location.
     * </p>
     *
     * @param scanner The Scanner object used for user input.
     */
    private static void createReservation(Scanner scanner) {
        System.out.println("Select Reservation Type:");
        System.out.println("1. Dine-In Reservation");
        System.out.println("2. Takeaway Order (Pick up anytime)");
        System.out.print("Enter your choice: ");
        String resType = scanner.nextLine();

        System.out.print("Enter Reservation ID: ");
        String reservationId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Number of Guests: ");
        int numberOfGuests = 0;
        try {
            numberOfGuests = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format for guests. " + e.getMessage());
            return;
        }

        Reservation reservation = null;
        switch (resType) {
            case "1": // Dine-In Reservation
                System.out.print("Enter Reservation Time (e.g., 7:00 PM): ");
                String reservationTime = scanner.nextLine();
                System.out.print("Enter Table Number: ");
                int tableNumber = Integer.parseInt(scanner.nextLine());
                reservation = new DineInReservation(
                        reservationId, customerName, numberOfGuests, reservationTime, tableNumber);
                break;
            case "2": // Takeaway Order
                // For takeaway orders, no need for a reservation time.
                // Set to a default value like "Anytime".
                String defaultTime = "Anytime";
                System.out.print("Enter Pickup Location: ");
                String pickupLocation = scanner.nextLine();
                reservation = new TakeawayReservation(
                        reservationId, customerName, numberOfGuests, defaultTime, pickupLocation);
                break;
            default:
                System.out.println("Invalid reservation type selected.");
                return;
        }
        reservation.confirmReservation();
        reservations.add(reservation);
    }

    /**
     * Processes a food order by displaying the restaurant menu and accepting multiple order items.
     * <p>
     * The order ID is automatically generated.
     * </p>
     *
     * @param scanner The Scanner object used for user input.
     */
    private static void placeOrder(Scanner scanner) {
        // Order ID is automatically generated; no need to prompt for it.
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        Order order = new Order(customerName);

        boolean addMore = true;
        while (addMore) {
            System.out.println("\n=== Restaurant Menu ===");
            for (MenuItem item : menuItems) {
                System.out.println(item.toString());
            }
            System.out.print("Enter Menu Item ID to order: ");
            String menuItemId = scanner.nextLine();
            MenuItem selectedItem = null;
            for (MenuItem item : menuItems) {
                if (item.getId().equals(menuItemId)) {
                    selectedItem = item;
                    break;
                }
            }
            if (selectedItem == null) {
                System.out.println("Invalid Menu Item ID. Please try again.");
                continue;
            }
            System.out.print("Enter Quantity: ");
            int quantity = 0;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format for quantity. " + e.getMessage());
                continue;
            }

            OrderItem orderItem = new OrderItem(selectedItem.getName(), quantity, selectedItem.getPrice());
            order.addItem(orderItem);

            System.out.print("Add another item? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                addMore = false;
            }
        }
        System.out.println("Order placed successfully!");
        order.displayOrder();
        orders.add(order);
    }

    /**
     * Displays all the reservations made.
     */
    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("\n=== Reservations List ===");
            for (Reservation res : reservations) {
                if (res instanceof DineInReservation) {
                    DineInReservation dineIn = (DineInReservation) res;
                    System.out.println("Dine-In Reservation - ID: " + dineIn.getReservationId()
                            + ", Customer: " + dineIn.getCustomerName()
                            + ", Guests: " + dineIn.getNumberOfGuests()
                            + ", Time: " + dineIn.getReservationTime()
                            + ", Table: " + dineIn.getTableNumber());
                } else if (res instanceof TakeawayReservation) {
                    TakeawayReservation takeaway = (TakeawayReservation) res;
                    System.out.println("Takeaway Order - ID: " + takeaway.getReservationId()
                            + ", Customer: " + takeaway.getCustomerName()
                            + ", Guests: " + takeaway.getNumberOfGuests()
                            + ", Pickup Location: " + takeaway.getPickupLocation());
                }
            }
            System.out.println();
        }
    }

    /**
     * Displays all the orders placed.
     */
    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("\n=== Orders List ===");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getOrderId()
                        + ", Customer: " + order.getCustomerName());
                for (OrderItem item : order.getItems()) {
                    System.out.println("  " + item.getItemName() + " x " + item.getQuantity()
                            + " @ $" + item.getPrice() + " each");
                }
                System.out.println();
            }
        }
    }
}