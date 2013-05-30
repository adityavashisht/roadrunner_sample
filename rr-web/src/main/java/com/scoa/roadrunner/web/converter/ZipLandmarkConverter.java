package com.scoa.roadrunner.web.converter;

import com.scoa.roadrunner.domain.reservation.ZipOrLandMarkSelect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class ZipLandmarkConverter implements Converter<String,ZipOrLandMarkSelect> {
    @Override
    public ZipOrLandMarkSelect convert(String s) {
        ZipOrLandMarkSelect t = null;
        if (StringUtils.hasText(s)) {
            t = ZipOrLandMarkSelect.fromString(s);
        }
        return t;
    }
}
