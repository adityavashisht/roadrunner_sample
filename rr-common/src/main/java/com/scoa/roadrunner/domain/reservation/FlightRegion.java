package com.scoa.roadrunner.domain.reservation;

import java.util.Arrays;
import java.util.List;


public enum FlightRegion {

    DOMESTIC("D", "Domestic"), INTERNATIONAL("I", "International");

    private final String selection;
    private final String code;

    private FlightRegion(String code, String selection) {
        this.selection = selection;
        this.code = code;
    }

    public String getSelection() {
        return selection;
    }

    /**
     * @param value
     * @return
     */
    public static FlightRegion fromString(String value) {
        FlightRegion routeType = FlightRegion.DOMESTIC;
        for (FlightRegion t : FlightRegion.values()) {
            if (t.getCode().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }


    public String getCode() {
        return code;
    }

    public static List<FlightRegion> getAll() {
        return Arrays.asList(FlightRegion.values());
    }
}
