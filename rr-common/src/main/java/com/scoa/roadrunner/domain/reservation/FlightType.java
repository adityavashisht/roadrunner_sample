package com.scoa.roadrunner.domain.reservation;


public enum FlightType {
    ARRIVAL(1), DEPARTURE(2), ROUND_TRIP(10);
    private int code;
    private FlightType(int value) {
        code = value;
    }

    public int getCode() {
        return code;
    }
}
