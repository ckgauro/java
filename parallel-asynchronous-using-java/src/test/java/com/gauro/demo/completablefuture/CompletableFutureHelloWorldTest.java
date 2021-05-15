package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Chandra
 */
class CompletableFutureHelloWorldTest {
    HelloWorldService helloWorldService=new HelloWorldService();
    CompletableFutureHelloWorld completableFutureHelloWorld=new CompletableFutureHelloWorld(helloWorldService);
    @Test
    void helloWorld() {
        CompletableFuture<String> completableFuture=completableFutureHelloWorld.helloWorld();

        completableFuture.thenAccept(s->{
            assertEquals("HELLO WORLD",s);
        }).join();
    }
    @Test
    void helloWorld_1() {
        String hw=completableFutureHelloWorld.helloWorld_1();
        assertEquals("HELLO WORLD",hw);
    }
    @Test
    void helloWorld_multiple_async_calls() {
        String hw=completableFutureHelloWorld.helloWorld_multiple_async_calls();
        assertEquals("HELLO WORLD!", hw);
        
    }
    @Test
    void helloWorld_3_async_calls() {
        String hw=completableFutureHelloWorld.helloWorld_3_async_calls();
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);

    }

    @Test
    void helloWorld_3_async_calls_log() {
        String hw=completableFutureHelloWorld.helloWorld_3_async_calls_log();
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
    }
    @Test
    void helloWorld_3_async_calls_log_async() {
        String hw=completableFutureHelloWorld.helloWorld_3_async_calls_log_async();
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
    }

    @Test
    void helloWorld_3_async_calls_custom_threadPool() {
        String hw=completableFutureHelloWorld.helloWorld_3_async_calls_custom_threadPool();
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE", hw);
    }
    @Test
    void helloWorld_3_async_calls_custom_threadpool_async() {
        String hw=completableFutureHelloWorld.helloWorld_3_async_calls_custom_threadpool_async();
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
    }






}