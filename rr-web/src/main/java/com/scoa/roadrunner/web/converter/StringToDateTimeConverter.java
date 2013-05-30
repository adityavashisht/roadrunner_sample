package com.scoa.roadrunner.web.converter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.springframework.core.convert.converter.Converter;

import org.springframework.util.StringUtils;

/**
 *
 *
 *
 */
public class StringToDateTimeConverter implements Converter<String, DateTime> {

    @Override
    public DateTime convert(String source) {

        DateTimeParser[] parsers = {
                DateTimeFormat.forPattern("MM-dd-yyyy").getParser(),
                DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
                DateTimeFormat.forPattern("MM/dd/yyyy").getParser(),
                DateTimeFormat.forPattern("yyyy/MM/dd").getParser()
        };

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .append(null, parsers)
                .toFormatter()
                .withZone(DateTimeZone.UTC);

        if (StringUtils.hasText(source)) {
            DateTime dateTime =  formatter.parseDateTime(source);
            return dateTime;
        } else {
            return null;
        }
    }
}
