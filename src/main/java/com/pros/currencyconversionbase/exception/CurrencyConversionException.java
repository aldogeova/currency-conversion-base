package com.pros.currencyconversionbase.exception;

import lombok.Getter;

import java.util.Map;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-31
 *
 * This exception is thrown when an error occurs during currency conversion.
 *
 */
@Getter
public class CurrencyConversionException  extends  Exception{

    private Map<String, String> aditionalDetails;

    public CurrencyConversionException(String message){
        super(message);
    }

    public CurrencyConversionException(String message, Map<String, String> aditionalDetails){
        super(message);
        this.aditionalDetails = aditionalDetails;
    }

}
