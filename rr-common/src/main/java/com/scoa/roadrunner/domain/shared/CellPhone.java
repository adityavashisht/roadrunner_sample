package com.scoa.roadrunner.domain.shared;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 4/17/12
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CellPhone implements Serializable {

    private String areaCode;
    private String number;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
