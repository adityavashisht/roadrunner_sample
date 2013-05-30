package com.scoa.roadrunner.web.converter;

import com.scoa.roadrunner.domain.reservation.RouteType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Aditya
 * Date: 4/16/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RouteTypeConverter implements Converter<String, RouteType> {
    @Override
    public RouteType convert(String s) {
        RouteType t = null;
        if (StringUtils.hasText(s)) {
            t = RouteType.fromString(s);
        }
        return t;
    }
}
