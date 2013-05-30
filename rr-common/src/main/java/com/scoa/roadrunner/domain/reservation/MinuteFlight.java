package com.scoa.roadrunner.domain.reservation;

import java.util.Arrays;
import java.util.List;


public enum MinuteFlight {
    ZZ("00"),FIVE("05"), TEN("10"), FIFTEEN("15"), TWENTY("20"), TWO_FIVE("25"), THREE_ZERO("30"), THREE_FIVE("35"), FOUR_ZERO("40"), FOUR_FIVE("45"), FIVE_ZERO("50"), FIVE_FIVE("55");
    private final String minute;

    private MinuteFlight(String minute) {
        this.minute = minute;
    }

    public String getMinute() {
        return minute;
    }

    /**
     * @param value
     * @return
     */
    public static MinuteFlight fromString(String value) {
        MinuteFlight routeType = MinuteFlight.ZZ;
        for (MinuteFlight t : MinuteFlight.values()) {
            if (t.getMinute().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }




    public static List<MinuteFlight> getAll() {
        return Arrays.asList(MinuteFlight.values());
    }


}
