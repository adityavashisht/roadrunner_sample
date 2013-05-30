package com.scoa.roadrunner.common.payload;

import java.io.Serializable;

public class SaveReservationResponse implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
