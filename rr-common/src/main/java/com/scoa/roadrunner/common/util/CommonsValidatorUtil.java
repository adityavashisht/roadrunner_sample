package com.scoa.roadrunner.common.util;

import org.apache.commons.validator.CreditCardValidator;
import org.apache.commons.validator.EmailValidator;


public class CommonsValidatorUtil {

    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        return new CreditCardValidator().isValid(creditCardNumber);
    }
}
