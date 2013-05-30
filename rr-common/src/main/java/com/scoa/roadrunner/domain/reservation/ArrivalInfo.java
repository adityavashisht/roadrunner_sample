package com.scoa.roadrunner.domain.reservation;



import java.io.Serializable;

public class ArrivalInfo implements Serializable {
   private TravelInfo travelInfo;

    public ArrivalInfo() {
        travelInfo = new TravelInfo();
    }

    public TravelInfo getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(TravelInfo travelInfo) {
        this.travelInfo = travelInfo;
    }
}
