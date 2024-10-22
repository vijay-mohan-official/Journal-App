package com.learning.journalApp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig(){
        return new OpenAPI()
                //Configuring custom Title and Description for Swagger UI page
                .info(
                new Info().title("Journal App APIs")
                        .description("By Vijay Mohan")
                )
                //Configuring list of URLs
                .servers(Arrays.asList(new Server().url("http://localhost:8090").description("office"),
                        new Server().url("http://localhost:8080").description("home")))
                //Adding order of Controllers to list in Swagger UI (This feature is deprecated in latest version of Swagger)
                .tags(Arrays.asList(
                        new Tag().name("Health Check API")
                ))
                //Mentioning to Swagger that we have configured Spring Security and JWT and make this available for requests in Swagger UI
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes(
                        "bearerAuth",new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                ));
    }

}
