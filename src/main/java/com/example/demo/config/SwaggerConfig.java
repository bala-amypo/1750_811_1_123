package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Skill Matrix API")
                        .version("1.0")
                        .description("REST APIs for managing employees, skills, and skill-based search")
                        .contact(new Contact()
                                .name("Sudharsun")
                                .email("sudharsun@example.com"))
                        .license(new License()
                                .name("Apache 2.0")));
    }
}
