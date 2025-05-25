package com.rafi.service1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Service1ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloEndpoint() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/service1/hello", String.class);
        assertThat(response).isEqualTo("Hello from Service1");
    }

    @Test
    void testHelloEndpoint_StatusCode() {
        var entity = restTemplate.getForEntity("http://localhost:" + port + "/service1/hello", String.class);
        assertThat(entity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void testHelloEndpoint_NotFound() {
        var entity = restTemplate.getForEntity("http://localhost:" + port + "/service1/invalid", String.class);
        assertThat(entity.getStatusCodeValue()).isEqualTo(404);
    }
}
