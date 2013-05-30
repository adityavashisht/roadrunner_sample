package com.scoa.roadrunner.common.payload;

import java.io.Serializable;


/**
 *
 *
 */
public class ReservationFareRequest implements Serializable {

    private String airportCode;
    private boolean isArrival;
    private String passengerCount;
    private String dateOfTravel;
    private String discAmount;
    private String zipCode;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public boolean isArrival() {
        return isArrival;
    }

    public void setArrival(boolean arrival) {
        isArrival = arrival;
    }

    public String getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(String passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getDiscAmount() {
        return discAmount;
    }

    public void setDiscAmount(String discAmount) {
        this.discAmount = discAmount;
    }
}
