package com.rafi.service3.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Service3ControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void testHelloEndpoint() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/service3/hello", String.class);
        assertThat(response).isEqualTo("Hello from Service3");
    }
}
