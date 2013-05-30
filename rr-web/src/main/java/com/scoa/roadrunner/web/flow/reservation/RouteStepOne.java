package com.scoa.roadrunner.web.flow.reservation;

import com.scoa.roadrunner.domain.reservation.DirectionType;
import com.scoa.roadrunner.domain.reservation.RouteType;
import com.scoa.roadrunner.domain.reservation.ZipOrLandMarkSelect;
import org.joda.time.LocalDateTime;
import org.springframework.util.StringUtils;

import java.io.Serializable;


public class RouteStepOne implements Serializable {

    private RouteType routeType;
    private DirectionType directionType;
    private ZipOrLandMarkSelect zipOrLandMarkSelect;
    private String zipCode;
    private String landmark;
    private String promotionCode;
    private String airport;
    private LocalDateTime dateofTravel;
    private String airportDisplayValue;
    private String airportZipCode;

    private boolean differentPassengerCount;
    private Integer onwardAdultCount;
    private Integer onwardChildCount;
    private Integer returnAdultCount;
    private Integer returnChildCount;


    public String getAirportZipCode() {
        return airportZipCode;
    }

    public void setAirportZipCode(String airportZipCode) {
        this.airportZipCode = airportZipCode;
    }


    public String getAirportDisplayValue() {
        return airportDisplayValue;
    }

    public void setAirportDisplayValue(String airportDisplayValue) {
        this.airportDisplayValue = airportDisplayValue;
    }

    public LocalDateTime getDateofTravel() {
        return dateofTravel;
    }

    public void setDateofTravel(LocalDateTime dateofTravel) {
        this.dateofTravel = dateofTravel;
    }

    public String getSystemError() {
        return systemError;
    }

    public void setSystemError(String systemError) {
        this.systemError = systemError;
    }

    private boolean wheelChairAccessNeeded;
    private String systemError;



    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

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

    public ZipOrLandMarkSelect getZipOrLandMarkSelect() {
        return zipOrLandMarkSelect;
    }

    public void setZipOrLandMarkSelect(ZipOrLandMarkSelect zipOrLandMarkSelect) {
        this.zipOrLandMarkSelect = zipOrLandMarkSelect;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public boolean isDifferentPassengerCount() {
        return differentPassengerCount;
    }

    public void setDifferentPassengerCount(boolean differentPassengerCount) {
        this.differentPassengerCount = differentPassengerCount;
    }

    public Integer getOnwardAdultCount() {
        return onwardAdultCount;
    }

    public void setOnwardAdultCount(Integer onwardAdultCount) {
        this.onwardAdultCount = onwardAdultCount;
    }

    public Integer getOnwardChildCount() {
        return onwardChildCount;
    }

    public void setOnwardChildCount(Integer onwardChildCount) {
        this.onwardChildCount = onwardChildCount;
    }

    public Integer getReturnAdultCount() {
        return returnAdultCount;
    }

    public void setReturnAdultCount(Integer returnAdultCount) {
        this.returnAdultCount = returnAdultCount;
    }

    public Integer getReturnChildCount() {
        return returnChildCount;
    }

    public void setReturnChildCount(Integer returnChildCount) {
        this.returnChildCount = returnChildCount;
    }

    public boolean isWheelChairAccessNeeded() {
        return wheelChairAccessNeeded;
    }

    public void setWheelChairAccessNeeded(boolean wheelChairAccessNeeded) {
        this.wheelChairAccessNeeded = wheelChairAccessNeeded;
    }



    public String getTotalPassengerCount() {
        Integer count = 0;
        if (onwardAdultCount != null) {
            count += onwardAdultCount;
        }
        if (onwardChildCount != null) {
            count += onwardChildCount;
        }

        // Add passengers only for return trip
        if (DirectionType.ROUND_TRIP.equals(directionType) && differentPassengerCount) {
            if (returnAdultCount != null) {
                count += returnAdultCount;
            }
            if (returnChildCount != null) {
                count += returnChildCount;
            }

        }

        return count.toString();
    }
}
