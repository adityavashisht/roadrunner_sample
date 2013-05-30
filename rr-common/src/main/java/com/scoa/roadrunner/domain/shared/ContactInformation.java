package com.scoa.roadrunner.domain.shared;


import java.io.Serializable;

public class ContactInformation implements Serializable {

    private String firstName;
    private String lastName;
    private Address address = new Address();
    private Address alternateAddress = new Address();
    private HomePhone homePhone = new HomePhone();
    private WorkPhone workPhone = new WorkPhone();
    private CellPhone cellPhone = new CellPhone();
    private FaxPhone faxPhone = new FaxPhone();
    private String email;
    private String emergencyContactName;
    private String emergencyContactPhone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FaxPhone getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(FaxPhone faxPhone) {
        this.faxPhone = faxPhone;
    }

    public Address getAlternateAddress() {
        return alternateAddress;
    }

    public void setAlternateAddress(Address alternateAddress) {
        this.alternateAddress = alternateAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HomePhone getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(HomePhone homePhone) {
        this.homePhone = homePhone;
    }

    public WorkPhone getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(WorkPhone workPhone) {
        this.workPhone = workPhone;
    }

    public CellPhone getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(CellPhone cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
}

