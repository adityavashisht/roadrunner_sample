package com.scoa.roadrunner.common.util;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern EMAIL = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    private static final Pattern PHONE = Pattern.compile("^[0-9]{3,20}");
    private static final Pattern NAME = Pattern.compile("^[a-zA-Z\\s]*$");
    private static final Pattern COMPANY = Pattern.compile("^[a-zA-Z0-9,][a-zA-Z0-9,'\\-.\\s]+$");
    private static final Pattern ADDRESS = Pattern.compile("^[a-zA-Z0-9,][a-zA-Z0-9,'\\-\\s]+$");
    private static final Pattern ZIP = Pattern.compile("^[a-zA-Z0-9]{3,15}");
    private static final Pattern CITY = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9,'\\-.\\s]+$");
    private static final Pattern SPECIAL_CHAR = Pattern.compile("[^&%$'\"#@!~_\\.]*");
    private static final Pattern SPECIAL_CHAR_EMAIL = Pattern.compile("[^&%$#)`!~\\s]*");
    private static final Pattern ALPHA_NUMERIC = Pattern.compile("^[a-zA-Z0-9\\s]*$");// allow white space in characeters
    private static final Pattern ALPHA = Pattern.compile("^[a-zA-Z ]*$");
    private static final Pattern NUMERIC = Pattern.compile("^[0-9.]*$");
    private static final Pattern ALPHA_WITH_SPACE = Pattern.compile("^[a-zA-Z\\s,]*$");
    private static final Pattern ALPHA_NUMERIC_WITHOUT_SPACE = Pattern.compile("^[a-zA-Z0-9]*$");// not allow white space in characeters

    /**
     * @param errors
     * @param field
     * @param errorCode
     */
    public static void rejectIfSpecial(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        if (value == null || !StringUtils.hasText(value.toString()) || !ValidationUtil.isSpecialCharacter(value.toString())) {
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    /**
     *
     * @param errors
     * @param field
     * @param errorCode
     */
    public static void rejectIfSpecialNoEmail(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        if (value == null || !StringUtils.hasText(value.toString()) || !ValidationUtil.isSpecialCharacterForEmail(value.toString())) {
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    /**
     *
     * @param errors
     * @param field
     * @param errorCode
     */
    public static void rejectIfNumeric(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        if (value == null || !StringUtils.hasText(value.toString()) || ValidationUtil.isNumeric(value.toString())) {
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    /**
     *
     * @param errors
     * @param field
     * @param errorCode
     */
    public static void rejectIfNonAlpha(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        if (value == null || !StringUtils.hasText(value.toString()) || !ValidationUtil.isAlpha(value.toString())) {
            errors.rejectValue(field, errorCode, null, null);
        }

    }

    /**
     *
     * @param errors
     * @param field
     * @param maxLength
     * @param errorCode
     */
    public static void rejectIfExceedsMaxLength(Errors errors, String field, Integer maxLength, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        if ((errors.getFieldErrorCount(field) < 1) && (value.toString().length() > maxLength)) {
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isNumeric(String value) {
        return NUMERIC.matcher(value).matches();
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isAlphaNumeric(String value) {
        return ALPHA_NUMERIC.matcher(value).matches();
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isAlpha(String value) {
        return ALPHA.matcher(value).matches();
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isAlphaWithSpace(String value) {
        return ALPHA_WITH_SPACE.matcher(value).matches();
    }

    /**
     *
     * @param value
     * @return
     */
    public static boolean isAlphaNumericWithoutSpace(String value) {
        return ALPHA_NUMERIC_WITHOUT_SPACE.matcher(value).matches();
    }

    /**
     *
     * @param string
     * @return
     */
    public static boolean isValidEmail(String string) {
        return EMAIL.matcher(string).matches() && isSpecialCharacterForEmail(string);
    }

    // Phone Number Validation Eg. 15615552323 | 1-561-555-1212 | 5613333
    public static boolean isValidPhone(String phone) {
        return PHONE.matcher(phone).matches() && isSpecialCharacter(phone);
    }

    /**
     *
     * @param name
     * @return
     */
    public static boolean isValidName(String name) {
        return NAME.matcher(name).matches() && isSpecialCharacter(name);
    }

    /**
     *
     * @param companyName
     * @return
     */
    public static boolean isValidCompanyName(String companyName) {
        return COMPANY.matcher(companyName).matches() && isSpecialCharacter(companyName);

    }

    /**
     *
     * @param address
     * @return
     */
    public static boolean isValidAddress(String address) {
        return ADDRESS.matcher(address).matches() && isSpecialCharacter(address);

    }

    /**
     *
     * @param zip
     * @return
     */
    public static boolean isValidZip(String zip) {
        return ZIP.matcher(zip).matches() && ValidationUtil.isSpecialCharacter(zip);

    }

    public static boolean isValidCity(String city) {
        return CITY.matcher(city).matches() && ValidationUtil.isSpecialCharacter(city);
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean isSpecialCharacter(String input) {
        return SPECIAL_CHAR.matcher(input).matches();
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean isSpecialCharacterForEmail(String input) {
        return SPECIAL_CHAR_EMAIL.matcher(input).matches();
    }
}
