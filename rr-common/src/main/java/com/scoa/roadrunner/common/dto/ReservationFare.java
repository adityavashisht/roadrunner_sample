package com.scoa.roadrunner.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class ReservationFare implements Serializable {

    private BigDecimal amount;
    private BigDecimal totalAmountWithGratuity;
    private Long passengerCount;
    private String serviceId;
    private String vehicleType;
    private BigDecimal gratuityAmount;
    private String gratuityPercentage;

    public ReservationFare() {
        gratuityPercentage = "0";
    }

    public String getGratuityPercentage() {
        return gratuityPercentage;
    }

    public void setGratuityPercentage(String gratuityPercentage) {
        this.gratuityPercentage = gratuityPercentage;
    }

    public BigDecimal getTotalAmountWithGratuity() {
        return totalAmountWithGratuity;
    }

    public void setTotalAmountWithGratuity(BigDecimal totalAmountWithGratuity) {
        this.totalAmountWithGratuity = totalAmountWithGratuity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Long passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BigDecimal getGratuityAmount() {
        return gratuityAmount;
    }

    public void setGratuityAmount(BigDecimal gratuityAmount) {
        this.gratuityAmount = gratuityAmount;
    }
}
