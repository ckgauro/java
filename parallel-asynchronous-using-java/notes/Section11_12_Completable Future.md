- [] #Section 11 and 12
- [x] #Chapter 34 Introduction to Completable Future
  - ***CompletableFuture***
    - Introduced in Java8
    - CompletableFuture is an **Asynchronous Reactive Function Programming API**
    - Asynchronous Computations is a functional style
    - CompletableFutures API is created to solve the limitations of Future API
   
  - CompletableFuture and Reactive Programming
    - **Responsive:**
      - Fundamentally Asynchronous
      - Call returns immediately and the response will be sent when its available 
    - **Resilient:**
      - Exception or error won't crash the app or code
    - **Elastic:**
        - Asynchronous Computations normally run in a pool of threads
        - No of threads can go up or down based on the need
    - **Message Driven:**
        - Asynchronous computations interact with each through messages in a event-driven style
      
  - CompleatableFuture  API categories into three parts
    - **Factory Methods:**
    - Initiate asynchronous computation
    - **Completion Stage Methods:**
        - Chain asynchronous computation
    - **Exception Methods:**
        - Handle Exceptions in an Asynchronous Computation
    
- [x] #Chapter 35 Lets write our first Completable Future
***Completable Future 
  
|supplyAsync|thenAccept()|
|-----------|------------|
|FactoryMethod|CompletionStage Method|
|Initiate Asynchronous computation|Chain Asynchronous Computation|
|Input is **Supplier** functional Interface|Input is **Consumer** Functional Interface. Consumes the result of the previous|
|Returns CompletableFuture<T>()|Returns CompletableFuture<Void>|


  -[Run] com.gauro.demo.completablefuture.CompletableFutureHelloWorld 
```Java
> Task :CompletableFutureHelloWorld.main()
21:36:23.828 [ForkJoinPool.commonPool-worker-19] INFO com.gauro.demo.util.LoggerUtil - [ForkJoinPool.commonPool-worker-19] - inside helloWorld
21:36:23.836 [ForkJoinPool.commonPool-worker-19] INFO com.gauro.demo.util.LoggerUtil - [ForkJoinPool.commonPool-worker-19] - upper case result:HELLO WORLD
21:36:28.838 [ForkJoinPool.commonPool-worker-19] INFO com.gauro.demo.util.LoggerUtil - [ForkJoinPool.commonPool-worker-19] - Lower case result:hello world
21:36:28.839 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Done

```
   -**thenAccept** takes a Consumer and returns a T=Void CF, i.e. one that does not carry a value, only the completion state.

   -**thenApply** on the other hand takes a Function and returns a CF carrying the return value of the function
```java
CompletableFuture<Void>     thenAccept(Consumer<? super T> action)
<U> CompletableFuture<U>    thenApply(Function<? super T,? extends U> fn)
```

- [x] #Chapter 36 Transform Data using  "thenApply()"

**thenApply()**
- Completion Stage method
- Transform the data from one from to another
- Input is **Function** Functional Interface
- Returns CompletableFuture<T>

  -[Run] com.gauro.demo.completablefuture.CompletableFutureHelloWorld
  
- [x] #Chapter 37 Unit Testing CompletableFuture using JUnit5
  -[Run Test] com.gauro.demo.completablefuture.CompletableFutureHelloWorldTest.helloWorld
  
- [] #Chapter 38 Combing independent Async Tasks using string to the output
  {revise}
- [] #Chapter 39 Combing independent Async Task using "thenCombine"

- [] #Chapter 40 Invoking Async Task using "thenCompose"