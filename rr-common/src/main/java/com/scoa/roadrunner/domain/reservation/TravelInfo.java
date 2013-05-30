package com.scoa.roadrunner.domain.reservation;

import com.scoa.roadrunner.domain.shared.Address;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.io.Serializable;


public class TravelInfo implements Serializable {

    private DateTime date;
    private String cancel;
    private String service;
    private String serviceIdNew;
    private String passengerCount;
    private String complex;

    private Address address = new Address();
    private String directions;
    private String origin;   // this maps to "flyingTo" when departing, and origin when arrival
    private String airport;
    private String ap;// do not pass anything
    private String airlineCount;// pass 1
    private String flightNumber;

    private String airlineName;
    private String pickUpTime;//05/22/2013 10:30 AM
    private String chartered;
    private String specialServiceId;
    private String gratuity;
    private String flightRegion;
    private String flightRegionSelection;
    private String hourFlight;
    private String minuteFlight;
    private String amOrPm;
    private String flightTimeAmPm;
    private String airlineId;

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    private DateTime timeOfTravel; // Can be arrival or departure

    public String getFlightTimeAmPm() {
        return flightTimeAmPm;
    }

    public void setFlightTimeAmPm(String flightTimeAmPm) {
        this.flightTimeAmPm = flightTimeAmPm;
    }

    public DateTime getTimeOfTravel() {
        return timeOfTravel;
    }

    public void setTimeOfTravel(DateTime timeOfTravel) {
        this.timeOfTravel = timeOfTravel;
    }

    public String getHourFlight() {
        return hourFlight;
    }

    public void setHourFlight(String hourFlight) {
        this.hourFlight = hourFlight;
    }

    public String getMinuteFlight() {
        return minuteFlight;
    }

    public void setMinuteFlight(String minuteFlight) {
        this.minuteFlight = minuteFlight;
    }

    public String getAmOrPm() {
        return amOrPm;
    }

    public void setAmOrPm(String amOrPm) {
        this.amOrPm = amOrPm;
    }

    public String getFlightRegionSelection() {
        return flightRegionSelection;
    }

    public void setFlightRegionSelection(String flightRegionSelection) {
        this.flightRegionSelection = flightRegionSelection;
    }

    public String getFlightRegion() {
        return flightRegion;
    }

    public void setFlightRegion(String flightRegion) {
        this.flightRegion = flightRegion;
    }

    public String getGratuity() {
        return gratuity;
    }

    public void setGratuity(String gratuity) {
        this.gratuity = gratuity;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceIdNew() {
        return serviceIdNew;
    }

    public void setServiceIdNew(String serviceIdNew) {
        this.serviceIdNew = serviceIdNew;
    }

    public String getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(String passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getComplex() {
        return complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAirlineCount() {
        return airlineCount;
    }

    public void setAirlineCount(String airlineCount) {
        this.airlineCount = airlineCount;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getChartered() {
        return chartered;
    }

    public void setChartered(String chartered) {
        this.chartered = chartered;
    }

    public String getSpecialServiceId() {
        return specialServiceId;
    }

    public void setSpecialServiceId(String specialServiceId) {
        this.specialServiceId = specialServiceId;
    }
}
