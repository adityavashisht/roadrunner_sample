package com.scoa.roadrunner.domain.reservation;


public enum RouteType {
    FROM("F","From Airport"), TO("T", "To Airport"), AIRPORT_TO_AIRPORT("A", "Airport To Airport");
    private final String direction;
    private final String displayValue;

    private RouteType(String direction, String displayValue) {
        this.direction = direction;
        this.displayValue = displayValue;
    }

    public String getDirection() {
        return direction;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    /**
     *
     * @param value
     * @return
     */
    public static RouteType fromString(String value) {
        RouteType routeType = RouteType.TO;
        for (RouteType t : RouteType.values()) {
            if(t.getDirection().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }
}
