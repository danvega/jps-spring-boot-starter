package dev.danvega.jps.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

public class TodoClient {

    private static final Logger log = LoggerFactory.getLogger(TodoClient.class);
    private final RestClient restClient;

    public TodoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Todo> findAll() {
        return restClient.get()
                .uri("/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }


}
