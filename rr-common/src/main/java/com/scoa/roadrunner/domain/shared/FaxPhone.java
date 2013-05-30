package com.scoa.roadrunner.domain.shared;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ADITYA
 * Date: 6/24/12
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class FaxPhone implements Serializable {
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
