package com.winzfast.configuration;


import com.winzfast.converter.user.LoginConverter;
import com.winzfast.converter.user.RegisterConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public LoginConverter loginConverter() {
        return new LoginConverter();
    }

    @Bean
    public RegisterConverter registerConverter() {
        return new RegisterConverter();
    }
}
