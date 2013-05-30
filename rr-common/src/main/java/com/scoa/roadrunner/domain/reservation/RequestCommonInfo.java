package com.scoa.roadrunner.domain.reservation;

import java.io.Serializable;


public class RequestCommonInfo implements Serializable {
    private boolean sendEmail;
    private String mailToAddress;
    private String clientId;
    private FlightType flightType;
    private String specialServicesJourney;
    private String ipAddress;
    private String resType; // 1 to be hard coded, not sure what this means
    private String couponEmail;
    private String userName;// The user that requested this reservation
    private String isWindowsId;// 0
    private String specialInstructions;
    private String resType1;
    private String resTypeDetail;
    private String requestType;
    private String infoId;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getMailToAddress() {
        return mailToAddress;
    }

    public void setMailToAddress(String mailToAddress) {
        this.mailToAddress = mailToAddress;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public String getSpecialServicesJourney() {
        return specialServicesJourney;
    }

    public void setSpecialServicesJourney(String specialServicesJourney) {
        this.specialServicesJourney = specialServicesJourney;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getCouponEmail() {
        return couponEmail;
    }

    public void setCouponEmail(String couponEmail) {
        this.couponEmail = couponEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWindowsId() {
        return isWindowsId;
    }

    public void setWindowsId(String windowsId) {
        isWindowsId = windowsId;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getResType1() {
        return resType1;
    }

    public void setResType1(String resType1) {
        this.resType1 = resType1;
    }

    public String getResTypeDetail() {
        return resTypeDetail;
    }

    public void setResTypeDetail(String resTypeDetail) {
        this.resTypeDetail = resTypeDetail;
    }
}
