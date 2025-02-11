package com.restaurant;

public abstract class Reservation{
    private String reservationId;
    private String customerName;
    private int numberOfPeople;
    private String reervationTime;

    public Reservation(String reservationId, String customerName, int numberOfPeople, String reervationTime) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.numberOfPeople = numberOfPeople;
        this.reervationTime = reervationTime;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getReservationTime() {
        return reervationTime;
    }

    public abstract void confirmReservation();

}