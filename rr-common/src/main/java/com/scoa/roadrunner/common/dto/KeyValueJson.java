package com.scoa.roadrunner.common.dto;

import java.io.Serializable;
import java.util.List;

public class KeyValueJson implements Serializable {

    private final List<KeyValueDropDown> keyValueDropDown;

    public KeyValueJson(List<KeyValueDropDown> keyValueDropDown) {
        this.keyValueDropDown = keyValueDropDown;
    }

    public List<KeyValueDropDown> getKeyValueDropDown() {
        return keyValueDropDown;
    }
}
