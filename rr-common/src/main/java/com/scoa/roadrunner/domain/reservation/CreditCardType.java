package com.scoa.roadrunner.domain.reservation;


import java.util.Arrays;
import java.util.List;

public enum CreditCardType {
    MASTERCARD(1,"MasterCard"), VISA(0, "Visa"), AMEX(2, "American Express"), DISCOVER(3, "Discover");

    private final int code;
    private final String displayValue;

    private CreditCardType(int value, String displayValue) {
        code = value;
        this.displayValue = displayValue;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    /**
     *
     * @param value
     * @return
     */
    public static CreditCardType fromString(String value) {
        CreditCardType creditCardType = CreditCardType.VISA;
        for (CreditCardType t : CreditCardType.values()) {
            int intValue = Integer.valueOf(value);
            if(t.getCode()== intValue) {
                creditCardType = t;
                break;
            }
        }
        return creditCardType;
    }

    /**
     * To show in drop down selection
     * @return
     */
    public static List<CreditCardType> getAll() {
        return Arrays.asList(CreditCardType.values());
    }


}
