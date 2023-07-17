package com.example.echo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EchoApplication.class)
class EchoApplicationTest {

    @Test
    void mainTest() {
        Assertions.assertDoesNotThrow(() -> EchoApplication.main(new String[]{}));
    }
}