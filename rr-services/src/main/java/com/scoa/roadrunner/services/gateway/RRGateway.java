package com.scoa.roadrunner.services.gateway;

import com.scoa.roadrunner.common.dto.KeyValueDropDown;
import com.scoa.roadrunner.common.dto.ReservationFare;
import com.scoa.roadrunner.common.payload.ReservationFareRequest;
import com.scoa.roadrunner.common.payload.SaveReservationRequest;
import com.scoa.roadrunner.common.payload.SaveReservationResponse;
import com.scoa.roadrunner.domain.reservation.Reservation;

import java.util.List;


public interface RRGateway {
    /**
     *
     * @param prefix
     * @return
     */
    List<KeyValueDropDown> getAirportByPrefix(String prefix);

    /**
     *
     * @param prefix
     * @return
     */
    List<KeyValueDropDown> getAirlinesByPrefix(String prefix);

    /**
     *
     * @param fareRequest
     * @return
     */
    ReservationFare getReservationFareForRoute(ReservationFareRequest fareRequest);

    /**
     *
     * @param reservationRequest
     * @return
     */
    SaveReservationResponse createNewReservation(SaveReservationRequest reservationRequest);


}
