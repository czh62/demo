package com.example.demo.config;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(@NotNull String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(source.trim(), "yyyy-MM-dd");
        }
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source.trim(), "yyyy-MM-dd HH:mm:ss");
        }
        throw new IllegalArgumentException("Invalid value '" + source + "'");
    }

    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            log.warn("转换{}为日期(pattern={})错误！", dateStr, format);
        }
        return date;
    }
}
