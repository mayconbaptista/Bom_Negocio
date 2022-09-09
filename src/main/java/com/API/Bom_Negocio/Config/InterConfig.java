package com.API.Bom_Negocio.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

/*
* Classe de configuração das menssagens de validação das classes DTO
* arg de referencia -> messages.properties
*/
@Configuration
public class InterConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("ISO-8859-1");// codifição de texto
        messageSource.setDefaultLocale(Locale.getDefault());

        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean (){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(this.messageSource());

        return localValidatorFactoryBean;
    }
}
