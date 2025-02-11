package com.restaurant;

/**
 * A concrete class representing a takeaway order.
 * <p>
 * Takeaway orders do not require a specific reservation time;
 * instead, they are set to a default time ("Anytime") and require a pickup location.
 * </p>
 */
public class TakeawayReservation extends Reservation {
    private String pickupLocation;

    /**
     * Constructs a new TakeawayReservation.
     *
     * @param reservationId   The unique identifier for the order.
     * @param customerName    The name of the customer.
     * @param numberOfGuests  The number of guests (or items if applicable).
     * @param reservationTime The default reservation time, typically set to "Anytime".
     * @param pickupLocation  The pickup location for the order.
     */
    public TakeawayReservation(String reservationId, String customerName, int numberOfGuests, String reservationTime, String pickupLocation) {
        super(reservationId, customerName, numberOfGuests, reservationTime);
        this.pickupLocation = pickupLocation;
    }

    /**
     * Returns the pickup location.
     *
     * @return The pickup location.
     */
    public String getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Sets the pickup location.
     *
     * @param pickupLocation The pickup location to set.
     */
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * Confirms the takeaway order by displaying the details.
     * The confirmation message indicates that the order can be picked up at any time.
     */
    @Override
    public void confirmReservation() {
        System.out.println("\n=== Takeaway Order Confirmed! ===");
        System.out.println("Order ID: " + getReservationId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Number of Guests: " + getNumberOfGuests());
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Note: No reservation time required. Collect your order at your convenience.\n");
    }
}
