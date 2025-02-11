package com.restaurant;

public abstract class Reservation{
    private String reservationId;
    private String customerName;
    private int numberOfGuests;
    private String reservationTime;

    public Reservation(String reservationId, String customerName, int numberOfGuests, String reservationTime) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.numberOfGuests = numberOfGuests;
        this.reservationTime = reservationTime;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfGuests(){
        return numberOfGuests;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public abstract void confirmReservation();

}