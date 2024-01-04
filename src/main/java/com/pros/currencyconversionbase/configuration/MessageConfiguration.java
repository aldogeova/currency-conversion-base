package com.pros.currencyconversionbase.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Aldo Navarrete
 * @version 1.0.0
 * @since 2023-12-28
 * Message configuration class.
 */
@Configuration
public class MessageConfiguration {

    /**
     * Message source bean.
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
