package com.scoa.roadrunner.domain.reservation;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Aditya
 * Date: 4/22/13
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public enum AmPm {
    AM("AM", "MM/dd/yyyy HH:MM a"), PM("PM", "MM/dd/yyyy HH:MM");
    private final String am;
    private final String pattern;

    private AmPm(String am, String pattern) {
        this.am = am;
        this.pattern = pattern;
    }

    public String getAm() {
        return am;
    }

    public String getPattern() {
        return pattern;
    }

    /**
     *
     * @param amPm
     * @return
     */
    public static String patternByType(String amPm) {
        AmPm val = AmPm.AM;
        if (amPm != null) {
            for(AmPm temp: AmPm.values()) {
                if(temp.getAm().equals((amPm))){
                    val = temp;
                    break;
                }
            }
        }
        return val.getPattern();
    }

    /**
     * @param value
     * @return
     */
    public static AmPm fromString(String value) {
        AmPm routeType = AmPm.AM;
        for (AmPm t : AmPm.values()) {
            if (t.getAm().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }

    public static List<AmPm> getAll() {
        return Arrays.asList(AmPm.values());
    }
}
