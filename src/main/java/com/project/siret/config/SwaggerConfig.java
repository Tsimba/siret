package com.project.siret.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger Config
 *
 * @author  Nicolas Razanatsimba
 * @version 1.0
 * @since   2023-01-13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Method to set paths to be included through swagger
     *
     * @return Docket
     */
    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.siret"))
                .paths(regex("/siret.*"))
                .build();
    }

}
