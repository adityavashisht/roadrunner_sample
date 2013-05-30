
package com.scoa.roadrunner.connector.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RR13HttpPost", targetNamespace = "http://tempuri.org/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RR13HttpPost {


    /**
     * This method gets the Fares for the Reservation. Inputs:  Airport short code, ZipCode , Passengers  fore arrival and departure legs. 
     * 
     * @param discAmt
     * @param queryString
     * @param depDate
     * @param depAirport
     * @param arvZip
     * @param depZip
     * @param arvAirport
     * @param discCode
     * @param arvPessanger
     * @param depPessanger
     * @param arvDate
     */
    @WebMethod(operationName = "GetFareForReservation")
    public void getFareForReservation(
        @WebParam(name = "DepAirport", partName = "DepAirport")
        String depAirport,
        @WebParam(name = "DepZip", partName = "DepZip")
        String depZip,
        @WebParam(name = "DepPessanger", partName = "DepPessanger")
        String depPessanger,
        @WebParam(name = "DepDate", partName = "DepDate")
        String depDate,
        @WebParam(name = "ArvAirport", partName = "ArvAirport")
        String arvAirport,
        @WebParam(name = "ArvZip", partName = "ArvZip")
        String arvZip,
        @WebParam(name = "ArvPessanger", partName = "ArvPessanger")
        String arvPessanger,
        @WebParam(name = "ArvDate", partName = "ArvDate")
        String arvDate,
        @WebParam(name = "QueryString", partName = "QueryString")
        String queryString,
        @WebParam(name = "DiscCode", partName = "DiscCode")
        String discCode,
        @WebParam(name = "DiscAmt", partName = "DiscAmt")
        String discAmt);

    /**
     * This method for authentication and Login.  Username and Password.
     * 
     * @param userName
     * @param password
     */
    @WebMethod(operationName = "CheckLogin")
    public void checkLogin(
        @WebParam(name = "UserName", partName = "UserName")
        String userName,
        @WebParam(name = "Password", partName = "Password")
        String password);

    /**
     * This method allows getting email password reminder. 
     * 
     * @param userEmailAddress
     */
    @WebMethod(operationName = "ForgotPassword")
    public void forgotPassword(
        @WebParam(name = "UserEmailAddress", partName = "UserEmailAddress")
        String userEmailAddress);

    /**
     * This method allows create new reservation.
     * 
     * @param arvStreetNumber
     * @param charterArv
     * @param charterDep
     * @param arvFee
     * @param depService
     * @param custID
     * @param arvService
     * @param redemptionAmt
     * @param depGratuity
     * @param depFee
     * @param arvFltTime
     * @param arvStreet
     * @param arvPassenger
     * @param specialServicesJourneyType
     * @param depPickUp
     * @param travelerEmail
     * @param specialinst
     * @param travelerFName
     * @param depDirections
     * @param mailTo
     * @param depServiceidNew
     * @param restype1
     * @param specialServiceamt
     * @param discCode
     * @param fltType
     * @param cardType
     * @param clientId
     * @param discount
     * @param isWindowID
     * @param depFlt
     * @param pmtMode
     * @param arvCancel
     * @param cZip
     * @param travellerID
     * @param cccid
     * @param arvFlt
     * @param travelerLName
     * @param discAmt
     * @param specialServiceIDDep
     * @param depPickupTime
     * @param arvZip
     * @param depZip
     * @param arvAirline
     * @param depPassenger
     * @param infoID
     * @param pmtDetails
     * @param conf
     * @param billTo
     * @param depUnit
     * @param couponEmail
     * @param complexArv
     * @param ccTypeID
     * @param travelercellno
     * @param flyingTo
     * @param arvAirport
     * @param arvAP
     * @param ccExpDate
     * @param arvPickupTime
     * @param restypedetail
     * @param custType
     * @param cCname
     * @param depDate
     * @param arvUnit
     * @param depAP
     * @param arvCity
     * @param travelerWorkPhno
     * @param origin
     * @param travelerHomePhno
     * @param surcharge
     * @param arvDate
     * @param depStreet
     * @param depCity
     * @param depCancel
     * @param ip
     * @param depAirline
     * @param isSendEmail
     * @param reqArvTime
     * @param arvGratuity
     * @param arvServiceidNew
     * @param depStreetNumber
     * @param reqType
     * @param arvDirections
     * @param complexDep
     * @param depFltTime
     * @param ccNum
     * @param specialServiceIDArv
     * @param resType
     */
    @WebMethod(operationName = "SaveReservation")
    public void saveReservation(
        @WebParam(name = "CustID", partName = "CustID")
        String custID,
        @WebParam(name = "TravellerID", partName = "TravellerID")
        String travellerID,
        @WebParam(name = "CustType", partName = "CustType")
        String custType,
        @WebParam(name = "ResType", partName = "ResType")
        String resType,
        @WebParam(name = "ArvDate", partName = "ArvDate")
        String arvDate,
        @WebParam(name = "ArvAirport", partName = "ArvAirport")
        String arvAirport,
        @WebParam(name = "ArvPassenger", partName = "ArvPassenger")
        String arvPassenger,
        @WebParam(name = "ArvPickupTime", partName = "ArvPickupTime")
        String arvPickupTime,
        @WebParam(name = "ArvFee", partName = "ArvFee")
        String arvFee,
        @WebParam(name = "ArvGratuity", partName = "ArvGratuity")
        String arvGratuity,
        @WebParam(name = "Discount", partName = "Discount")
        String discount,
        @WebParam(name = "Conf", partName = "Conf")
        String conf,
        @WebParam(name = "SpecialServiceamt", partName = "SpecialServiceamt")
        String specialServiceamt,
        @WebParam(name = "ArvService", partName = "ArvService")
        String arvService,
        @WebParam(name = "ArvZip", partName = "ArvZip")
        String arvZip,
        @WebParam(name = "SpecialServiceIDArv", partName = "SpecialServiceIDArv")
        String specialServiceIDArv,
        @WebParam(name = "RedemptionAmt", partName = "RedemptionAmt")
        String redemptionAmt,
        @WebParam(name = "CardType", partName = "CardType")
        String cardType,
        @WebParam(name = "CCNum", partName = "CCNum")
        String ccNum,
        @WebParam(name = "CCname", partName = "CCname")
        String cCname,
        @WebParam(name = "CCExpDate", partName = "CCExpDate")
        String ccExpDate,
        @WebParam(name = "CCCID", partName = "CCCID")
        String cccid,
        @WebParam(name = "CCTypeID", partName = "CCTypeID")
        String ccTypeID,
        @WebParam(name = "CZip", partName = "CZip")
        String cZip,
        @WebParam(name = "ReqType", partName = "ReqType")
        String reqType,
        @WebParam(name = "InfoID", partName = "InfoID")
        String infoID,
        @WebParam(name = "PmtMode", partName = "PmtMode")
        String pmtMode,
        @WebParam(name = "PMTDetails", partName = "PMTDetails")
        String pmtDetails,
        @WebParam(name = "ISWindowID", partName = "ISWindowID")
        String isWindowID,
        @WebParam(name = "ArvCity", partName = "ArvCity")
        String arvCity,
        @WebParam(name = "SpecialServicesJourneyType", partName = "SpecialServicesJourneyType")
        String specialServicesJourneyType,
        @WebParam(name = "TravelerFName", partName = "TravelerFName")
        String travelerFName,
        @WebParam(name = "TravelerLName", partName = "TravelerLName")
        String travelerLName,
        @WebParam(name = "TravelerHomePhno", partName = "TravelerHomePhno")
        String travelerHomePhno,
        @WebParam(name = "TravelerWorkPhno", partName = "TravelerWorkPhno")
        String travelerWorkPhno,
        @WebParam(name = "Travelercellno", partName = "Travelercellno")
        String travelercellno,
        @WebParam(name = "IP", partName = "IP")
        String ip,
        @WebParam(name = "DepZip", partName = "DepZip")
        String depZip,
        @WebParam(name = "DepService", partName = "DepService")
        String depService,
        @WebParam(name = "DepPickUp", partName = "DepPickUp")
        String depPickUp,
        @WebParam(name = "ArvStreetNumber", partName = "ArvStreetNumber")
        String arvStreetNumber,
        @WebParam(name = "DepStreetNumber", partName = "DepStreetNumber")
        String depStreetNumber,
        @WebParam(name = "ArvStreet", partName = "ArvStreet")
        String arvStreet,
        @WebParam(name = "DepStreet", partName = "DepStreet")
        String depStreet,
        @WebParam(name = "ArvUnit", partName = "ArvUnit")
        String arvUnit,
        @WebParam(name = "DepUnit", partName = "DepUnit")
        String depUnit,
        @WebParam(name = "ArvDirections", partName = "ArvDirections")
        String arvDirections,
        @WebParam(name = "DepDirections", partName = "DepDirections")
        String depDirections,
        @WebParam(name = "ComplexArv", partName = "ComplexArv")
        String complexArv,
        @WebParam(name = "ComplexDep", partName = "ComplexDep")
        String complexDep,
        @WebParam(name = "ArvAP", partName = "ArvAP")
        String arvAP,
        @WebParam(name = "DepAP", partName = "DepAP")
        String depAP,
        @WebParam(name = "ArvFlt", partName = "ArvFlt")
        String arvFlt,
        @WebParam(name = "DepFlt", partName = "DepFlt")
        String depFlt,
        @WebParam(name = "DepPickupTime", partName = "DepPickupTime")
        String depPickupTime,
        @WebParam(name = "arvFltTime", partName = "arvFltTime")
        String arvFltTime,
        @WebParam(name = "DepFltTime", partName = "DepFltTime")
        String depFltTime,
        @WebParam(name = "ArvAirline", partName = "ArvAirline")
        String arvAirline,
        @WebParam(name = "DepAirline", partName = "DepAirline")
        String depAirline,
        @WebParam(name = "FltType", partName = "FltType")
        String fltType,
        @WebParam(name = "origin", partName = "origin")
        String origin,
        @WebParam(name = "FlyingTo", partName = "FlyingTo")
        String flyingTo,
        @WebParam(name = "DepPassenger", partName = "DepPassenger")
        String depPassenger,
        @WebParam(name = "DepDate", partName = "DepDate")
        String depDate,
        @WebParam(name = "DepCity", partName = "DepCity")
        String depCity,
        @WebParam(name = "DepFee", partName = "DepFee")
        String depFee,
        @WebParam(name = "DepGratuity", partName = "DepGratuity")
        String depGratuity,
        @WebParam(name = "Surcharge", partName = "Surcharge")
        String surcharge,
        @WebParam(name = "TravelerEmail", partName = "TravelerEmail")
        String travelerEmail,
        @WebParam(name = "specialinst", partName = "specialinst")
        String specialinst,
        @WebParam(name = "Restype1", partName = "Restype1")
        String restype1,
        @WebParam(name = "Restypedetail", partName = "Restypedetail")
        String restypedetail,
        @WebParam(name = "BillTo", partName = "BillTo")
        String billTo,
        @WebParam(name = "ReqArvTime", partName = "ReqArvTime")
        String reqArvTime,
        @WebParam(name = "IsSendEmail", partName = "IsSendEmail")
        String isSendEmail,
        @WebParam(name = "MailTo", partName = "MailTo")
        String mailTo,
        @WebParam(name = "CharterDep", partName = "CharterDep")
        String charterDep,
        @WebParam(name = "CharterArv", partName = "CharterArv")
        String charterArv,
        @WebParam(name = "ClientId", partName = "ClientId")
        String clientId,
        @WebParam(name = "SpecialServiceIDDep", partName = "SpecialServiceIDDep")
        String specialServiceIDDep,
        @WebParam(name = "DepServiceidNew", partName = "DepServiceidNew")
        String depServiceidNew,
        @WebParam(name = "ArvServiceidNew", partName = "ArvServiceidNew")
        String arvServiceidNew,
        @WebParam(name = "ArvCancel", partName = "ArvCancel")
        String arvCancel,
        @WebParam(name = "DepCancel", partName = "DepCancel")
        String depCancel,
        @WebParam(name = "CouponEmail", partName = "CouponEmail")
        String couponEmail,
        @WebParam(name = "DiscCode", partName = "DiscCode")
        String discCode,
        @WebParam(name = "DiscAmt", partName = "DiscAmt")
        String discAmt);

    /**
     * Allows us to get airport details based on specific input. Input is a string prefix of airport name.
     * 
     * @param preFix
     */
    @WebMethod(operationName = "GetAirport")
    public void getAirport(
        @WebParam(name = "PreFix", partName = "PreFix")
        String preFix);

    /**
     * This web method is for getting addresses for a customer. Inputs: customer Id and a prefix.
     * 
     * @param preFix
     * @param customerid
     */
    @WebMethod(operationName = "GetAddress")
    public void getAddress(
        @WebParam(name = "Customerid", partName = "Customerid")
        String customerid,
        @WebParam(name = "PreFix", partName = "PreFix")
        String preFix);

    /**
     * This method is to get hotel details for specific city. Input: zip code, City name and hotel name string prefix.
     * 
     * @param preFix
     * @param zip
     * @param city
     */
    @WebMethod(operationName = "GetHotel")
    public void getHotel(
        @WebParam(name = "Zip", partName = "Zip")
        String zip,
        @WebParam(name = "City", partName = "City")
        String city,
        @WebParam(name = "PreFix", partName = "PreFix")
        String preFix);

    /**
     * This method is used to get airline details. Input is an airline prefix.
     * 
     * @param preFix
     */
    @WebMethod(operationName = "GetAirLine")
    public void getAirLine(
        @WebParam(name = "PreFix", partName = "PreFix")
        String preFix);

    /**
     * This method gets the Reservations for the CustomerID. Inputs:  CustomerID 
     * 
     * @param customerid
     */
    @WebMethod(operationName = "GetMyReservation")
    public void getMyReservation(
        @WebParam(name = "Customerid", partName = "Customerid")
        String customerid);

    /**
     * This method allows new user registration. Input: EmailAddress, FName, LName, HomePhone, CellPhone, Number, Street, Unit, Complex, City, Zip, Password, Direction, Custid and CustType
     * 
     * @param zip
     * @param complex
     * @param direction
     * @param street
     * @param cellPhone
     * @param emailAddress
     * @param lName
     * @param number
     * @param homePhone
     * @param password
     * @param fName
     * @param city
     * @param unit
     * @param custid
     * @param custType
     */
    @WebMethod(operationName = "NewUserRegistration")
    public void newUserRegistration(
        @WebParam(name = "EmailAddress", partName = "EmailAddress")
        String emailAddress,
        @WebParam(name = "FName", partName = "FName")
        String fName,
        @WebParam(name = "LName", partName = "LName")
        String lName,
        @WebParam(name = "HomePhone", partName = "HomePhone")
        String homePhone,
        @WebParam(name = "CellPhone", partName = "CellPhone")
        String cellPhone,
        @WebParam(name = "Number", partName = "Number")
        String number,
        @WebParam(name = "Street", partName = "Street")
        String street,
        @WebParam(name = "Unit", partName = "Unit")
        String unit,
        @WebParam(name = "Complex", partName = "Complex")
        String complex,
        @WebParam(name = "City", partName = "City")
        String city,
        @WebParam(name = "Zip", partName = "Zip")
        String zip,
        @WebParam(name = "Password", partName = "Password")
        String password,
        @WebParam(name = "Direction", partName = "Direction")
        String direction,
        @WebParam(name = "Custid", partName = "Custid")
        String custid,
        @WebParam(name = "CustType", partName = "CustType")
        String custType);

    /**
     * Allows to fetch the zip codes for specific city. Input: City name as a prefix.
     * 
     * @param preFix
     */
    @WebMethod(operationName = "GetCityZipPair")
    public void getCityZipPair(
        @WebParam(name = "PreFix", partName = "PreFix")
        String preFix);

    /**
     * The method to cancel reservations
     * 
     * @param updateMode
     * @param resId
     */
    @WebMethod(operationName = "CancelReservation")
    public void cancelReservation(
        @WebParam(name = "UpdateMode", partName = "UpdateMode")
        String updateMode,
        @WebParam(name = "ResId", partName = "ResId")
        String resId);

    /**
     * This method allows a customer to get the estimiated pickup time for a reservation. Input: Phone no., reservation no. and customer last name.
     * 
     * @param res
     * @param lname
     * @param phone
     */
    @WebMethod(operationName = "GetPickupETAForReservation")
    public void getPickupETAForReservation(
        @WebParam(name = "phone", partName = "phone")
        String phone,
        @WebParam(name = "res", partName = "res")
        String res,
        @WebParam(name = "lname", partName = "lname")
        String lname);

    /**
     * This method gets the reservation details for Email.
     * 
     * @param reservationNo
     */
    @WebMethod(operationName = "EmailResDetails")
    public void emailResDetails(
        @WebParam(name = "ReservationNo", partName = "ReservationNo")
        String reservationNo);

    /**
     * This method gets the payment details for Email.
     * 
     * @param reservationNo
     */
    @WebMethod(operationName = "EmailPaymentDetails")
    public void emailPaymentDetails(
        @WebParam(name = "ReservationNo", partName = "ReservationNo")
        String reservationNo);

    /**
     * This method for Charge creditcards transactions.
     * 
     * @param custId
     * @param transId
     * @param qgUser
     * @param userName
     * @param vaultKey
     */
    @WebMethod(operationName = "ChargeNowFromQGWithCustID")
    public void chargeNowFromQGWithCustID(
        @WebParam(name = "TransId", partName = "TransId")
        String transId,
        @WebParam(name = "UserName", partName = "UserName")
        String userName,
        @WebParam(name = "QGUser", partName = "QGUser")
        String qgUser,
        @WebParam(name = "VaultKey", partName = "VaultKey")
        String vaultKey,
        @WebParam(name = "CustId", partName = "CustId")
        String custId);

}
