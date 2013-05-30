package com.scoa.roadrunner.web.converter;

import com.scoa.roadrunner.domain.reservation.FlightRegion;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Aditya
 * Date: 4/21/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlightRegionConverter implements Converter<String, FlightRegion> {

    @Override
    public FlightRegion convert(String s) {
        FlightRegion t = null;
        if (StringUtils.hasText(s)) {
            t = FlightRegion.fromString(s);
        }
        return t;
    }

}
