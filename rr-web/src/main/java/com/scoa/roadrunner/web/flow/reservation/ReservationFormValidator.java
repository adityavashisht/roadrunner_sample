package com.scoa.roadrunner.web.flow.reservation;


import com.scoa.roadrunner.common.util.CommonsValidatorUtil;
import com.scoa.roadrunner.common.util.ValidationUtil;
import com.scoa.roadrunner.domain.reservation.RouteType;
import com.scoa.roadrunner.domain.reservation.ZipOrLandMarkSelect;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ReservationFormValidator {

    /**
     * @param reservationForm
     * @param errors
     */
    public void validateRouteStep1(ReservationForm reservationForm, Errors errors) {
        RouteStepOne stepOne = reservationForm.getRouteStepOne();
        ;
        if (stepOne.getRouteType() == null) {
            errors.rejectValue("routeStepOne.routeType", "route.step.one.route.type.required");
        }
        if (stepOne.getDirectionType() == null) {
            errors.rejectValue("routeStepOne.directionType", "route.step.one.direction.type.required");
        }
        if (ZipOrLandMarkSelect.ZIP.equals(reservationForm.getRouteStepOne().getZipOrLandMarkSelect())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepOne.zipCode", "route.step.one.zipCode.required");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepOne.airport", "route.step.one.airport.required");
        if (!errors.hasFieldErrors("routeStepOne.airport")) {
            if ("-1".equals(stepOne.getAirport())) {
                errors.rejectValue("routeStepOne.airport", "route.step.one.airport.required");
            }

        }

    }

    /**
     * @param reservationForm
     * @param errors
     */
    public void validateRouteStep2(ReservationForm reservationForm, Errors errors) {
        RouteStepTwo routeStepTwo = reservationForm.getRouteStepTwo();
        RouteStepOne routeStepOne = reservationForm.getRouteStepOne();
        // Add all validations here
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.travelerInfo.contactInformation.firstName", "route.step.two.firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.travelerInfo.contactInformation.lastName", "route.step.two.lastName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.travelerInfo.contactInformation.email", "route.step.two.email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.travelerInfo.contactInformation.address.addressLine", "route.step.two.address.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.travelerInfo.contactInformation.address.city", "route.step.two.city.required");


        if (!errors.hasFieldErrors("routeStepTwo.travelerInfo.contactInformation.email")) {
            if (!CommonsValidatorUtil.isValidEmail(routeStepTwo.getTravelerInfo().getContactInformation().getEmail())) {
                errors.rejectValue("routeStepTwo.travelerInfo.contactInformation.email", "route.step.two.email.invalid");
            }
        }
        if (routeStepOne.getRouteType().equals(RouteType.FROM)) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.arrivalInfo.travelInfo.airlineName", "route.step.two.airline.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.arrivalInfo.travelInfo.flightNumber", "route.step.two.flight.number.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.arrivalInfo.travelInfo.hourFlight", "route.step.two.flight.time.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.arrivalInfo.travelInfo.minuteFlight", "route.step.two.flight.time.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.pickUpTime", "route.step.two.pickup.time.required");
        } else if (routeStepOne.getRouteType().equals(RouteType.TO)) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.departureInfo.travelInfo.airlineName", "route.step.two.airline.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.departureInfo.travelInfo.flightNumber", "route.step.two.flight.number.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.departureInfo.travelInfo.hourFlight", "route.step.two.flight.time.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.departureInfo.travelInfo.minuteFlight", "route.step.two.flight.time.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepTwo.pickUpTime", "route.step.two.pickup.time.required");
        }

    }

    /**
     * @param reservationForm
     * @param errors
     */
    public void validateRouteStep3(ReservationForm reservationForm, Errors errors) {
        RouteStepThree routeStepThree = reservationForm.getRouteStepThree();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepThree.paymentInfo.cardHolderFullName", "route.step.three.cardholder.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepThree.paymentInfo.creditCardNumber", "route.step.three.credit.card.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepThree.paymentInfo.zip", "route.step.three.zip.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeStepThree.paymentInfo.cvcCode", "route.step.three.cvcCode.required");

        // Additional invalid checks for input fields
        if (!errors.hasFieldErrors("routeStepThree.paymentInfo.creditCardNumber")) {
            if (!CommonsValidatorUtil.isValidCreditCardNumber(routeStepThree.getPaymentInfo().getCreditCardNumber())) {
                errors.rejectValue("routeStepThree.paymentInfo.creditCardNumber", "route.step.three.credit.card.invalid");
            }
        }
        // Additional checks
        if (!errors.hasFieldErrors("routeStepThree.paymentInfo.cardHolderFullName")) {
            if (!ValidationUtil.isAlphaWithSpace(routeStepThree.getPaymentInfo().getCardHolderFullName())) {
                errors.rejectValue("routeStepThree.paymentInfo.cardHolderFullName", "route.step.three.cardholder.invalid");
            }
        }
        // Zip is numeric only
        if (!errors.hasFieldErrors("routeStepThree.paymentInfo.zip")) {
            if (!ValidationUtil.isNumeric(routeStepThree.getPaymentInfo().getZip())) {
                errors.rejectValue("routeStepThree.paymentInfo.zip", "route.step.three.zip.invalid");
            }
        }
        // cvcCode is numeric only
        if (!errors.hasFieldErrors("routeStepThree.paymentInfo.cvcCode")) {
            if (!ValidationUtil.isNumeric(routeStepThree.getPaymentInfo().getCvcCode())) {
                errors.rejectValue("routeStepThree.paymentInfo.cvcCode", "route.step.three.cvcCode.invalid");
            }
        }

        if (routeStepThree.getTerms() != null && !routeStepThree.getTerms()) {
            errors.rejectValue("routeStepThree.terms", "route.step.three.terms");
        }

    }
}
