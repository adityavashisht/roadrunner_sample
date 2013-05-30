package com.scoa.roadrunner.web.flow.reservation;


import com.scoa.roadrunner.common.payload.SaveReservationRequest;


import com.scoa.roadrunner.common.payload.SaveReservationResponse;
import com.scoa.roadrunner.domain.reservation.FareInfo;
import com.scoa.roadrunner.domain.reservation.RequestCommonInfo;

import java.io.Serializable;


public class ReservationForm implements Serializable {

    private RequestCommonInfo requestCommonInfo;

    private RouteStepOne routeStepOne;
    private RouteStepTwo routeStepTwo;
    private RouteStepThree routeStepThree;
    private FareInfo fareInfo;

    private SaveReservationResponse reservationResponse;
    private SaveReservationRequest saveReservationRequest;

    public ReservationForm() {
        routeStepOne = new RouteStepOne();
        routeStepTwo = new RouteStepTwo();
        routeStepThree = new RouteStepThree();
        requestCommonInfo = new RequestCommonInfo();
        fareInfo = new FareInfo();
        saveReservationRequest = new SaveReservationRequest();
        reservationResponse = new SaveReservationResponse();
    }

    public SaveReservationResponse getReservationResponse() {
        return reservationResponse;
    }

    public void setReservationResponse(SaveReservationResponse reservationResponse) {
        this.reservationResponse = reservationResponse;
    }

    public SaveReservationRequest getSaveReservationRequest() {
        return saveReservationRequest;
    }

    public void setSaveReservationRequest(SaveReservationRequest saveReservationRequest) {
        this.saveReservationRequest = saveReservationRequest;
    }

    public FareInfo getFareInfo() {
        return fareInfo;
    }

    public void setFareInfo(FareInfo fareInfo) {
        this.fareInfo = fareInfo;
    }

    public RouteStepThree getRouteStepThree() {
        return routeStepThree;
    }

    public void setRouteStepThree(RouteStepThree routeStepThree) {
        this.routeStepThree = routeStepThree;
    }

    public RequestCommonInfo getRequestCommonInfo() {
        return requestCommonInfo;
    }

    public void setRequestCommonInfo(RequestCommonInfo requestCommonInfo) {
        this.requestCommonInfo = requestCommonInfo;
    }

    public RouteStepOne getRouteStepOne() {
        return routeStepOne;
    }

    public void setRouteStepOne(RouteStepOne routeStepOne) {
        this.routeStepOne = routeStepOne;
    }

    public RouteStepTwo getRouteStepTwo() {
        return routeStepTwo;
    }

    public void setRouteStepTwo(RouteStepTwo routeStepTwo) {
        this.routeStepTwo = routeStepTwo;
    }
}
