package com.scoa.roadrunner.domain.reservation;

import com.scoa.roadrunner.domain.shared.ContactInformation;

import java.io.Serializable;

public class TravelerInfo implements Serializable {
    private String travelerId;
    private ContactInformation contactInformation = new ContactInformation();
    private String customerId;
    private String customerType;
    private String numberBags;
    private String oversizeBags;

    public String getNumberBags() {
        return numberBags;
    }

    public void setNumberBags(String numberBags) {
        this.numberBags = numberBags;
    }

    public String getOversizeBags() {
        return oversizeBags;
    }

    public void setOversizeBags(String oversizeBags) {
        this.oversizeBags = oversizeBags;
    }

    public String getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(String travelerId) {
        this.travelerId = travelerId;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
