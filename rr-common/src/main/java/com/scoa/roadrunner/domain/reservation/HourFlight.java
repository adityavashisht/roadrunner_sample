package com.scoa.roadrunner.domain.reservation;

import java.util.Arrays;
import java.util.List;


public enum HourFlight {
    ONE("0", "12 AM", "00"),
    TWO("1", "1 AM","01"),
    THREE("2", "2 AM", "02"),
    FOUR("3", "3 AM", "03"),
    FIVE("4", "4 AM", "04"),
    SIX("5", "5 AM", "05"),
    SEVEN("6", "6 AM", "06"),
    EIGHT("7", "7 AM", "07"),
    NINE("8", "8 AM", "08"),
    TEN("9", "9 AM", "09"),
    ELEVEN("10", "10 AM", "10"),
    TWELVE("11", "11 AM", "11"),
    THIRTEEN("12", "12 PM", "12"),
    FOURTEEN("13", "1 PM", "01"),
    FIFTEEN("14", "2 PM", "02"),
    SIXTEEN("15", "3 PM", "03"),
    SEVENTEEN("16", "4 PM", "04"),
    EIGHTEEN("17", "5 PM", "05"),
    NINETEEN("18", "6 PM", "06"),
    TWENTY("19", "7 PM", "07"),
    TWO_ONE("20", "8 PM", "08"),
    TWO_TWO("21", "9 PM", "09"),
    TWO_THREE("22", "10 PM", "10"),
    TWO_FOUR("23", "11 PM", "11");

    private final String hour;
    private final String displayValue;
    private String passThroughValue;
    
    private HourFlight(String hour, String displayValue, String passThroughValue) {
        this.hour = hour;
        this.displayValue = displayValue;
        this.passThroughValue = passThroughValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getPassThroughValue() {
        return passThroughValue;
    }

    /**
     * @param value
     * @return
     */
    public static HourFlight fromString(String value) {
        HourFlight routeType = HourFlight.ONE;
        for (HourFlight t : HourFlight.values()) {
            if (t.getHour().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }

    public static List<HourFlight> getAll() {
        return Arrays.asList(HourFlight.values());
    }


    public String getHour() {
        return hour;
    }


}
