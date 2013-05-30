package com.scoa.roadrunner.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 4/15/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeAheadData implements Serializable {

    private final List<KeyValueDropDown> options;

    public TypeAheadData(List<KeyValueDropDown> data) {
        options = data;
    }

    public List<KeyValueDropDown> getOptions() {
        return options;
    }
}
