package br.com.attornatus.api.pessoas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}