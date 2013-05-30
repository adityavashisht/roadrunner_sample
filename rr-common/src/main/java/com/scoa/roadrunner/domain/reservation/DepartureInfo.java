package com.scoa.roadrunner.domain.reservation;


import java.io.Serializable;

public class DepartureInfo implements Serializable {
    private TravelInfo travelInfo = new TravelInfo();

    public TravelInfo getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(TravelInfo travelInfo) {
        this.travelInfo = travelInfo;
    }
}
