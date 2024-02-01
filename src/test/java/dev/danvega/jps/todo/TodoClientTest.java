package dev.danvega.jps.todo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.jps.JsonPlaceholderServiceConfiguration;
import dev.danvega.jps.JsonPlaceholderServiceProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(TodoClient.class)
@Import(JsonPlaceholderServiceConfiguration.class)
class TodoClientTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    TodoClient todoClient;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JsonPlaceholderServiceProperties jpsProperties;

    @Test
    void shouldFindAllTodos() throws JsonProcessingException {
        List<Todo> mockData = List.of(new Todo(1,1, "Learn Spring Boot", true));

        server.expect(requestTo(jpsProperties.baseUrl() + "/todos"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(mockData), MediaType.APPLICATION_JSON));

        List<Todo> todos = todoClient.findAll();

        assertEquals(1, todos.size());
    }
}