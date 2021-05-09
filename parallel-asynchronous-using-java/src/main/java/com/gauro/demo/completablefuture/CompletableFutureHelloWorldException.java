package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

import static com.gauro.demo.util.CommonUtil.*;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class CompletableFutureHelloWorldException {
    private HelloWorldService helloWorldService;

    public CompletableFutureHelloWorldException(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
    public String helloWorld_3_async_calls_handle() {
        startTimer();
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return " HI CompletableFuture!";
        });

        String hw=hello
                .handle((result,e)->{
                    log("result is:"+result);
                    if(e!=null){
                        log("Exception Handle after world:"+e.getMessage());
                        return "";
                    }
                    return result;
                })
                .thenCombine(world, (h, w) -> h + w) // (first,second)
                .handle((result, e) -> { // this gets invoked for both success and failure
                    log("result is : " + result);
                    if (e != null) {
                        log("Exception Handle after world : " + e.getMessage());
                        return "";
                    }
                    return result;
                })
                .thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)

                .join();

        timeTaken();

        return hw;
    }
    public String helloWorld_3_async_calls_exceptionally() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return " HI CompletableFuture!";
        });

        String hw = hello
                .exceptionally((e) -> { // this gets invoked for both success and failure
                    log("Exception is : " + e.getMessage());
                    return "";
                })
                .thenCombine(world, (h, w) -> h + w) // (first,second)
                .exceptionally((e) -> { // this gets invoked for both success and failure
                    log("Exception Handle after world : " + e.getMessage());
                    return "";
                })
                .thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)

                .join();

        timeTaken();

        return hw;
    }
    public String helloWorld_3_async_whenComplete() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return " HI CompletableFuture!";
        });

        String hw = hello
                .whenComplete((result, e) -> { // this gets invoked for both success and failure
                    log("result is : " + result);
                    if (e != null) {
                        log("Exception is : " + e.getMessage());
                    }
                })
                .thenCombine(world, (h, w) -> h + w) // (first,second)
                .whenComplete((result, e) -> { // this gets invoked for both success and failure
                    log("result is : " + result);
                    if (e != null) {
                        log("Exception Handle after world : " + e.getMessage());
                    }
                })
                .exceptionally((e) -> { // this gets invoked for both success and failure
                    log("Exception Handle after world : " + e.getMessage());
                    return "";
                })
                .thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)

                .join();

        timeTaken();
        return hw;
    }

}
