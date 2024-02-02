package dev.danvega.jps.todo;

import dev.danvega.jps.JsonPlaceholderServiceConfiguration;
import dev.danvega.jps.JsonPlaceholderServiceProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JpsTodoClientTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(RestClientAutoConfiguration.class, JsonPlaceholderServiceConfiguration.class));

    @Test
    void shouldContainTodoRestClientBean() {
        contextRunner.run(context -> {
            assertTrue(context.containsBean("jsonPlaceholderRestClient"));
            assertTrue(context.containsBean("jpsTodoClient"));
        });
    }

    @Test
    void shouldContainDefaultBaseUrl() {
        contextRunner
                .run((context) -> {
                    assertThat(context).hasSingleBean(JsonPlaceholderServiceProperties.class);
                    assertThat(context.getBean(JsonPlaceholderServiceProperties.class).baseUrl()).isEqualTo("https://jsonplaceholder.typicode.com");
                });
    }

    @Test
    void shouldSetCustomBaseUrl() {
        contextRunner
                .withPropertyValues("json-placeholder-service.base-url=https://localhost:3000")
                .run((context) -> {
                    assertThat(context).hasSingleBean(JsonPlaceholderServiceProperties.class);
                    assertThat(context.getBean(JsonPlaceholderServiceProperties.class).baseUrl()).isEqualTo("https://localhost:3000");
                });
    }

    @Test
    void shouldFindAllTodos() {
        contextRunner
                .run((context) -> {
                    JpsTodoClient todoClient = context.getBean(JpsTodoClient.class);
                    assertEquals(200, todoClient.findAll().size());
                });
    }

}