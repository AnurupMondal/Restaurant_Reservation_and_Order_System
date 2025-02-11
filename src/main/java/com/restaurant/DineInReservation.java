package com.restaurant;

public class DineInReservation extends Reservation{
    private int tableNumber;
    public DineInReservation(String reservationId, String customerName, int numberOfPeople, String reservationTime, int tableNumber) {
        super(reservationId, customerName, numberOfPeople, reservationTime);
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

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
