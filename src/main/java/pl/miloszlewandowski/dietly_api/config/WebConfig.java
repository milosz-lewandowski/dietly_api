package pl.miloszlewandowski.dietly_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@EnableAutoConfiguration
public class WebConfig {

    @Bean
    public ObjectMapper configureJson() {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
                .build();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeJson()
    {
        return builder -> {

            builder.indentOutput(true);
            builder.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        };
    }
}