package dev.danvega.jps;

import dev.danvega.jps.todo.TodoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(JsonPlaceholderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JsonPlaceholderServiceConfiguration.class);
    private final JsonPlaceholderServiceProperties jpsProperties;

    public JsonPlaceholderServiceConfiguration(JsonPlaceholderServiceProperties properties) {
        log.info("Configuring JsonPlaceHolderService with properties: {}", properties);
        jpsProperties = properties;
    }

    @Bean
    TodoClient todoClient(RestClient restClient) {
        return new TodoClient(restClient);
    }

    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl(jpsProperties.baseUrl())
                .build();
    }

}
