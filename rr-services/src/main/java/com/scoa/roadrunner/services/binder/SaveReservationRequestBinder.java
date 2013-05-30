package com.scoa.roadrunner.services.binder;


import com.scoa.roadrunner.common.payload.SaveReservationRequest;
import com.scoa.roadrunner.connector.jaxb.SaveReservation;
import com.scoa.roadrunner.domain.reservation.AmPm;
import com.scoa.roadrunner.domain.reservation.ArrivalInfo;
import com.scoa.roadrunner.domain.reservation.DepartureInfo;
import com.scoa.roadrunner.domain.reservation.DirectionType;
import com.scoa.roadrunner.domain.reservation.FareInfo;
import com.scoa.roadrunner.domain.reservation.PaymentInfo;
import com.scoa.roadrunner.domain.reservation.RequestCommonInfo;
import com.scoa.roadrunner.domain.reservation.RouteType;
import com.scoa.roadrunner.domain.reservation.TravelerInfo;
import org.springframework.util.StringUtils;

/**
 *
 *
 *
 */
public class SaveReservationRequestBinder {

    /**
     * @param r
     * @return
     */
    public static SaveReservation prepareRequest(SaveReservationRequest r) {
        SaveReservation s = new SaveReservation();
        RouteType routeType = r.getReservation().getRouteType();
        DirectionType directionType = r.getReservation().getDirectionType();
        // extract information from request, into the SOAP payload
        extractTravelerInfo(s, r);

        if (DirectionType.ONE_WAY.equals(directionType)) {
            if (RouteType.FROM.equals(routeType)) {
                extractArrivalSection(s, r);
                setDepartureBlank(s);
            } else if (RouteType.TO.equals(routeType)) {
                extractDepartureSection(s, r);
                setArrivalBlank(s);
            }
        } else if (DirectionType.ROUND_TRIP.equals(directionType)) {
            extractArrivalSection(s, r);
            extractDepartureSection(s, r);
        }

        extractFareSection(s, r);
        extractPaymentSection(s, r);
        extractCommonSection(s, r);
        return s;
    }

    /**
     * Prepare the Traveler information section
     *
     * @param s
     * @param r
     */
    private static void extractTravelerInfo(SaveReservation s, SaveReservationRequest r) {
        TravelerInfo travelerInfo = r.getReservation().getTravelerInfo();
        s.setTravelerEmail(travelerInfo.getContactInformation().getEmail());
        s.setCustType("0");
        s.setCustID("-1");
        s.setTravelercellno(travelerInfo.getContactInformation().getCellPhone().getNumber());
        s.setTravelerWorkPhno(travelerInfo.getContactInformation().getWorkPhone().getNumber());
        s.setTravelerHomePhno(travelerInfo.getContactInformation().getHomePhone().getNumber());
        s.setTravelerFName(travelerInfo.getContactInformation().getFirstName());
        s.setTravelerLName(travelerInfo.getContactInformation().getLastName());
        s.setTravellerID("0"); // set explicitly to zero
    }

    /**
     * @param s
     * @param r
     */
    private static void extractDepartureSection(SaveReservation s, SaveReservationRequest r) {
        DepartureInfo departureInfo = r.getReservation().getDepartureInfo();

        s.setDepDate(departureInfo.getTravelInfo().getTimeOfTravel().toString("MM/dd/yyyy"));
        s.setDepCancel("");
        s.setDepService("0");
        s.setDepServiceidNew("0");
        s.setDepPassenger(departureInfo.getTravelInfo().getPassengerCount());
        s.setDepPickUp("");// deprecated do not pass anything
        s.setComplexDep("");

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getStreetNumber())) {
            s.setDepStreetNumber(departureInfo.getTravelInfo().getAddress().getStreetNumber());
        } else {
            s.setDepStreetNumber("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAirlineId())) {
            s.setDepAirline(departureInfo.getTravelInfo().getAirlineId());
        } else {
            s.setDepAirline("");
        }


        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getAddressLine())) {
            s.setDepStreet(departureInfo.getTravelInfo().getAddress().getAddressLine());
        } else {
            s.setDepStreet("");
        }


        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getUnitName())) {
            s.setDepUnit(departureInfo.getTravelInfo().getAddress().getUnitName());
        } else {
            s.setDepUnit("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getZip())) {
            s.setDepZip(departureInfo.getTravelInfo().getAddress().getZip());
        } else {
            s.setDepZip("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getCity())) {
            s.setDepCity(departureInfo.getTravelInfo().getAddress().getCity());
        } else {
            s.setDepCity("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAddress().getCity())) {
            s.setDepCity(departureInfo.getTravelInfo().getAddress().getCity());
        } else {
            s.setDepCity("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getOrigin())) {
            s.setFlyingTo(departureInfo.getTravelInfo().getOrigin());
        } else {
            s.setFlyingTo("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getAirport())) {
            s.setDepAP(departureInfo.getTravelInfo().getAirport());
        } else {
            s.setDepAP("");
        }

        if (StringUtils.hasText(departureInfo.getTravelInfo().getFlightNumber())) {
            s.setDepFlt(departureInfo.getTravelInfo().getFlightNumber());
        } else {
            s.setDepFlt("");
        }

        if (departureInfo.getTravelInfo().getTimeOfTravel() != null) {
            String ampPm = departureInfo.getTravelInfo().getAmOrPm();
            String flightTime = departureInfo.getTravelInfo().getTimeOfTravel().toString(AmPm.patternByType(ampPm));
            if (AmPm.PM.getAm().equals(ampPm)) {
                flightTime = flightTime + " " + "PM";
            }
            s.setDepFltTime(flightTime);

        } else {
            s.setDepFltTime("");
        }

        s.setDepPickupTime(departureInfo.getTravelInfo().getPickUpTime());
        if (StringUtils.hasText(departureInfo.getTravelInfo().getChartered())) {
            s.setCharterDep(departureInfo.getTravelInfo().getChartered());
        } else {
            s.setCharterDep("");
        }

        s.setReqArvTime("");
        s.setDepDirections("");
        s.setSpecialServiceIDDep("");

    }

    private static void setDepartureBlank(SaveReservation s) {

        s.setDepDate("");
        s.setDepCancel("");
        s.setDepService("");
        s.setDepServiceidNew("");
        s.setDepPassenger("");
        s.setDepPickUp("");// deprecated do not pass anything
        s.setComplexDep("");
        s.setDepStreetNumber("");
        s.setDepStreet("");
        s.setDepUnit("");
        s.setDepZip("");
        s.setDepCity("");
        s.setDepDirections("");

        s.setFlyingTo("");
        s.setDepAirline("");// this is "1" ?
        s.setDepAP("");
        s.setDepFlt("");
        s.setDepFltTime("");

        s.setReqArvTime("");
        s.setDepPickupTime("");
        s.setCharterDep("");
        s.setSpecialServiceIDDep("");
        s.setComplexDep("");
    }

    private static void setArrivalBlank(SaveReservation s) {
        s.setArvGratuity("");
        s.setArvFee("");
        s.setArvPickupTime("");
        s.setArvFltTime("");
        s.setArvFlt("");
        s.setArvAirline("");
        s.setArvAirport("");
        s.setArvAP("");
        s.setArvCancel("");
        s.setArvCity("");
        s.setArvDate("");
        s.setArvDirections("");
        s.setArvPassenger("");
        s.setSpecialServiceIDArv("");
        s.setReqArvTime("");
        s.setComplexArv("");
        s.setCharterArv("");
        s.setArvZip("");
        s.setArvUnit("");
        s.setArvStreetNumber("");
        s.setArvStreet("");
        s.setArvServiceidNew("");
        s.setArvDate("");
        s.setArvService("");
    }

    /**
     * @param s
     * @param r
     */
    private static void extractArrivalSection(SaveReservation s, SaveReservationRequest r) {

        ArrivalInfo arrivalInfo = r.getReservation().getArrivalInfo();

        s.setArvDate(arrivalInfo.getTravelInfo().getTimeOfTravel().toString("MM/dd/yyyy"));
        s.setArvCancel("");
        s.setArvService("0");
        s.setArvServiceidNew("0");
        s.setArvPassenger(arrivalInfo.getTravelInfo().getPassengerCount());
        s.setComplexArv("");
        if (StringUtils.hasText(arrivalInfo.getTravelInfo().getAddress().getStreetNumber())) {
            s.setArvStreetNumber(arrivalInfo.getTravelInfo().getAddress().getStreetNumber());
        } else {
            s.setArvStreetNumber("");
        }

        s.setArvStreet(arrivalInfo.getTravelInfo().getAddress().getAddressLine());

        if (StringUtils.hasText(arrivalInfo.getTravelInfo().getAddress().getUnitName())) {
            s.setArvUnit(arrivalInfo.getTravelInfo().getAddress().getUnitName());
        } else {
            s.setArvUnit("");
        }
        s.setArvZip(arrivalInfo.getTravelInfo().getAddress().getZip());
        s.setArvCity(arrivalInfo.getTravelInfo().getAddress().getCity());
        s.setArvDirections("");
        s.setArvAirport(arrivalInfo.getTravelInfo().getAirport());
        s.setOrigin("");

        s.setArvAP("");
        s.setArvAirline(arrivalInfo.getTravelInfo().getAirlineId());// Now I know why this was 1 before.

        if (arrivalInfo.getTravelInfo().getFlightNumber() != null) {
            s.setArvFlt(arrivalInfo.getTravelInfo().getFlightNumber());
        } else {
            s.setArvFlt("");
        }

        if (arrivalInfo.getTravelInfo().getTimeOfTravel() != null) {
            String ampPm = arrivalInfo.getTravelInfo().getAmOrPm();
            String flightTime = arrivalInfo.getTravelInfo().getTimeOfTravel().toString(AmPm.patternByType(ampPm));
            if (AmPm.PM.getAm().equals(ampPm)) {
                flightTime = flightTime + " " + "PM";
            }
            s.setArvFltTime(flightTime);

        } else {
            s.setArvFltTime("");
        }
        if (arrivalInfo.getTravelInfo().getPickUpTime() != null) {
            s.setArvPickupTime(arrivalInfo.getTravelInfo().getPickUpTime());
        } else {
            s.setArvPickupTime("");
        }
        s.setCharterArv("");
        s.setSpecialServiceIDArv("");
        if (arrivalInfo.getTravelInfo().getGratuity() != null) {
            s.setArvGratuity(arrivalInfo.getTravelInfo().getGratuity());
        } else {
            s.setArvGratuity("");
        }


    }

    /**
     * @param s
     * @param r
     */
    private static void extractFareSection(SaveReservation s, SaveReservationRequest r) {
        FareInfo fareInfo = r.getReservation().getFareInfo();

        if (fareInfo.getRedemptionAmount() != null) {
            s.setRedemptionAmt(fareInfo.getRedemptionAmount().toPlainString());
        } else {
            s.setRedemptionAmt("");
        }
        if (fareInfo.getSpecialServiceAmount() != null) {
            s.setSpecialServiceamt(fareInfo.getSpecialServiceAmount().toPlainString());
        } else {
            s.setSpecialServiceamt("");
        }
        if (fareInfo.getDepartureFee() != null) {
            s.setDepFee(fareInfo.getDepartureFee().toPlainString());
        } else {
            s.setDepFee("");
        }
        if (fareInfo.getDepartureGratuity() != null) {
            s.setDepGratuity(fareInfo.getDepartureGratuity().toPlainString());
        } else {
            s.setDepGratuity("");
        }
        if (fareInfo.getArrivalFee() != null) {
            s.setArvFee(fareInfo.getArrivalFee().toPlainString());
        } else {
            s.setArvFee("");
        }

        if (fareInfo.getArrivalGratuity() != null) {
            s.setArvGratuity(fareInfo.getArrivalGratuity().toPlainString());
        } else {
            s.setArvGratuity("");
        }
        if (fareInfo.getDiscount() != null) {
            s.setDiscount(fareInfo.getDiscount());
        } else {
            s.setDiscount("");
        }
        if (fareInfo.getDiscountCode() != null) {
            s.setDiscCode(fareInfo.getDiscountCode());
        } else {
            s.setDiscCode("");
        }
        if (fareInfo.getSurcharge() != null) {
            s.setSurcharge(fareInfo.getSurcharge());
        } else {
            s.setSurcharge("");
        }

        s.setDiscAmt("");


    }

    /**
     * @param s
     * @param r
     */
    private static void extractPaymentSection(SaveReservation s, SaveReservationRequest r) {
        PaymentInfo paymentInfo = r.getReservation().getPaymentInfo();

        s.setCardType(paymentInfo.getCcTypeId());
        s.setCCNum(paymentInfo.getCreditCardNumber());
        s.setCCname(paymentInfo.getCardHolderFullName());
        s.setCCExpDate(paymentInfo.getExpirationDate());
        s.setCCCID(paymentInfo.getCvcCode());
        s.setCCTypeID(paymentInfo.getCcTypeId());
        s.setCZip(paymentInfo.getZip());
        s.setPmtMode("0");
        s.setPMTDetails("");
        s.setBillTo("");
    }

    /**
     * @param s
     * @param r
     */
    private static void extractCommonSection(SaveReservation s, SaveReservationRequest r) {
        RequestCommonInfo requestCommonInfo = r.getReservation().getRequestCommonInfo();
        s.setIsSendEmail(false);
        s.setMailTo("");
        s.setClientId("");
        s.setFltType("10");
        s.setSpecialServicesJourneyType("");
        s.setIP("");
        s.setResType(requestCommonInfo.getResType());
        s.setCouponEmail("");
        s.setConf(requestCommonInfo.getUserName());

        s.setReqType(requestCommonInfo.getRequestType());
        s.setInfoID(requestCommonInfo.getInfoId());


        s.setISWindowID("0");
        s.setSpecialinst("");
        s.setRestype1("1");
        s.setRestypedetail("");

    }


}
