package com.scoa.roadrunner.domain.reservation;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 4/23/13
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Airport {

    PHX("PHX", "Phoenix Sky Harbor International Airport", "85034") , AZA("AZA", "PhoenixMesa Gateway Airport", "85212");
    private final String code;
    private final String name;
    private final String zipCode;

    private Airport(String code, String name, String zipCode) {
        this.code = code;
        this.name = name;
        this.zipCode = zipCode;
    }

    public static List<Airport> getAll() {
        return Arrays.asList(Airport.values());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param value
     * @return
     */
    public static Airport fromString(String value) {
        Airport airport = null;
        for (Airport t : Airport.values()) {
            if (t.getCode().equals(value)) {
                airport = t;
                break;
            }
        }
        return airport;
    }
}
