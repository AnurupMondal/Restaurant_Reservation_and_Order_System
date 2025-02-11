package com.restaurant;

/**
 * An abstract class representing a general reservation.
 * <p>
 * This class encapsulates the common properties for reservations
 * and defines an abstract method for confirming the reservation.
 * </p>
 */
public abstract class Reservation {
    private String reservationId;
    private String customerName;
    private int numberOfGuests;
    private String reservationTime;

    /**
     * Constructs a new Reservation.
     *
     * @param reservationId   The unique identifier for the reservation.
     * @param customerName    The name of the customer.
     * @param numberOfGuests  The number of guests.
     * @param reservationTime The time of the reservation.
     */
    public Reservation(String reservationId, String customerName, int numberOfGuests, String reservationTime) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.numberOfGuests = numberOfGuests;
        this.reservationTime = reservationTime;
    }

    /**
     * @return The reservation ID.
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * @return The customer name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return The number of guests.
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * @return The reservation time.
     */
    public String getReservationTime() {
        return reservationTime;
    }

    /**
     * Confirms the reservation.
     * <p>
     * Subclasses must provide their specific implementation for confirming a reservation.
     * </p>
     */
    public abstract void confirmReservation();
}
