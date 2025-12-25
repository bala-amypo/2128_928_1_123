package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeeSkillMatrixOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Skills Matrix Search API")
                        .description("REST APIs for managing employees, skills, and skill-based search")
                        .version("1.0"));
    }
}
