package dev.danvega.jps;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("json.placeholder-service")
public record JsonPlaceholderServiceProperties(String baseUrl) {

}
