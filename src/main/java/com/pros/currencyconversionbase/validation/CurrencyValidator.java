package com.pros.currencyconversionbase.validation;

import com.pros.currencyconversionbase.util.CurrencyUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This class validates the currency code.
 */
public class CurrencyValidator implements ConstraintValidator<ValidCurrency, String> {

    @Override
    public boolean isValid(String currencyCode, ConstraintValidatorContext context) {
        try {
            return CurrencyUtil.isValidCurrency(currencyCode);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
