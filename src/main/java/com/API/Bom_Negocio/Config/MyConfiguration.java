package com.API.Bom_Negocio.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class MyConfiguration {

    @Bean
    public CommandLineRunner executa (){
        return args -> {
            System.out.println("Rodando Ambiente de DESENVOLVIMENTO");
        };
    }
}
