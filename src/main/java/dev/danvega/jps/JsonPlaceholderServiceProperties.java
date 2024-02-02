package dev.danvega.jps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("json-placeholder-service")
public record JsonPlaceholderServiceProperties(
        @DefaultValue("https://jsonplaceholder.typicode.com")
        String baseUrl
) {

}


