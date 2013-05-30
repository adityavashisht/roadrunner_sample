package com.scoa.roadrunner.web.converter;

import com.scoa.roadrunner.domain.reservation.CreditCardType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 4/22/13
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCardTypeConverter implements Converter<String, CreditCardType> {

    @Override
    public CreditCardType convert(String s) {
        CreditCardType t = null;
        if (StringUtils.hasText(s)) {
            t = CreditCardType.fromString(s);
        }
        return t;
    }
}
