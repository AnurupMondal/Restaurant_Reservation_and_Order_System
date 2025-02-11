package com.restaurant;

/**
 * Class representing a dine-in reservation.
 * <p>
 * Has basic reservation details, also includes the table number.
 * </p>
 */
public class DineInReservation extends Reservation {
    private int tableNumber;

    /**
     * Constructs a new DineInReservation.
     *
     * @param reservationId   The unique identifier for the reservation.
     * @param customerName    The name of the customer.
     * @param numberOfGuests  The number of guests.
     * @param reservationTime The time of the reservation.
     * @param tableNumber     The table number assigned to the reservation.
     */
    public DineInReservation(String reservationId, String customerName, int numberOfGuests, String reservationTime, int tableNumber) {
        super(reservationId, customerName, numberOfGuests, reservationTime);
        this.tableNumber = tableNumber;
    }

    /**
     * @return The table number.
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * @param tableNumber The table number to set.
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Confirms the dine-in reservation by displaying the details.
     */
    @Override
    public void confirmReservation() {
        System.out.println("\n=== Dine-In Reservation Confirmed! ===");
        System.out.println("Reservation ID: " + getReservationId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Number of Guests: " + getNumberOfGuests());
        System.out.println("Reservation Time: " + getReservationTime());
        System.out.println("Table Number: " + tableNumber + "\n");
    }
}
