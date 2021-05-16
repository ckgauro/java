package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.concurrent.CompletableFuture;

import static com.gauro.demo.util.CommonUtil.startTimer;
import static com.gauro.demo.util.CommonUtil.timeTaken;
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
        assertEquals("HELLO WORLD! ", hw);
        
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
    @Test
    void helloWorld_4_async_calls() {
        String hw = completableFutureHelloWorld.helloWorld_4_async_calls();

        //then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE! BYE!", hw);
    }
    @Test
    void helloWorld_thenCompose() {
        startTimer();

        CompletableFuture<String> completableFuture = completableFutureHelloWorld.helloWorld_thenCompose();

        //then
        completableFuture
                .thenAccept(s -> {
                    //assertEquals("hello world", s);
                    assertEquals("HELLO WORLD", s);
                })
                .join();
        timeTaken();
    }
    @Test
    @Disabled
    void helloWorld_complete() {

        //given
        //when
        startTimer();

        CompletableFuture<String> completableFuture = completableFutureHelloWorld.complete("hello world!");

        //then
        completableFuture
                .thenAccept(s -> {
                    //assertEquals("hello world", s);
                    assertEquals("12 - HELLO WORLD!", s);
                })
                .join();
        timeTaken();


    }

    @Test
    void helloWorld_withSize() {

        //given
        //when
        CompletableFuture<String> completableFuture = completableFutureHelloWorld.helloWorld_withSize();

        //then
        completableFuture
                .thenAccept(s -> {
                    assertEquals("11 - HELLO WORLD", s);
                })
                .join();
    }

    @Test
    void allOf() {

        //given

        //when
        String result = completableFutureHelloWorld.allOf();

        //then
        assertEquals("Hello World", result);
    }

    @Test
    void anyOf() {

        //given

        //when
        String result = completableFutureHelloWorld.anyOf();

        //then
        assertEquals("Hello World", result);
    }






}