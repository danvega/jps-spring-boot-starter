package dev.danvega.jps;

import dev.danvega.jps.todo.JpsTodoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(JsonPlaceholderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JsonPlaceholderServiceConfiguration.class);
    private final JsonPlaceholderServiceProperties jpsProperties;

    public JsonPlaceholderServiceConfiguration(JsonPlaceholderServiceProperties properties) {
        log.info("Configuring JsonPlaceHolderService with properties: {}", properties);
        jpsProperties = properties;
    }

    @Bean
    JpsTodoClient todoClient(RestClient restClient) {
        return new JpsTodoClient(restClient);
    }

    @Bean
    RestClient restClient(RestClient.Builder builder) {
        String baseUrl = jpsProperties.baseUrl() ==
                null ? "https://jsonplaceholder.typicode.com" : jpsProperties.baseUrl();
        return builder
                .baseUrl(baseUrl)
                .build();
    }

}
