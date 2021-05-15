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




}