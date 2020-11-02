package com.engine.fakau.springjwtsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Set<String> apiProduceConsume =
            new HashSet<String>(Collections.singletonList("application/json"));

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(apiProduceConsume)
                .consumes(apiProduceConsume);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring jwt security- Rest API")
                .description("share my spring boot experience")
                .contact(new Contact("Kafka M. Laurent", "http://portfolio.laurentkafka123.now.sh", "laurentkafka123@gmail.com"))
                .build();
    }

}
