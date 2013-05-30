package com.scoa.roadrunner.common.payload;

import com.scoa.roadrunner.domain.reservation.Reservation;

import java.io.Serializable;


public class SaveReservationRequest implements Serializable {
    private Reservation reservation = new Reservation();

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
