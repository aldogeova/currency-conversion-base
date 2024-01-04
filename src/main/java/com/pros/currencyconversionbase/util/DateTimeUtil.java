package com.pros.currencyconversionbase.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2024-01-02
 * This class provides utility methods for working with dates and times.
 *
 */
public class DateTimeUtil {

    public static final DateTimeFormatter dateHourFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH").withZone(ZoneOffset.UTC);

    /**
     * This method returns the current date and hour in UTC format.
     *
     * @return The current date and hour in UTC format.
     */
    public static String getCurrentDateHourUTC(Instant instant) {
        return dateHourFormat.format(instant);
    }
}
