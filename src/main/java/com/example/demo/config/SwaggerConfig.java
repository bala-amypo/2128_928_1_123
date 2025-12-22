package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9037.pro604cr.amypo.ai/")
                ));
        }
}

// package com.example.demo.config;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @OpenAPIDefinition(
// info = @Info(
// title = "Employee Matrix API",
// version = "1.0",
// description = "API documentation for Employee Skill Matrix Project"
// )
// )
// public class SwaggerConfig {
// }
