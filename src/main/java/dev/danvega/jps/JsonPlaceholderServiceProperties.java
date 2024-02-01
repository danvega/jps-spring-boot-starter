package dev.danvega.jps;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jsonplaceholder")
public record JsonPlaceholderServiceProperties(String baseUrl) {
}
