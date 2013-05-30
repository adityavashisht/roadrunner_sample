package com.scoa.roadrunner.domain.reservation;


import java.util.Arrays;
import java.util.List;


public enum ZipOrLandMarkSelect {

    ZIP("Z", "Zip")/*, LANDMARK("L", "Landmark")*/;
    private final String selection;
    private final String code;

    private ZipOrLandMarkSelect(String code, String selection) {
        this.code = code;
        this.selection = selection;
    }


    public String getSelection() {
        return selection;
    }

    /**
     * @param value
     * @return
     */
    public static ZipOrLandMarkSelect fromString(String value) {
        ZipOrLandMarkSelect routeType = ZipOrLandMarkSelect.ZIP;
        for (ZipOrLandMarkSelect t : ZipOrLandMarkSelect.values()) {
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

    public static List<ZipOrLandMarkSelect> getAll() {
        return Arrays.asList(ZipOrLandMarkSelect.values());
    }
}
