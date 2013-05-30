package com.scoa.roadrunner.web.converter;

import com.scoa.roadrunner.domain.reservation.DirectionType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class DirectionTypeConverter implements Converter<String, DirectionType> {
    @Override
    public DirectionType convert(String s) {
        DirectionType t = null;
        if (StringUtils.hasText(s)) {
            t = DirectionType.fromString(s);
        }
        return t;
    }
}
