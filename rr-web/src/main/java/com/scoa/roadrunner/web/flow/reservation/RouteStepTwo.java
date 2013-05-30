package com.scoa.roadrunner.web.flow.reservation;

import com.scoa.roadrunner.common.dto.ReservationFare;
import com.scoa.roadrunner.domain.reservation.ArrivalInfo;
import com.scoa.roadrunner.domain.reservation.DepartureInfo;
import com.scoa.roadrunner.domain.reservation.TravelerInfo;

import java.io.Serializable;


public class RouteStepTwo implements Serializable {

    private ReservationFare reservationFare;
    private ArrivalInfo arrivalInfo;
    private DepartureInfo departureInfo;
    private TravelerInfo travelerInfo;

    private String pickUpTime;
    private String amOrPm;
    private String flightTimeAmPm;
    private String timeToTravel;
    private String pickUpTimeHourMinuteOnly;

    private String departureAmPm;
    private String departurePickUpTime;
    private String departureFlightTimeAmPm;
    private String departurePickUpTimeHourMinuteOnly;
    private String departureTimeToTravel;

    public String getDepartureAmPm() {
        return departureAmPm;
    }

    public void setDepartureAmPm(String departureAmPm) {
        this.departureAmPm = departureAmPm;
    }

    public String getDeparturePickUpTime() {
        return departurePickUpTime;
    }

    public void setDeparturePickUpTime(String departurePickUpTime) {
        this.departurePickUpTime = departurePickUpTime;
    }

    public String getDepartureFlightTimeAmPm() {
        return departureFlightTimeAmPm;
    }

    public void setDepartureFlightTimeAmPm(String departureFlightTimeAmPm) {
        this.departureFlightTimeAmPm = departureFlightTimeAmPm;
    }

    public String getDeparturePickUpTimeHourMinuteOnly() {
        return departurePickUpTimeHourMinuteOnly;
    }

    public void setDeparturePickUpTimeHourMinuteOnly(String departurePickUpTimeHourMinuteOnly) {
        this.departurePickUpTimeHourMinuteOnly = departurePickUpTimeHourMinuteOnly;
    }

    public String getDepartureTimeToTravel() {
        return departureTimeToTravel;
    }

    public void setDepartureTimeToTravel(String departureTimeToTravel) {
        this.departureTimeToTravel = departureTimeToTravel;
    }

    public RouteStepTwo() {
        reservationFare = new ReservationFare();
        arrivalInfo = new ArrivalInfo();
        departureInfo = new DepartureInfo();
        travelerInfo = new TravelerInfo();
    }

    public String getFlightTimeAmPm() {
        return flightTimeAmPm;
    }

    public void setFlightTimeAmPm(String flightTimeAmPm) {
        this.flightTimeAmPm = flightTimeAmPm;
    }

    public String getPickUpTimeHourMinuteOnly() {
        return pickUpTimeHourMinuteOnly;
    }

    public void setPickUpTimeHourMinuteOnly(String pickUpTimeHourMinuteOnly) {
        this.pickUpTimeHourMinuteOnly = pickUpTimeHourMinuteOnly;
    }

    public String getTimeToTravel() {
        return timeToTravel;
    }

    public void setTimeToTravel(String timeToTravel) {
        this.timeToTravel = timeToTravel;
    }

    public String getAmOrPm() {
        return amOrPm;
    }

    public void setAmOrPm(String amOrPm) {
        this.amOrPm = amOrPm;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public TravelerInfo getTravelerInfo() {
        return travelerInfo;
    }

    public void setTravelerInfo(TravelerInfo travelerInfo) {
        this.travelerInfo = travelerInfo;
    }

    public ArrivalInfo getArrivalInfo() {
        return arrivalInfo;
    }

    public void setArrivalInfo(ArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }

    public DepartureInfo getDepartureInfo() {
        return departureInfo;
    }

    public void setDepartureInfo(DepartureInfo departureInfo) {
        this.departureInfo = departureInfo;
    }

    public ReservationFare getReservationFare() {
        return reservationFare;
    }

    public void setReservationFare(ReservationFare reservationFare) {
        this.reservationFare = reservationFare;
    }
}
