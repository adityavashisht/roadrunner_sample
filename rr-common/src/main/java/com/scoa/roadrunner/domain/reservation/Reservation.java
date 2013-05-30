package com.scoa.roadrunner.domain.reservation;

import java.io.Serializable;


public class Reservation implements Serializable {
    private TravelerInfo travelerInfo;
    private ArrivalInfo arrivalInfo;
    private DepartureInfo departureInfo;
    private FareInfo fareInfo;
    private PaymentInfo paymentInfo;
    private RequestCommonInfo requestCommonInfo;
    private RouteType routeType;
    private DirectionType directionType;

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
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

    public DepartureInfo getDepartureInfo() {
        return departureInfo;
    }

    public FareInfo getFareInfo() {
        return fareInfo;
    }

    public RequestCommonInfo getRequestCommonInfo() {
        return requestCommonInfo;
    }

    public void setArrivalInfo(ArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }

    public void setDepartureInfo(DepartureInfo departureInfo) {
        this.departureInfo = departureInfo;
    }

    public void setFareInfo(FareInfo fareInfo) {
        this.fareInfo = fareInfo;
    }

    public void setRequestCommonInfo(RequestCommonInfo requestCommonInfo) {
        this.requestCommonInfo = requestCommonInfo;
    }
}
