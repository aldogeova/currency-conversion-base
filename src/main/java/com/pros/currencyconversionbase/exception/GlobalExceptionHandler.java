package com.pros.currencyconversionbase.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This class handles the exceptions thrown by the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * This method handles the general exceptions.
     *
     * @param ex The general exception.
     * @return The response entity with the general error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        logger.error(ex.getMessage());
        errors.put("error", "General error. Please contact with the administrator.");
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * This method handles the currency conversion exceptions.
     *
     * @param ex The currency conversion exception.
     * @return The response entity with the currency conversion errors.
     */
    @ExceptionHandler(CurrencyConversionException.class)
    public ResponseEntity<Object> handleCurrencyConversionException(CurrencyConversionException ex) {
        if(ex.getMessage().equals(CurrencyConversionMessageEnm.VALIDATION.name())){
            return ResponseEntity.badRequest().body(ex.getAditionalDetails());
        }else{
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", ex.getMessage()));
        }
    }

    /**
     * This method handles the validation exceptions.
     *
     * @param ex The validation exception.
     * @return The response entity with the validation errors.
     */
    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Object> handleValidationExceptions(WebExchangeBindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * This method handles the server web input exceptions.
     *
     * @param ex The server web input exception.
     * @return The response entity with the server web input errors.
     */
    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<?> handleServerWebInputException(ServerWebInputException ex) {
        Throwable cause = ex.getCause();
        Map<String, String> errors = new HashMap<>();
        if (cause instanceof DecodingException) {
            DecodingException ife = (DecodingException) cause;
            if (ife.getMessage().contains("java.time.format.DateTimeParseException")) {
                errors.put("dateError", "The field related to date and time must be a valid date and time. For example: 2023-12-29T00:57:03.704Z.");
                return ResponseEntity.badRequest().body(errors);
            }
            errors.put("invalidFormat", ife.getMessage());
            return ResponseEntity.badRequest().body(errors);
        }
        errors.put("error", "General error. Please contact with the administrator.");
        return ResponseEntity.badRequest().body(errors);
    }

}
