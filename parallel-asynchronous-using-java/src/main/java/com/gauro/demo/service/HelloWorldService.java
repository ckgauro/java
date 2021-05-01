package com.gauro.demo.service;

import java.util.concurrent.CompletableFuture;

import static com.gauro.demo.util.CommonUtil.delay;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class HelloWorldService {
    public String helloWorld(){
        delay(100);
        log("inside helloWorld");
        return "hello world";
    }

    public String hello(){
        delay(1000);
        log("inside hello");
        return "hello";
    }

    public CompletableFuture<String> worldFuture(String input){
        return CompletableFuture.supplyAsync(()->{
           delay(1000);
           return input+" world";
        });
    }
}