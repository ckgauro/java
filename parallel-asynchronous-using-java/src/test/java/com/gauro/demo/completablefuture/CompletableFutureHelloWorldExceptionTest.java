package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Chandra
 */
class CompletableFutureHelloWorldExceptionTest {
    @Mock
    HelloWorldService helloWorldService=mock(HelloWorldService.class);

    @InjectMocks
    CompletableFutureHelloWorldException completableFutureHelloWorldException;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void helloWorld_3_async_calls_handle() {
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenCallRealMethod();



    }

}