package com.scoa.roadrunner.domain.reservation;

public enum DirectionType {

    ONE_WAY("O", "One Way"), ROUND_TRIP("R", "Round Trip");
    private final String direction;
    private final String displayValue;

    private DirectionType(String direction, String displayValue) {
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
    public static DirectionType fromString(String value) {
        DirectionType routeType = DirectionType.ONE_WAY;
        for (DirectionType t : DirectionType.values()) {
            if(t.getDirection().equals(value)) {
                routeType = t;
                break;
            }
        }
        return routeType;
    }
}
