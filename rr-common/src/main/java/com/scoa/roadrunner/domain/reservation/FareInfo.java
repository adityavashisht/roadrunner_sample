package com.scoa.roadrunner.domain.reservation;

import java.io.Serializable;
import java.math.BigDecimal;


public class FareInfo implements Serializable {
    private BigDecimal redemptionAmount;
    private BigDecimal specialServiceAmount;
    private BigDecimal departureFee;
    private BigDecimal departureGratuity;
    private BigDecimal arrivalFee;
    private BigDecimal arrivalGratuity;
    private BigDecimal discountAmount;
    private String discountCode;
    private String discount;
    private String surcharge;


    public BigDecimal getRedemptionAmount() {
        return redemptionAmount;
    }

    public void setRedemptionAmount(BigDecimal redemptionAmount) {
        this.redemptionAmount = redemptionAmount;
    }

    public BigDecimal getSpecialServiceAmount() {
        return specialServiceAmount;
    }

    public void setSpecialServiceAmount(BigDecimal specialServiceAmount) {
        this.specialServiceAmount = specialServiceAmount;
    }

    public BigDecimal getDepartureFee() {
        return departureFee;
    }

    public void setDepartureFee(BigDecimal departureFee) {
        this.departureFee = departureFee;
    }

    public BigDecimal getDepartureGratuity() {
        return departureGratuity;
    }

    public void setDepartureGratuity(BigDecimal departureGratuity) {
        this.departureGratuity = departureGratuity;
    }

    public BigDecimal getArrivalFee() {
        return arrivalFee;
    }

    public void setArrivalFee(BigDecimal arrivalFee) {
        this.arrivalFee = arrivalFee;
    }

    public BigDecimal getArrivalGratuity() {
        return arrivalGratuity;
    }

    public void setArrivalGratuity(BigDecimal arrivalGratuity) {
        this.arrivalGratuity = arrivalGratuity;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }
}
