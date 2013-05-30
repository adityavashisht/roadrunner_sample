
package com.scoa.roadrunner.connector.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravellerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvPassenger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvPickupTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvGratuity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Conf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialServiceamt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialServiceIDArv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RedemptionAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCCID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReqType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfoID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PmtMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PMTDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISWindowID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialServicesJourneyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravelerFName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravelerLName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravelerHomePhno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravelerWorkPhno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Travelercellno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepPickUp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvStreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepStreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvDirections" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepDirections" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComplexArv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComplexDep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvFlt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepFlt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepPickupTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arvFltTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepFltTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvAirline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepAirline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FltType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FlyingTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepPassenger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepGratuity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surcharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TravelerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specialinst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Restype1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Restypedetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReqArvTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsSendEmail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MailTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CharterDep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CharterArv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialServiceIDDep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepServiceidNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvServiceidNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvCancel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepCancel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CouponEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "custID",
    "travellerID",
    "custType",
    "resType",
    "arvDate",
    "arvAirport",
    "arvPassenger",
    "arvPickupTime",
    "arvFee",
    "arvGratuity",
    "discount",
    "conf",
    "specialServiceamt",
    "arvService",
    "arvZip",
    "specialServiceIDArv",
    "redemptionAmt",
    "cardType",
    "ccNum",
    "cCname",
    "ccExpDate",
    "cccid",
    "ccTypeID",
    "cZip",
    "reqType",
    "infoID",
    "pmtMode",
    "pmtDetails",
    "isWindowID",
    "arvCity",
    "specialServicesJourneyType",
    "travelerFName",
    "travelerLName",
    "travelerHomePhno",
    "travelerWorkPhno",
    "travelercellno",
    "ip",
    "depZip",
    "depService",
    "depPickUp",
    "arvStreetNumber",
    "depStreetNumber",
    "arvStreet",
    "depStreet",
    "arvUnit",
    "depUnit",
    "arvDirections",
    "depDirections",
    "complexArv",
    "complexDep",
    "arvAP",
    "depAP",
    "arvFlt",
    "depFlt",
    "depPickupTime",
    "arvFltTime",
    "depFltTime",
    "arvAirline",
    "depAirline",
    "fltType",
    "origin",
    "flyingTo",
    "depPassenger",
    "depDate",
    "depCity",
    "depFee",
    "depGratuity",
    "surcharge",
    "travelerEmail",
    "specialinst",
    "restype1",
    "restypedetail",
    "billTo",
    "reqArvTime",
    "isSendEmail",
    "mailTo",
    "charterDep",
    "charterArv",
    "clientId",
    "specialServiceIDDep",
    "depServiceidNew",
    "arvServiceidNew",
    "arvCancel",
    "depCancel",
    "couponEmail",
    "discCode",
    "discAmt"
})
@XmlRootElement(name = "SaveReservation")
public class SaveReservation {

    @XmlElement(name = "CustID")
    protected String custID;
    @XmlElement(name = "TravellerID")
    protected String travellerID;
    @XmlElement(name = "CustType")
    protected String custType;
    @XmlElement(name = "ResType")
    protected String resType;
    @XmlElement(name = "ArvDate")
    protected String arvDate;
    @XmlElement(name = "ArvAirport")
    protected String arvAirport;
    @XmlElement(name = "ArvPassenger")
    protected String arvPassenger;
    @XmlElement(name = "ArvPickupTime")
    protected String arvPickupTime;
    @XmlElement(name = "ArvFee")
    protected String arvFee;
    @XmlElement(name = "ArvGratuity")
    protected String arvGratuity;
    @XmlElement(name = "Discount")
    protected String discount;
    @XmlElement(name = "Conf")
    protected String conf;
    @XmlElement(name = "SpecialServiceamt")
    protected String specialServiceamt;
    @XmlElement(name = "ArvService")
    protected String arvService;
    @XmlElement(name = "ArvZip")
    protected String arvZip;
    @XmlElement(name = "SpecialServiceIDArv")
    protected String specialServiceIDArv;
    @XmlElement(name = "RedemptionAmt")
    protected String redemptionAmt;
    @XmlElement(name = "CardType")
    protected String cardType;
    @XmlElement(name = "CCNum")
    protected String ccNum;
    @XmlElement(name = "CCname")
    protected String cCname;
    @XmlElement(name = "CCExpDate")
    protected String ccExpDate;
    @XmlElement(name = "CCCID")
    protected String cccid;
    @XmlElement(name = "CCTypeID")
    protected String ccTypeID;
    @XmlElement(name = "CZip")
    protected String cZip;
    @XmlElement(name = "ReqType")
    protected String reqType;
    @XmlElement(name = "InfoID")
    protected String infoID;
    @XmlElement(name = "PmtMode")
    protected String pmtMode;
    @XmlElement(name = "PMTDetails")
    protected String pmtDetails;
    @XmlElement(name = "ISWindowID")
    protected String isWindowID;
    @XmlElement(name = "ArvCity")
    protected String arvCity;
    @XmlElement(name = "SpecialServicesJourneyType")
    protected String specialServicesJourneyType;
    @XmlElement(name = "TravelerFName")
    protected String travelerFName;
    @XmlElement(name = "TravelerLName")
    protected String travelerLName;
    @XmlElement(name = "TravelerHomePhno")
    protected String travelerHomePhno;
    @XmlElement(name = "TravelerWorkPhno")
    protected String travelerWorkPhno;
    @XmlElement(name = "Travelercellno")
    protected String travelercellno;
    @XmlElement(name = "IP")
    protected String ip;
    @XmlElement(name = "DepZip")
    protected String depZip;
    @XmlElement(name = "DepService")
    protected String depService;
    @XmlElement(name = "DepPickUp")
    protected String depPickUp;
    @XmlElement(name = "ArvStreetNumber")
    protected String arvStreetNumber;
    @XmlElement(name = "DepStreetNumber")
    protected String depStreetNumber;
    @XmlElement(name = "ArvStreet")
    protected String arvStreet;
    @XmlElement(name = "DepStreet")
    protected String depStreet;
    @XmlElement(name = "ArvUnit")
    protected String arvUnit;
    @XmlElement(name = "DepUnit")
    protected String depUnit;
    @XmlElement(name = "ArvDirections")
    protected String arvDirections;
    @XmlElement(name = "DepDirections")
    protected String depDirections;
    @XmlElement(name = "ComplexArv")
    protected String complexArv;
    @XmlElement(name = "ComplexDep")
    protected String complexDep;
    @XmlElement(name = "ArvAP")
    protected String arvAP;
    @XmlElement(name = "DepAP")
    protected String depAP;
    @XmlElement(name = "ArvFlt")
    protected String arvFlt;
    @XmlElement(name = "DepFlt")
    protected String depFlt;
    @XmlElement(name = "DepPickupTime")
    protected String depPickupTime;
    protected String arvFltTime;
    @XmlElement(name = "DepFltTime")
    protected String depFltTime;
    @XmlElement(name = "ArvAirline")
    protected String arvAirline;
    @XmlElement(name = "DepAirline")
    protected String depAirline;
    @XmlElement(name = "FltType")
    protected String fltType;
    protected String origin;
    @XmlElement(name = "FlyingTo")
    protected String flyingTo;
    @XmlElement(name = "DepPassenger")
    protected String depPassenger;
    @XmlElement(name = "DepDate")
    protected String depDate;
    @XmlElement(name = "DepCity")
    protected String depCity;
    @XmlElement(name = "DepFee")
    protected String depFee;
    @XmlElement(name = "DepGratuity")
    protected String depGratuity;
    @XmlElement(name = "Surcharge")
    protected String surcharge;
    @XmlElement(name = "TravelerEmail")
    protected String travelerEmail;
    protected String specialinst;
    @XmlElement(name = "Restype1")
    protected String restype1;
    @XmlElement(name = "Restypedetail")
    protected String restypedetail;
    @XmlElement(name = "BillTo")
    protected String billTo;
    @XmlElement(name = "ReqArvTime")
    protected String reqArvTime;
    @XmlElement(name = "IsSendEmail")
    protected boolean isSendEmail;
    @XmlElement(name = "MailTo")
    protected String mailTo;
    @XmlElement(name = "CharterDep")
    protected String charterDep;
    @XmlElement(name = "CharterArv")
    protected String charterArv;
    @XmlElement(name = "ClientId")
    protected String clientId;
    @XmlElement(name = "SpecialServiceIDDep")
    protected String specialServiceIDDep;
    @XmlElement(name = "DepServiceidNew")
    protected String depServiceidNew;
    @XmlElement(name = "ArvServiceidNew")
    protected String arvServiceidNew;
    @XmlElement(name = "ArvCancel")
    protected String arvCancel;
    @XmlElement(name = "DepCancel")
    protected String depCancel;
    @XmlElement(name = "CouponEmail")
    protected String couponEmail;
    @XmlElement(name = "DiscCode")
    protected String discCode;
    @XmlElement(name = "DiscAmt")
    protected String discAmt;

    /**
     * Gets the value of the custID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustID() {
        return custID;
    }

    /**
     * Sets the value of the custID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustID(String value) {
        this.custID = value;
    }

    /**
     * Gets the value of the travellerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravellerID() {
        return travellerID;
    }

    /**
     * Sets the value of the travellerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravellerID(String value) {
        this.travellerID = value;
    }

    /**
     * Gets the value of the custType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustType() {
        return custType;
    }

    /**
     * Sets the value of the custType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustType(String value) {
        this.custType = value;
    }

    /**
     * Gets the value of the resType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResType() {
        return resType;
    }

    /**
     * Sets the value of the resType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResType(String value) {
        this.resType = value;
    }

    /**
     * Gets the value of the arvDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvDate() {
        return arvDate;
    }

    /**
     * Sets the value of the arvDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvDate(String value) {
        this.arvDate = value;
    }

    /**
     * Gets the value of the arvAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvAirport() {
        return arvAirport;
    }

    /**
     * Sets the value of the arvAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvAirport(String value) {
        this.arvAirport = value;
    }

    /**
     * Gets the value of the arvPassenger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvPassenger() {
        return arvPassenger;
    }

    /**
     * Sets the value of the arvPassenger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvPassenger(String value) {
        this.arvPassenger = value;
    }

    /**
     * Gets the value of the arvPickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvPickupTime() {
        return arvPickupTime;
    }

    /**
     * Sets the value of the arvPickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvPickupTime(String value) {
        this.arvPickupTime = value;
    }

    /**
     * Gets the value of the arvFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvFee() {
        return arvFee;
    }

    /**
     * Sets the value of the arvFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvFee(String value) {
        this.arvFee = value;
    }

    /**
     * Gets the value of the arvGratuity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvGratuity() {
        return arvGratuity;
    }

    /**
     * Sets the value of the arvGratuity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvGratuity(String value) {
        this.arvGratuity = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * Gets the value of the conf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConf() {
        return conf;
    }

    /**
     * Sets the value of the conf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConf(String value) {
        this.conf = value;
    }

    /**
     * Gets the value of the specialServiceamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialServiceamt() {
        return specialServiceamt;
    }

    /**
     * Sets the value of the specialServiceamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialServiceamt(String value) {
        this.specialServiceamt = value;
    }

    /**
     * Gets the value of the arvService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvService() {
        return arvService;
    }

    /**
     * Sets the value of the arvService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvService(String value) {
        this.arvService = value;
    }

    /**
     * Gets the value of the arvZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvZip() {
        return arvZip;
    }

    /**
     * Sets the value of the arvZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvZip(String value) {
        this.arvZip = value;
    }

    /**
     * Gets the value of the specialServiceIDArv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialServiceIDArv() {
        return specialServiceIDArv;
    }

    /**
     * Sets the value of the specialServiceIDArv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialServiceIDArv(String value) {
        this.specialServiceIDArv = value;
    }

    /**
     * Gets the value of the redemptionAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedemptionAmt() {
        return redemptionAmt;
    }

    /**
     * Sets the value of the redemptionAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedemptionAmt(String value) {
        this.redemptionAmt = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the ccNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCNum() {
        return ccNum;
    }

    /**
     * Sets the value of the ccNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCNum(String value) {
        this.ccNum = value;
    }

    /**
     * Gets the value of the cCname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCname() {
        return cCname;
    }

    /**
     * Sets the value of the cCname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCname(String value) {
        this.cCname = value;
    }

    /**
     * Gets the value of the ccExpDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCExpDate() {
        return ccExpDate;
    }

    /**
     * Sets the value of the ccExpDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCExpDate(String value) {
        this.ccExpDate = value;
    }

    /**
     * Gets the value of the cccid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCCID() {
        return cccid;
    }

    /**
     * Sets the value of the cccid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCCID(String value) {
        this.cccid = value;
    }

    /**
     * Gets the value of the ccTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCTypeID() {
        return ccTypeID;
    }

    /**
     * Sets the value of the ccTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCTypeID(String value) {
        this.ccTypeID = value;
    }

    /**
     * Gets the value of the cZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCZip() {
        return cZip;
    }

    /**
     * Sets the value of the cZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCZip(String value) {
        this.cZip = value;
    }

    /**
     * Gets the value of the reqType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqType() {
        return reqType;
    }

    /**
     * Sets the value of the reqType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqType(String value) {
        this.reqType = value;
    }

    /**
     * Gets the value of the infoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoID() {
        return infoID;
    }

    /**
     * Sets the value of the infoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoID(String value) {
        this.infoID = value;
    }

    /**
     * Gets the value of the pmtMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtMode() {
        return pmtMode;
    }

    /**
     * Sets the value of the pmtMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtMode(String value) {
        this.pmtMode = value;
    }

    /**
     * Gets the value of the pmtDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMTDetails() {
        return pmtDetails;
    }

    /**
     * Sets the value of the pmtDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMTDetails(String value) {
        this.pmtDetails = value;
    }

    /**
     * Gets the value of the isWindowID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISWindowID() {
        return isWindowID;
    }

    /**
     * Sets the value of the isWindowID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISWindowID(String value) {
        this.isWindowID = value;
    }

    /**
     * Gets the value of the arvCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvCity() {
        return arvCity;
    }

    /**
     * Sets the value of the arvCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvCity(String value) {
        this.arvCity = value;
    }

    /**
     * Gets the value of the specialServicesJourneyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialServicesJourneyType() {
        return specialServicesJourneyType;
    }

    /**
     * Sets the value of the specialServicesJourneyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialServicesJourneyType(String value) {
        this.specialServicesJourneyType = value;
    }

    /**
     * Gets the value of the travelerFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelerFName() {
        return travelerFName;
    }

    /**
     * Sets the value of the travelerFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelerFName(String value) {
        this.travelerFName = value;
    }

    /**
     * Gets the value of the travelerLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelerLName() {
        return travelerLName;
    }

    /**
     * Sets the value of the travelerLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelerLName(String value) {
        this.travelerLName = value;
    }

    /**
     * Gets the value of the travelerHomePhno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelerHomePhno() {
        return travelerHomePhno;
    }

    /**
     * Sets the value of the travelerHomePhno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelerHomePhno(String value) {
        this.travelerHomePhno = value;
    }

    /**
     * Gets the value of the travelerWorkPhno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelerWorkPhno() {
        return travelerWorkPhno;
    }

    /**
     * Sets the value of the travelerWorkPhno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelerWorkPhno(String value) {
        this.travelerWorkPhno = value;
    }

    /**
     * Gets the value of the travelercellno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelercellno() {
        return travelercellno;
    }

    /**
     * Sets the value of the travelercellno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelercellno(String value) {
        this.travelercellno = value;
    }

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIP(String value) {
        this.ip = value;
    }

    /**
     * Gets the value of the depZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepZip() {
        return depZip;
    }

    /**
     * Sets the value of the depZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepZip(String value) {
        this.depZip = value;
    }

    /**
     * Gets the value of the depService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepService() {
        return depService;
    }

    /**
     * Sets the value of the depService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepService(String value) {
        this.depService = value;
    }

    /**
     * Gets the value of the depPickUp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepPickUp() {
        return depPickUp;
    }

    /**
     * Sets the value of the depPickUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepPickUp(String value) {
        this.depPickUp = value;
    }

    /**
     * Gets the value of the arvStreetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvStreetNumber() {
        return arvStreetNumber;
    }

    /**
     * Sets the value of the arvStreetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvStreetNumber(String value) {
        this.arvStreetNumber = value;
    }

    /**
     * Gets the value of the depStreetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepStreetNumber() {
        return depStreetNumber;
    }

    /**
     * Sets the value of the depStreetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepStreetNumber(String value) {
        this.depStreetNumber = value;
    }

    /**
     * Gets the value of the arvStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvStreet() {
        return arvStreet;
    }

    /**
     * Sets the value of the arvStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvStreet(String value) {
        this.arvStreet = value;
    }

    /**
     * Gets the value of the depStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepStreet() {
        return depStreet;
    }

    /**
     * Sets the value of the depStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepStreet(String value) {
        this.depStreet = value;
    }

    /**
     * Gets the value of the arvUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvUnit() {
        return arvUnit;
    }

    /**
     * Sets the value of the arvUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvUnit(String value) {
        this.arvUnit = value;
    }

    /**
     * Gets the value of the depUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepUnit() {
        return depUnit;
    }

    /**
     * Sets the value of the depUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepUnit(String value) {
        this.depUnit = value;
    }

    /**
     * Gets the value of the arvDirections property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvDirections() {
        return arvDirections;
    }

    /**
     * Sets the value of the arvDirections property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvDirections(String value) {
        this.arvDirections = value;
    }

    /**
     * Gets the value of the depDirections property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepDirections() {
        return depDirections;
    }

    /**
     * Sets the value of the depDirections property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepDirections(String value) {
        this.depDirections = value;
    }

    /**
     * Gets the value of the complexArv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplexArv() {
        return complexArv;
    }

    /**
     * Sets the value of the complexArv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplexArv(String value) {
        this.complexArv = value;
    }

    /**
     * Gets the value of the complexDep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplexDep() {
        return complexDep;
    }

    /**
     * Sets the value of the complexDep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplexDep(String value) {
        this.complexDep = value;
    }

    /**
     * Gets the value of the arvAP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvAP() {
        return arvAP;
    }

    /**
     * Sets the value of the arvAP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvAP(String value) {
        this.arvAP = value;
    }

    /**
     * Gets the value of the depAP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepAP() {
        return depAP;
    }

    /**
     * Sets the value of the depAP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepAP(String value) {
        this.depAP = value;
    }

    /**
     * Gets the value of the arvFlt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvFlt() {
        return arvFlt;
    }

    /**
     * Sets the value of the arvFlt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvFlt(String value) {
        this.arvFlt = value;
    }

    /**
     * Gets the value of the depFlt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepFlt() {
        return depFlt;
    }

    /**
     * Sets the value of the depFlt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepFlt(String value) {
        this.depFlt = value;
    }

    /**
     * Gets the value of the depPickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepPickupTime() {
        return depPickupTime;
    }

    /**
     * Sets the value of the depPickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepPickupTime(String value) {
        this.depPickupTime = value;
    }

    /**
     * Gets the value of the arvFltTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvFltTime() {
        return arvFltTime;
    }

    /**
     * Sets the value of the arvFltTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvFltTime(String value) {
        this.arvFltTime = value;
    }

    /**
     * Gets the value of the depFltTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepFltTime() {
        return depFltTime;
    }

    /**
     * Sets the value of the depFltTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepFltTime(String value) {
        this.depFltTime = value;
    }

    /**
     * Gets the value of the arvAirline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvAirline() {
        return arvAirline;
    }

    /**
     * Sets the value of the arvAirline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvAirline(String value) {
        this.arvAirline = value;
    }

    /**
     * Gets the value of the depAirline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepAirline() {
        return depAirline;
    }

    /**
     * Sets the value of the depAirline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepAirline(String value) {
        this.depAirline = value;
    }

    /**
     * Gets the value of the fltType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltType() {
        return fltType;
    }

    /**
     * Sets the value of the fltType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltType(String value) {
        this.fltType = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the flyingTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlyingTo() {
        return flyingTo;
    }

    /**
     * Sets the value of the flyingTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlyingTo(String value) {
        this.flyingTo = value;
    }

    /**
     * Gets the value of the depPassenger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepPassenger() {
        return depPassenger;
    }

    /**
     * Sets the value of the depPassenger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepPassenger(String value) {
        this.depPassenger = value;
    }

    /**
     * Gets the value of the depDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepDate() {
        return depDate;
    }

    /**
     * Sets the value of the depDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepDate(String value) {
        this.depDate = value;
    }

    /**
     * Gets the value of the depCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepCity() {
        return depCity;
    }

    /**
     * Sets the value of the depCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepCity(String value) {
        this.depCity = value;
    }

    /**
     * Gets the value of the depFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepFee() {
        return depFee;
    }

    /**
     * Sets the value of the depFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepFee(String value) {
        this.depFee = value;
    }

    /**
     * Gets the value of the depGratuity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepGratuity() {
        return depGratuity;
    }

    /**
     * Sets the value of the depGratuity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepGratuity(String value) {
        this.depGratuity = value;
    }

    /**
     * Gets the value of the surcharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurcharge() {
        return surcharge;
    }

    /**
     * Sets the value of the surcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurcharge(String value) {
        this.surcharge = value;
    }

    /**
     * Gets the value of the travelerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelerEmail() {
        return travelerEmail;
    }

    /**
     * Sets the value of the travelerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelerEmail(String value) {
        this.travelerEmail = value;
    }

    /**
     * Gets the value of the specialinst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialinst() {
        return specialinst;
    }

    /**
     * Sets the value of the specialinst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialinst(String value) {
        this.specialinst = value;
    }

    /**
     * Gets the value of the restype1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestype1() {
        return restype1;
    }

    /**
     * Sets the value of the restype1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestype1(String value) {
        this.restype1 = value;
    }

    /**
     * Gets the value of the restypedetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestypedetail() {
        return restypedetail;
    }

    /**
     * Sets the value of the restypedetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestypedetail(String value) {
        this.restypedetail = value;
    }

    /**
     * Gets the value of the billTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillTo() {
        return billTo;
    }

    /**
     * Sets the value of the billTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillTo(String value) {
        this.billTo = value;
    }

    /**
     * Gets the value of the reqArvTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqArvTime() {
        return reqArvTime;
    }

    /**
     * Sets the value of the reqArvTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqArvTime(String value) {
        this.reqArvTime = value;
    }

    /**
     * Gets the value of the isSendEmail property.
     * 
     */
    public boolean isIsSendEmail() {
        return isSendEmail;
    }

    /**
     * Sets the value of the isSendEmail property.
     * 
     */
    public void setIsSendEmail(boolean value) {
        this.isSendEmail = value;
    }

    /**
     * Gets the value of the mailTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     * Sets the value of the mailTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailTo(String value) {
        this.mailTo = value;
    }

    /**
     * Gets the value of the charterDep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharterDep() {
        return charterDep;
    }

    /**
     * Sets the value of the charterDep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharterDep(String value) {
        this.charterDep = value;
    }

    /**
     * Gets the value of the charterArv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharterArv() {
        return charterArv;
    }

    /**
     * Sets the value of the charterArv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharterArv(String value) {
        this.charterArv = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the specialServiceIDDep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialServiceIDDep() {
        return specialServiceIDDep;
    }

    /**
     * Sets the value of the specialServiceIDDep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialServiceIDDep(String value) {
        this.specialServiceIDDep = value;
    }

    /**
     * Gets the value of the depServiceidNew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepServiceidNew() {
        return depServiceidNew;
    }

    /**
     * Sets the value of the depServiceidNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepServiceidNew(String value) {
        this.depServiceidNew = value;
    }

    /**
     * Gets the value of the arvServiceidNew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvServiceidNew() {
        return arvServiceidNew;
    }

    /**
     * Sets the value of the arvServiceidNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvServiceidNew(String value) {
        this.arvServiceidNew = value;
    }

    /**
     * Gets the value of the arvCancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvCancel() {
        return arvCancel;
    }

    /**
     * Sets the value of the arvCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvCancel(String value) {
        this.arvCancel = value;
    }

    /**
     * Gets the value of the depCancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepCancel() {
        return depCancel;
    }

    /**
     * Sets the value of the depCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepCancel(String value) {
        this.depCancel = value;
    }

    /**
     * Gets the value of the couponEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCouponEmail() {
        return couponEmail;
    }

    /**
     * Sets the value of the couponEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCouponEmail(String value) {
        this.couponEmail = value;
    }

    /**
     * Gets the value of the discCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscCode() {
        return discCode;
    }

    /**
     * Sets the value of the discCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscCode(String value) {
        this.discCode = value;
    }

    /**
     * Gets the value of the discAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscAmt() {
        return discAmt;
    }

    /**
     * Sets the value of the discAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscAmt(String value) {
        this.discAmt = value;
    }

}
