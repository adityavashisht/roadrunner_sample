package com.scoa.roadrunner.web.flow.reservation;

import com.scoa.roadrunner.common.dto.ReservationFare;
import com.scoa.roadrunner.common.payload.ReservationFareRequest;
import com.scoa.roadrunner.common.payload.SaveReservationRequest;
import com.scoa.roadrunner.common.payload.SaveReservationResponse;
import com.scoa.roadrunner.common.util.DateUtil;
import com.scoa.roadrunner.domain.reservation.Airport;

import com.scoa.roadrunner.domain.reservation.ArrivalInfo;
import com.scoa.roadrunner.domain.reservation.CreditCardType;
import com.scoa.roadrunner.domain.reservation.DepartureInfo;
import com.scoa.roadrunner.domain.reservation.DirectionType;
import com.scoa.roadrunner.domain.reservation.FareInfo;
import com.scoa.roadrunner.domain.reservation.FlightRegion;
import com.scoa.roadrunner.domain.reservation.HourFlight;
import com.scoa.roadrunner.domain.reservation.MinuteFlight;
import com.scoa.roadrunner.domain.reservation.RequestCommonInfo;
import com.scoa.roadrunner.domain.reservation.Reservation;
import com.scoa.roadrunner.domain.reservation.RouteType;
import com.scoa.roadrunner.domain.reservation.ZipOrLandMarkSelect;
import com.scoa.roadrunner.domain.shared.Address;
import com.scoa.roadrunner.domain.shared.ContactInformation;
import com.scoa.roadrunner.domain.shared.HomePhone;
import com.scoa.roadrunner.domain.shared.WorkPhone;
import com.scoa.roadrunner.services.gateway.RRGateway;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.Event;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 *
 *
 *
 */
@Component
public class ReservationAction extends MultiAction {

    @Autowired
    RRGateway rrGateway;

    /**
     * @param context
     * @return
     */
    public Event initialize(ReservationForm reservationForm, RequestControlContext context) {

        HttpServletRequest servletRequest = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        String id = (String) servletRequest.getSession().getAttribute("ID");
        if(StringUtils.hasText(id)) {
            servletRequest.getSession().removeAttribute("ID");
            return no();
        }

        context.getFlowScope().put("airports", Airport.getAll());
        context.getFlowScope().put("zipLandmarkSelect", ZipOrLandMarkSelect.getAll());
        context.getFlowScope().put("flightRegions", FlightRegion.getAll());
        context.getFlowScope().put("hourFlight", HourFlight.getAll());
        context.getFlowScope().put("minuteFlight", MinuteFlight.getAll());

        reservationForm.getRouteStepOne().setRouteType(RouteType.TO);
        reservationForm.getRouteStepOne().setDirectionType(DirectionType.ONE_WAY);

        return yes();
    }


    /**
     * @param reservationForm
     * @param context
     * @return
     */
    public Event fare(ReservationForm reservationForm, RequestControlContext context) {

        HttpServletRequest servletRequest = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        String id = (String) servletRequest.getSession().getAttribute("ID");
        if(StringUtils.hasText(id)) {
            servletRequest.getSession().removeAttribute("ID");
            return no();
        }

        SaveReservationResponse response = reservationForm.getReservationResponse();
        if (StringUtils.hasText(response.getId())) {
            return no();
        }

        RouteStepOne routeStepOne = reservationForm.getRouteStepOne();
        String airportCode = routeStepOne.getAirport();
        Airport airport = Airport.fromString(airportCode);
        routeStepOne.setAirportDisplayValue(airport.getName() + "-" + airportCode);
        routeStepOne.setAirportZipCode(airport.getZipCode());
        ReservationFareRequest fareRequest = new ReservationFareRequest();
        fareRequest.setAirportCode(airportCode);
        if (RouteType.FROM.equals(routeStepOne.getRouteType())) {
            fareRequest.setArrival(true);
        }
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        String str = fmt.print(dt);
        fareRequest.setDateOfTravel(str);
        fareRequest.setZipCode(routeStepOne.getZipCode());
        fareRequest.setPassengerCount(routeStepOne.getTotalPassengerCount());
        ReservationFare fare = null;
        try {
            fare = rrGateway.getReservationFareForRoute(fareRequest);
            if (DirectionType.ROUND_TRIP.equals(routeStepOne.getDirectionType())) {
                BigDecimal amount = fare.getAmount();
                amount = amount.multiply(new BigDecimal(2));
                fare.setAmount(amount);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            context.getMessageContext().addMessage(new MessageBuilder().error()
                    .source("routeStepOne.systemError").code("route.step.one.system.error")
                    .defaultText("System error.Please try again.").build());
            return error();
        }

        // If fare is zero then the zip code is not serviced
        if (fare.getAmount().intValue() == 0) {
            context.getMessageContext().addMessage(new MessageBuilder().error()
                    .source("routeStepOne.zipCode").code("route.step.one.zipCode.not.serviced")
                    .defaultText("Zip Code not serviced").build());
            return error();
        }

        RouteStepTwo routeStepTwo = reservationForm.getRouteStepTwo();
        routeStepTwo.setReservationFare(fare);
        return yes();
    }


    /**
     * @param reservationForm
     * @return
     */
    public Event flightInformation(ReservationForm reservationForm, RequestControlContext context) {

        HttpServletRequest servletRequest = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        String id = (String) servletRequest.getSession().getAttribute("ID");
        if(StringUtils.hasText(id)) {
            servletRequest.getSession().removeAttribute("ID");
            return no();
        }

        SaveReservationResponse response = reservationForm.getReservationResponse();
        if (StringUtils.hasText(response.getId())) {
            return no();
        }

        RouteStepTwo routeStepTwo = reservationForm.getRouteStepTwo();
        RouteStepOne routeStepOne = reservationForm.getRouteStepOne();
        ReservationFare reservationFare = routeStepTwo.getReservationFare();
        reservationFare.setPassengerCount(Long.valueOf(reservationForm.getRouteStepOne().getTotalPassengerCount()));
        // Evaluate if gratuity is added
        if (StringUtils.hasText(routeStepTwo.getReservationFare().getGratuityPercentage())) {
            String gratuity = routeStepTwo.getReservationFare().getGratuityPercentage();
            if (!"0".equals(gratuity)) {
                BigDecimal percentage = new BigDecimal(gratuity).divide(new BigDecimal(100));
                BigDecimal fare = reservationFare.getAmount();
                BigDecimal gratuityAmount = round(percentage.multiply(fare), 2, true);
                BigDecimal totalFare = fare.add(gratuityAmount);
                reservationFare.setTotalAmountWithGratuity(totalFare);
                reservationFare.setGratuityAmount(gratuityAmount);
            }
        }
        // Place card types in flow scope
        context.getFlowScope().put("cardTypes", CreditCardType.getAll());

        FareInfo fareInfo = reservationForm.getFareInfo();

        // ARRIVAL (FROM AIRPORT)
        if (DirectionType.ONE_WAY.equals(reservationForm.getRouteStepOne().getDirectionType())) {
            if (RouteType.FROM.equals(reservationForm.getRouteStepOne().getRouteType())) {
                prepareArrivalInfo(routeStepOne, routeStepTwo, fareInfo, reservationForm, reservationForm.getSaveReservationRequest().getReservation());
            } else if (RouteType.TO.equals(reservationForm.getRouteStepOne().getRouteType())) {
                prepareDepartureInfo(routeStepOne, routeStepTwo, reservationForm, fareInfo, reservationForm.getSaveReservationRequest().getReservation());
            }
        }

        // Set arrival and departure appropriately, when user selects ROUND TRIP option
        else if (DirectionType.ROUND_TRIP.equals(routeStepOne.getDirectionType())) {
            prepareArrivalInfo(routeStepOne, routeStepTwo, fareInfo, reservationForm, reservationForm.getSaveReservationRequest().getReservation());
            prepareDepartureInfo(routeStepOne, routeStepTwo, reservationForm, fareInfo, reservationForm.getSaveReservationRequest().getReservation());
        }


        if (routeStepTwo.getArrivalInfo().getTravelInfo().getFlightRegion() != null) {
            String region = routeStepTwo.getArrivalInfo().getTravelInfo().getFlightRegion();
            String selection = FlightRegion.fromString(region).getSelection();
            routeStepTwo.getArrivalInfo().getTravelInfo().setFlightRegionSelection(selection);
        }
        if (routeStepTwo.getDepartureInfo().getTravelInfo().getFlightRegion() != null) {
            String depRegion = routeStepTwo.getDepartureInfo().getTravelInfo().getFlightRegion();
            String depSelection = FlightRegion.fromString(depRegion).getSelection();
            routeStepTwo.getDepartureInfo().getTravelInfo().setFlightRegionSelection(depSelection);
        }
        return yes();
    }

    private void prepareArrivalInfo(RouteStepOne routeStepOne, RouteStepTwo routeStepTwo, FareInfo fareInfo, ReservationForm reservationForm, Reservation r) {
        ArrivalInfo arrivalInfo = routeStepTwo.getArrivalInfo();
        arrivalInfo.getTravelInfo().getAddress().setZip(routeStepOne.getZipCode());
        ContactInformation contactInformation = routeStepTwo.getTravelerInfo().getContactInformation();
        HomePhone h = new HomePhone();
        h.setNumber("");
        contactInformation.setHomePhone(h);
        WorkPhone w = new WorkPhone();
        w.setNumber("");
        contactInformation.setWorkPhone(w);
        Address address = contactInformation.getAddress();
        address.setZip(routeStepOne.getZipCode());

        arrivalInfo.getTravelInfo().getAddress().setAddressLine(address.getAddressLine());
        arrivalInfo.getTravelInfo().setAirport(routeStepOne.getAirport());
        arrivalInfo.getTravelInfo().setPassengerCount(routeStepOne.getTotalPassengerCount());

        DateTime dateTime = arrivalInfo.getTravelInfo().getDate();
        String hourFlight = arrivalInfo.getTravelInfo().getHourFlight();
        hourFlight = HourFlight.fromString(hourFlight).getPassThroughValue();
        String minuteFlight = arrivalInfo.getTravelInfo().getMinuteFlight();
        DateTime flightArrivalTime = DateUtil.getDateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), hourFlight, minuteFlight);
        arrivalInfo.getTravelInfo().setTimeOfTravel(flightArrivalTime);
        arrivalInfo.getTravelInfo().setFlightTimeAmPm(routeStepTwo.getFlightTimeAmPm());

        String pickUpTime = routeStepTwo.getPickUpTime() + " " + routeStepTwo.getAmOrPm();

        arrivalInfo.getTravelInfo().setAmOrPm(routeStepTwo.getAmOrPm());
        arrivalInfo.getTravelInfo().setPickUpTime(pickUpTime);


        fareInfo.setArrivalGratuity(reservationForm.getRouteStepTwo().getReservationFare().getGratuityAmount());
        fareInfo.setArrivalFee(reservationForm.getRouteStepTwo().getReservationFare().getAmount());

        r.setArrivalInfo(arrivalInfo);

    }

    /**
     * @param routeStepOne
     * @param routeStepTwo
     * @param reservationForm
     * @param fareInfo
     * @param r
     */
    private void prepareDepartureInfo(RouteStepOne routeStepOne, RouteStepTwo routeStepTwo, ReservationForm reservationForm, FareInfo fareInfo, Reservation r) {
        DepartureInfo departureInfo = routeStepTwo.getDepartureInfo();
        ContactInformation contactInformation = routeStepTwo.getTravelerInfo().getContactInformation();
        HomePhone h = new HomePhone();
        h.setNumber("");
        contactInformation.setHomePhone(h);
        WorkPhone w = new WorkPhone();
        w.setNumber("");
        contactInformation.setWorkPhone(w);
        Address address = contactInformation.getAddress();
        address.setZip(routeStepOne.getZipCode());

        departureInfo.getTravelInfo().getAddress().setAddressLine(address.getAddressLine());
        departureInfo.getTravelInfo().setAirport(routeStepOne.getAirport());
        departureInfo.getTravelInfo().setPassengerCount(routeStepOne.getTotalPassengerCount());
        if (DirectionType.ONE_WAY.equals(routeStepOne.getDirectionType())) {

            DateTime dateTime = departureInfo.getTravelInfo().getDate();
            String hourFlight = departureInfo.getTravelInfo().getHourFlight();
            hourFlight = HourFlight.fromString(hourFlight).getPassThroughValue();
            String minuteFlight = departureInfo.getTravelInfo().getMinuteFlight();
            DateTime flightDepTime = DateUtil.getDateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), hourFlight, minuteFlight);
            departureInfo.getTravelInfo().setTimeOfTravel(flightDepTime);
            departureInfo.getTravelInfo().setFlightTimeAmPm(routeStepTwo.getFlightTimeAmPm());

            String pickUpTime = routeStepTwo.getPickUpTime() + " " + routeStepTwo.getAmOrPm();
            departureInfo.getTravelInfo().setPickUpTime(pickUpTime);
            departureInfo.getTravelInfo().setAmOrPm(routeStepTwo.getAmOrPm());

        } else {
            DateTime dateTime = departureInfo.getTravelInfo().getDate();
            String hourFlight = departureInfo.getTravelInfo().getHourFlight();
            hourFlight = HourFlight.fromString(hourFlight).getPassThroughValue();
            String minuteFlight = departureInfo.getTravelInfo().getMinuteFlight();
            DateTime flightDepTime = DateUtil.getDateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), hourFlight, minuteFlight);
            departureInfo.getTravelInfo().setTimeOfTravel(flightDepTime);
            departureInfo.getTravelInfo().setFlightTimeAmPm(routeStepTwo.getDepartureFlightTimeAmPm());

            String pickUpTime = routeStepTwo.getDeparturePickUpTime() + " " + routeStepTwo.getAmOrPm();
            departureInfo.getTravelInfo().setPickUpTime(pickUpTime);
            departureInfo.getTravelInfo().setAmOrPm(routeStepTwo.getDepartureAmPm());
        }
        departureInfo.getTravelInfo().getAddress().setZip(routeStepOne.getZipCode());


        fareInfo.setDepartureGratuity(reservationForm.getRouteStepTwo().getReservationFare().getGratuityAmount());
        fareInfo.setDepartureFee(reservationForm.getRouteStepTwo().getReservationFare().getAmount());

        r.setDepartureInfo(departureInfo);
    }


    /**
     * @param reservationForm
     * @param context
     * @return
     */
    public Event payment(ReservationForm reservationForm, RequestControlContext context) {

        HttpServletRequest servletRequest = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        String id = (String) servletRequest.getSession().getAttribute("ID");
        if(StringUtils.hasText(id)) {
            servletRequest.getSession().removeAttribute("ID");
            return no();
        }

        SaveReservationResponse response = reservationForm.getReservationResponse();
        if (StringUtils.hasText(response.getId())) {
            return error();
        }
        SaveReservationRequest s = reservationForm.getSaveReservationRequest();
        Reservation r = s.getReservation();
        FareInfo fareInfo = reservationForm.getFareInfo();
        r.setRouteType(reservationForm.getRouteStepOne().getRouteType());
        r.setDirectionType(reservationForm.getRouteStepOne().getDirectionType());
        r.setTravelerInfo(reservationForm.getRouteStepTwo().getTravelerInfo());
        r.setPaymentInfo(reservationForm.getRouteStepThree().getPaymentInfo());
        r.setRequestCommonInfo(reservationForm.getRequestCommonInfo());
        r.setFareInfo(fareInfo);
        r.setRequestCommonInfo(getRequestCommonInfo());
        s.setReservation(r);

        try {
            SaveReservationResponse saveReservationResponse = rrGateway.createNewReservation(s);

            id = saveReservationResponse.getId();
            if (id != null) {
                saveReservationResponse.setId(id);
                reservationForm.setReservationResponse(saveReservationResponse);
                context.getFlowScope().put("reservationNumber", saveReservationResponse.getId());
                servletRequest.getSession().setAttribute("ID", saveReservationResponse.getId());
                context.getFlowScope().put("stepCompleted", "Y");
            } else {
                context.getMessageContext().addMessage(new MessageBuilder().error()
                        .source("routeStepOne.systemError").code("route.step.one.system.error")
                        .defaultText("System error.Please try again or call 1-800-316-9252").build());
                return error();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            context.getMessageContext().addMessage(new MessageBuilder().error()
                    .source("routeStepOne.systemError").code("route.step.one.system.error")
                    .defaultText("System error.Please try again or call 1-800-316-9252").build());
            return error();
        }
        return yes();
    }

    private Event checkReservationMade(RequestControlContext context) {
        Event event  = null;
        HttpServletRequest servletRequest = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        String id = (String) servletRequest.getSession().getAttribute("ID");
        if(StringUtils.hasText(id)) {
            servletRequest.getSession().removeAttribute("ID");
            event = error();
        }
        return event;
    }

    /**
     * @param context
     * @return
     */
    public Event end(RequestControlContext context) {
        return yes();
    }


    public BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
        int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
        return d.setScale(scale, mode);
    }

    private RequestCommonInfo getRequestCommonInfo() {
        RequestCommonInfo requestCommonInfo = new RequestCommonInfo();
        requestCommonInfo.setUserName("GORRShuttle");
        requestCommonInfo.setSpecialInstructions("Reservation Request made by customer" + LocalDateTime.now());
        requestCommonInfo.setResType("1");    //1,2,3
        requestCommonInfo.setRequestType("1");
        requestCommonInfo.setInfoId("-1");
        return requestCommonInfo;
    }


}
