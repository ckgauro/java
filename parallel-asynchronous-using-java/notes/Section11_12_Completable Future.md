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
    
- [] #Chapter 35 Lets write our first Completable Future
{revise}
  -[Run] com.gauro.demo.completablefuture.CompletableFutureHelloWorld
    
- [] #Chapter 36 Transform Data using  "thenApply()"
  {revise}
  -[Run] com.gauro.demo.completablefuture.CompletableFutureHelloWorld
  
- [] #Chapter 37 Unit Testing CompletableFuture using JUnit5
  -[Run Test] com.gauro.demo.completablefuture.CompletableFutureHelloWorldTest.helloWorld
  
- [] #Chapter 38 Combing independent Async Tasks using string to the output
  {revise}
- [] #Chapter 39 Combing independent Async Task using "thenCombine"

- [] #Chapter 40 Invoking Async Task using "thenCompose"