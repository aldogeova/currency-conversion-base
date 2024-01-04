package com.pros.currencyconversionbase.util;

import java.time.Instant;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2024-01-02
 */
public class CacheUtil {


    /**
     * This method generates the default cache key for a currency exchange rate.
     *
     * @param sourceCurrency
     * @param targetCurrency
     * @param date
     * @return
     */
    public static String defaultKey(String sourceCurrency, String targetCurrency, Instant date) {
        return sourceCurrency.concat("-").concat(targetCurrency).concat("-").concat(DateTimeUtil.getCurrentDateHourUTC(date));
    }


}
