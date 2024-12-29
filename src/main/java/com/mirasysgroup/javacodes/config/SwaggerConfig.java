package com.mirasysgroup.javacodes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI userMicroserviceOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("JavaCodes Application")
                        .description("testing concepts")
                        .version("1.0.0")
        );
    }



}
