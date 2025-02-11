package com.restaurant;

import java.util.Scanner;

/**
 * Entry point for the Restaurant Reservation
 * and Order System command-line application.
 *
 * <p>This application allows users to create dine-in reservations, place
 * takeaway orders (with no fixed reservation time), and place food orders.</p>
 *
 * @author Anurup Chandra Mondal
 */
public class Main {

    /**
     * The main method starts the application and provides a command-line interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("==================================");
            System.out.println("Restaurant Reservation and Order System");
            System.out.println("1. Create Reservation/Order");
            System.out.println("2. Place Order");
            System.out.println("3. Exit");
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

        switch (resType) {
            case "1": // Dine-In Reservation
                System.out.print("Enter Reservation Time (e.g., 7:00 PM): ");
                String reservationTime = scanner.nextLine();
                System.out.print("Enter Table Number: ");
                int tableNumber = Integer.parseInt(scanner.nextLine());
                Reservation dineIn = new DineInReservation(
                        reservationId, customerName, numberOfGuests, reservationTime, tableNumber);
                dineIn.confirmReservation();
                break;
            case "2": // Takeaway Order
                // For takeaway orders, no need for a reservation time.
                // Set to a default value like "Anytime".
                String defaultTime = "Anytime";
                System.out.print("Enter Pickup Location: ");
                String pickupLocation = scanner.nextLine();
                Reservation takeaway = new TakeawayReservation(
                        reservationId, customerName, numberOfGuests, defaultTime, pickupLocation);
                takeaway.confirmReservation();
                break;
            default:
                System.out.println("Invalid reservation type selected.");
        }
    }

    /**
     * Processes a food order by accepting multiple order items.
     *
     * @param scanner The Scanner object used for user input.
     */
    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        Order order = new Order(orderId, customerName);

        boolean addMore = true;
        while (addMore) {
            try {
                System.out.print("Enter Item Name: ");
                String itemName = scanner.nextLine();
                System.out.print("Enter Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Price per Item: ");
                double price = Double.parseDouble(scanner.nextLine());

                OrderItem item = new OrderItem(itemName, quantity, price);
                order.addItem(item);

                System.out.print("Add another item? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    addMore = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. " + e.getMessage());
            }
        }
        System.out.println("Order placed successfully!");
        order.displayOrder();
    }
}