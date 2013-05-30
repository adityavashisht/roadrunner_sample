package com.scoa.roadrunner.services.integration;


import com.scoa.roadrunner.common.dto.KeyValueDropDown;
import com.scoa.roadrunner.common.dto.ReservationFare;
import com.scoa.roadrunner.common.payload.ReservationFareRequest;
import com.scoa.roadrunner.common.payload.SaveReservationRequest;
import com.scoa.roadrunner.domain.reservation.ArrivalInfo;
import com.scoa.roadrunner.domain.reservation.CreditCardType;
import com.scoa.roadrunner.domain.reservation.DirectionType;
import com.scoa.roadrunner.domain.reservation.FareInfo;
import com.scoa.roadrunner.domain.reservation.PaymentInfo;
import com.scoa.roadrunner.domain.reservation.RequestCommonInfo;
import com.scoa.roadrunner.domain.reservation.Reservation;
import com.scoa.roadrunner.domain.reservation.RouteType;
import com.scoa.roadrunner.domain.reservation.TravelInfo;
import com.scoa.roadrunner.domain.reservation.TravelerInfo;
import com.scoa.roadrunner.domain.shared.Address;
import com.scoa.roadrunner.domain.shared.CellPhone;
import com.scoa.roadrunner.domain.shared.ContactInformation;
import com.scoa.roadrunner.domain.shared.HomePhone;
import com.scoa.roadrunner.domain.shared.WorkPhone;
import com.scoa.roadrunner.services.gateway.RRGateway;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/scoa/roadrunner/services/infrastructure.xml")
public class RRGatewayTest {

    @Autowired
    RRGateway rrGateway;

    @Test
    public void testGetAirportDropDowns() {
        List<KeyValueDropDown> dropDownList = rrGateway.getAirportByPrefix("P");
        assertNotNull(dropDownList);
        //assertEquals(2, dropDownList.size());
    }


    @Test
    public void testGetAirlines() {
        List<KeyValueDropDown> dropDownList = rrGateway.getAirlinesByPrefix("A");
        assertNotNull(dropDownList);
    }

    @Test
    public void testGetReservationFareArrival() {
        ReservationFare fare = rrGateway.getReservationFareForRoute(getReservationFareRequestArrival());
        assertNotNull(fare);
    }

    @Test
    public void testGetReservationFareDeparture() {
        ReservationFare fare = rrGateway.getReservationFareForRoute(getReservationFareRequestDep());
        assertNotNull(fare);
    }

    @Test
    public void testSaveReservation() {
        SaveReservationRequest saveReservationRequest = this.saveReservationRequest();
        rrGateway.createNewReservation(saveReservationRequest);
    }

    /**
     *
     * @return
     */
    private ReservationFareRequest getReservationFareRequestArrival() {
        ReservationFareRequest fareRequest = new ReservationFareRequest();
        fareRequest.setArrival(false);
        fareRequest.setAirportCode("PHX");
        fareRequest.setDateOfTravel("2013-04-28");
        fareRequest.setPassengerCount("7");
        fareRequest.setZipCode("85021");
        return fareRequest;
    }

    /**
     *
     * @return
     */
    private ReservationFareRequest getReservationFareRequestDep() {
        ReservationFareRequest fareRequest = new ReservationFareRequest();
        fareRequest.setArrival(false);
        fareRequest.setAirportCode("PHX");
        fareRequest.setDateOfTravel("2013-04-28");
        fareRequest.setPassengerCount("7");
        fareRequest.setZipCode("85021");
        return fareRequest;
    }


    private SaveReservationRequest saveReservationRequest() {
        SaveReservationRequest s = new SaveReservationRequest();
        Reservation r = new Reservation();
        r.setRouteType(RouteType.FROM);
        r.setDirectionType(DirectionType.ONE_WAY);

        TravelerInfo travelerInfo = new TravelerInfo();
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setFirstName("Mayank");
        contactInformation.setLastName("Pandey");
        contactInformation.setEmail("reslead@rrshuttle.com");


        HomePhone homePhone = new HomePhone();
        homePhone.setNumber("111-111-1111");

        contactInformation.setHomePhone(homePhone);


        CellPhone cellPhone = new CellPhone();
        cellPhone.setNumber("112-221-1221");

        WorkPhone workPhone = new WorkPhone();
        workPhone.setNumber("");
        contactInformation.setWorkPhone(workPhone);

        contactInformation.setCellPhone(cellPhone);
        travelerInfo.setContactInformation(contactInformation);
        r.setTravelerInfo(travelerInfo);
        // End Traveler information

        // Begin Arrival Information

        TravelInfo travelInfo = new TravelInfo();

        Address arrivalFrom = new Address();

        arrivalFrom.setCity("");
        arrivalFrom.setZip("93010");
        arrivalFrom.setAddressLine("1675 Chapple ave, Camrillo");
        arrivalFrom.setUnitName("");
        arrivalFrom.setStreetNumber("");


        travelInfo.setDate(DateTime.now());
        travelInfo.setPassengerCount("1");
        travelInfo.setAddress(arrivalFrom);
        travelInfo.setTimeOfTravel(DateTime.now());

        travelInfo.setFlightNumber("12434");
        //travelInfo.setFlightTime("05/22/2013 09:00 AM");

        travelInfo.setPickUpTime("05/22/2013 10:30 AM");
        travelInfo.setAirport("PHX");

        ArrivalInfo arrivalInfo = new ArrivalInfo();
        arrivalInfo.setTravelInfo(travelInfo);

        r.setArrivalInfo(arrivalInfo);

        //Section 3
        FareInfo fareInfo = new FareInfo();
        fareInfo.setArrivalFee(new BigDecimal("10"));
        fareInfo.setArrivalGratuity(new BigDecimal("10"));
        fareInfo.setSpecialServiceAmount(new BigDecimal("2"));

        r.setFareInfo(fareInfo);

        RequestCommonInfo requestCommonInfo = new RequestCommonInfo();
        requestCommonInfo.setUserName("GORRShuttle");
        requestCommonInfo.setSpecialInstructions("Test");
        requestCommonInfo.setResType("1");    //1,2,3
        requestCommonInfo.setRequestType("1");
        requestCommonInfo.setInfoId("1");


        r.setRequestCommonInfo(requestCommonInfo);


        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardHolderFullName("Mayank Pandey");
        paymentInfo.setCcTypeId("1");
        paymentInfo.setCreditCardNumber("5423111111111111");
        paymentInfo.setCvcCode("123");
        paymentInfo.setExpirationDate("0320");
        paymentInfo.setZip("93010");
        paymentInfo.setCreditCardType(CreditCardType.MASTERCARD);

        r.setPaymentInfo(paymentInfo);


        s.setReservation(r);
        return s;
    }
}
