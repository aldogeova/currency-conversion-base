package com.pros.currencyconversionbase.util;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This class contains the methods to validate currencies.
 */
public class CurrencyUtil {

    /**
     * This method validates if a currency code is valid.
     *
     * @param currencyCode The currency code to validate.
     * @return True if the currency code is valid, false otherwise.
     */
    public static boolean isValidCurrency(String currencyCode) {
        if (currencyCode == null) {
            return false;
        }
        try {
            Currency currency = Currency.getInstance(currencyCode);
            return currency != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    /**
     * This method returns a set of the base currencies.
     *
     * @return A set of the base currencies.
     */
    public static Set<Currency> baseCurrencies() {
        Set<Currency> currencies = new HashSet<>();
        // USA Dolar
        currencies.add(Currency.getInstance("USD"));
        // Euro
        currencies.add(Currency.getInstance("EUR"));
        // Japanese Yen
        currencies.add(Currency.getInstance("JPY"));
        // British Pound
        currencies.add(Currency.getInstance("GBP"));
        // Swiss Franc
        currencies.add(Currency.getInstance("CHF"));
        // Canadian Dollar
        currencies.add(Currency.getInstance("CAD"));
        // Australian Dollar
        currencies.add(Currency.getInstance("AUD"));
        // Chinese Yuan
        currencies.add(Currency.getInstance("CNY"));
        // Hong Kong Dollar
        currencies.add(Currency.getInstance("HKD"));
        // New Zealand Dollar
        currencies.add(Currency.getInstance("NZD"));

        return currencies;
    }

}
