package com.scoa.roadrunner.domain.shared;



import org.springframework.util.StringUtils;

import java.io.Serializable;

public class Address implements Serializable {

    private String addressLine;
    private String streetNumber;
    private String city;
    private String zip;
    private String state;
    private String countryCode;
    private String companyName;
    private String wpNumber;
    private String landMarkName;
    private String crossStreetAndOSIDetail;
    private String unitName;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getCrossStreetAndOSIDetail() {
        return crossStreetAndOSIDetail;
    }

    public void setCrossStreetAndOSIDetail(String crossStreetAndOSIDetail) {
        this.crossStreetAndOSIDetail = crossStreetAndOSIDetail;
    }

    public String getLandMarkName() {
        return landMarkName;
    }

    public void setLandMarkName(String landMarkName) {
        this.landMarkName = landMarkName;
    }

    public String getWpNumber() {
        return wpNumber;
    }

    public void setWpNumber(String wpNumber) {
        this.wpNumber = wpNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }




    public String getFullAddressForDisplay() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.hasText(getAddressLine())) {
            sb.append(getAddressLine());
        }
        if (StringUtils.hasText(getCity())) {
            sb.append(", ");
            sb.append(getCity());
        }

        if (StringUtils.hasText(getState())) {
            sb.append(", ");
            sb.append(getState());
        }


        if (StringUtils.hasText(getZip())) {
            sb.append(", ");
            sb.append(getZip());
        }
        return sb.toString();
    }
}
