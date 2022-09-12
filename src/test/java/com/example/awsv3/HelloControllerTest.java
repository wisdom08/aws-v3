package com.example.awsv3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void home_테스트() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        assertEquals("<h1>home page</h1>", response.getBody());
    }

    @Test
    void hello_테스트() {
        ResponseEntity<String> response = restTemplate.getForEntity("/aws/v3", String.class);
        assertEquals("<h1>aws v3</h1>", response.getBody());
    }
}
