package com.winzfast.configuration;


import com.winzfast.converter.user.LoginConverter;
import com.winzfast.converter.user.RegisterConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfiguration implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**") // Đường dẫn API của bạn
//                .allowedOrigins("http://localhost:63343") // Nguồn gốc của frontend của bạn
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Phương thức được phép
//                .allowedHeaders("*") // Cho phép tất cả các header
//                .allowCredentials(true); // Cho phép chia sẻ cookie (nếu cần thiết)
//    }

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
