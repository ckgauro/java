package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.gauro.demo.util.CommonUtil.*;
import static com.gauro.demo.util.LoggerUtil.log;
import static java.util.stream.Collectors.joining;

/**
 * @author Chandra
 */
public class CompletableFutureHelloWorld {
    private HelloWorldService helloWorldService;

    public CompletableFutureHelloWorld(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public CompletableFuture<String> helloWorld() {
        return CompletableFuture.supplyAsync(() -> helloWorldService.helloWorld())
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_withSize() {

        return CompletableFuture.supplyAsync(() -> helloWorldService.helloWorld()).thenApply(String::toUpperCase)
                .thenApply(s -> s.length() + " - " + s);
    }

    public String helloWorld_multiple_async_calls() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());

        String hw = hello.thenCombine(world, (h, w) -> h + w) //(first,second)
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return hw;
    }

    public String helloWorld_3_async_calls_log() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Hi Completatble";
        });

        String hw = hello.thenCombine(world, (h, w) -> {
            log("thenCombine h/w");
            return h + w;
        }).thenCombine(hiCompletableFuture, (previous, current) -> {
            log("the Combine, previous/current");
            return previous + current;
        }).thenApply(s -> {
            log("thenApply");
            return s.toUpperCase();
        }).join();
        timeTaken();
        return hw;
    }

    public String helloWorld_3_async_calls_log_async() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Hi Completatble";
        });
        String hw = hello.thenCombineAsync(world, (h, w) -> {
            log("then Combine h/w");
            return h + w;
        }).thenCombineAsync(hiCompletableFuture, (previous, current) -> {
            this.helloWorldService.hello();
            log("thenCombine , previous/Current");
            return previous + current;
        }).thenApplyAsync(s -> {
            this.helloWorldService.hello();
            log("thenApply");
            return s.toUpperCase();
        }).join();
        timeTaken();
        return hw;

    }

    public String helloWorld_3_async_calls_custom_threadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletable = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Hi CompleteableFuture";
        }, executorService);

        String hw = hello.thenCombine(world, (h, w) -> {
            log("Then Combine h/w");
            return h + w;
        }).thenCombine(hiCompletable, (previous, current) -> {
            log("then Combine , previous /current");
            return previous + current;
        }).thenApply(s -> {
            log("tehnApply");
            return s.toUpperCase();
        }).join();
        timeTaken();
        return hw;

    }

    public String helloWorld_3_async_calls_custom_threadpool_async() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletable = CompletableFuture.supplyAsync(() -> {
            // delay(1000);
            return "Hi CompleteableFuture";
        }, executorService);

        String hw = hello.thenCombineAsync(world, (h, w) -> {
            log("Then Combine h/w");
            return h + w;
        }).thenCombineAsync(hiCompletable, (previous, current) -> {
            log("then Combine , previous /current");
            return previous + current;
        }).thenApply(s -> {
            log("tehnApply");
            return s.toUpperCase();
        }).join();
        timeTaken();
        return hw;

    }

    public String helloWorld_4_async_calls() {
        startTimer();
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> this.helloWorldService.world());
        CompletableFuture<String> hiCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return " HI CompletableFuture!";
        });
        CompletableFuture<String> byeCompletableFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Hi CompletableFuture";
        });
        String hw = hello
                .thenCombine(world, (h, w) -> h + w)
                .thenCombine(hiCompletableFuture, (previous, current) -> previous + current)
                .thenCombine(byeCompletableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return hw;

    }

    public CompletableFuture<String> helloWorld_thenCompose() {
        CompletableFuture<String> helloWorldFuture = CompletableFuture.supplyAsync(() -> this.helloWorldService.hello())
                .thenCompose(previous -> helloWorldService.worldFuture(previous))
                //.thenApply(previous -> helloWorldService.worldFuture(previous))
                .thenApply(String::toUpperCase);

        return helloWorldFuture;
    }


    public String allOf() {
        startTimer();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Hello";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "World";
        });

        List<CompletableFuture<String>> cfList = List.of(cf1, cf2);
        CompletableFuture<Void> cfAllOf = CompletableFuture.allOf((cfList.toArray(new CompletableFuture[cfList.size()])));
        String result = cfAllOf.thenApply(v -> cfList.stream()
                .map(CompletableFuture::join)
                .collect(joining())).join();
        timeTaken();
        return result;
    }

    public String anyOf() {
        startTimer();
        CompletableFuture<String> db = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            log("response from db");
            return "Hello World";
        });
        CompletableFuture<String> restApi = CompletableFuture.supplyAsync(() -> {
            delay(2000);
            log("Response from restAPI");
            return "Hello World";

        });

        CompletableFuture<String> soapApi = CompletableFuture.supplyAsync(() -> {
            delay(3000);
            log("response from soapAPI");
            return "Hello World";
        });
        List<CompletableFuture<String>> cfList = List.of(db, restApi, soapApi);
        CompletableFuture<Object> cfAllOf = CompletableFuture.anyOf(cfList.toArray(new CompletableFuture[cfList.size()]));
        String result = (String) cfAllOf.thenApply(v -> {
            if (v instanceof String) {
                return v;
            }
            return null;
        }).join();
        timeTaken();
        return result;

    }

    public String helloWorld_1() {

        return CompletableFuture.supplyAsync(() -> helloWorldService.helloWorld())//  runs this in a common fork-join pool
                .thenApply(String::toUpperCase)
                .join();

    }

    public CompletableFuture<String> complete(String input) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture = completableFuture
                .thenApply(String::toUpperCase)
                .thenApply(result -> result.length() + " - " + result);
        completableFuture.complete(input);
        return completableFuture;

    }


    public static void main(String[] args) {
        HelloWorldService helloWorldService = new HelloWorldService();
        CompletableFuture.supplyAsync(() -> helloWorldService.helloWorld())
                .thenApply(String::toUpperCase)
                .thenApply(result -> {
                    log("upper case result:" + result);
                    delay(5000);
                    return result.toLowerCase();
                })
                .thenAccept(result -> {
                    log("Lower case result:" + result);
                }).join();
        log("Done");
        delay(2000);

    }
}
