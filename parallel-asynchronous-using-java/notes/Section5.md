- [x] #Section 5  
- [x] #Chapter 8  

## Section Overview
* Covers Asynchronous and Prallel Programming prior Java 8
* Threads, Future and ForkJoin Framework and its limitations
* Covers Theory and Hands On

--------
- [x]  #Chapter 9  

[UML Diagram](uml/ProductService.uml)
* Run com.gauro.demo.service.ProductService 
> Find Time taken
``` 
> Task :ProductService.main()
09:36:27.709 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time Taken:2010
09:36:27.769 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Product is Product(productId=ABC123, productInfo=ProductInfo(productId=ABC123, productOptions=[ProductOption(productionOptionId=1, size=64GB, color=Black, price=699.99, inventory=null), ProductOption(productionOptionId=2, size=128GB, color=Black, price=749.99, inventory=null)]), review=Review(noOfReviews=200, overallRating=4.5))

```
--------
- [x]   #Chapter 10  

* Threads API
1.  Threads API got introduced in JAVA1
2.  Threads are basically used to offload the blocking tasks as background tasks
3.  Threads allowed the developers to write asynchronous style of code

https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/thread/ProductServiceUsingThread.java

* Run com.gauro.demo.service.ProductServiceUsingThread
``` 
> Task :ProductServiceUsingThread.main()
11:04:05.311 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time Taken:1006
11:04:05.359 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Product is Product(productId=ABC123, productInfo=ProductInfo(productId=ABC123, productOptions=[ProductOption(productionOptionId=1, size=64GB, color=Black, price=699.99, inventory=null), ProductOption(productionOptionId=2, size=128GB, color=Black, price=749.99, inventory=null)]), review=Review(noOfReviews=200, overallRating=4.5))

```
-------------

- [x]   #Chapter 11  
* Limitations Of Thread
1.  Create the thread
2.  Start the thread
3.  Join the thread

* Threads are expensive
1.  Threads have their own runtime-stack , memory, registers and more

**Thread Pool was created specifically to solve this problem**

* Thread Pool

1.  THread Pool is a group of threads created and readily available.
2.  CPU Intensive Tasks
> ThreadPool Size=No of Cores
3.  I/O task
> ThreadPool Size > No of Cores
4.  What are the benefits of thread pool?
> No need to manually create, start and join the threads
> Achieving Concurrency in your application.

* ExecutorService
1.  Released as part of Java5
2.  ExecutorService in Java is an Asynchronous Task Execution Engine
3.  It provides a way to asynchronously execute tasks and provides the results in a much simpler way compared to threads.
4.  This enabled coarse-grained task based parallelism in Java



-------------

- [x]   #Chapter 12
  https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/executor/ProductServiceUsingExecutor.java
    * Run com.gauro.demo.executor.ProductServiceUsingExecutor
* ExecutorService

``` 
> Task :ProductServiceUsingExecutor.main()
13:51:38.730 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time Taken: 1013
13:51:38.813 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Product isProduct(productId=ABC123, productInfo=ProductInfo(productId=ABC123, productOptions=[ProductOption(productionOptionId=1, size=64GB, color=Black, price=699.99, inventory=null), ProductOption(productionOptionId=2, size=128GB, color=Black, price=749.99, inventory=null)]), review=Review(noOfReviews=200, overallRating=4.5))

```


-------------

- [x]   #Chapter 13
* Fork/Join Framework
1.  This got introduced as part of Java7
2.  This is an extension of ExecutorService
3.  Fork/Join framework is designed to achieve **Data Parallelism**
4.  ExecutorService is designed to achieve **Task Based Parallelism**
``` 
 Future<ProductInfo> productInfoFuture=executorService.submit(()->productInfoService.retrieveProductInfo(productId));
 Future<Review> reviewFuture=executorService.submit(()->reviewService.retrieveReviews(productId));
        
```

* What is Data Parallelism?
1. Data Parallelism is a concept where a given **Task** is recursively split into **SubTasks** until it reaches it leaset possible size and
execute those tasks in parallel.

2.  Basically it uses the **divide and conquer** approach   

* WorkStealing
  Work stealing was introduced in Java with the aim of reducing contention in multi-threaded applications. This is done using the fork/join framework.
* ForkJoin Task
1.  ForkJoin Task represents part of the data and  its computation
2.  Types of tasks to sumbit to ForkJoin Pool 
> ForkJoinTask
- RecursiveTask -> Task that return a value
- RecursiveAction -> Task that does not return a value;


-------------

- [x]   #Chapter 14

* Run com.gauro.demo.forkjoin.StringTransformExample


``` 
> Task :StringTransformExample.main()
17:01:54.158 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - names :[Bob, Jamie, Jill, Rick]
17:01:56.180 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Final Result : [3 - Bob, 5 - Jamie, 4 - Jill, 4 - Rick]
17:01:56.187 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time Taken : 2155
```

https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/forkjoin/ForkJoinUsingRecursion.java

* Run com.gauro.demo.forkjoin.ForkJoinUsingRecursion

*   The fork-join framework allows to break a certain task on several workers and then wait for the result to combine them. It leverages multi-processor machine's capacity to great extent. Following are the core concepts and objects used in fork-join framework.
- Fork
```
Fork is a process in which a task splits itself into smaller and independent sub-tasks which can be executed concurrently.

Syntax
Sum left  = new Sum(array, low, mid);
left.fork();
Here Sum is a subclass of RecursiveTask and left.fork() spilts the task into sub-tasks.
``` 
- Join
``` 
Join is a process in which a task join all the results of sub-tasks once the subtasks have finished executing, otherwise it keeps waiting.

Syntax
left.join();
Here left is an object of Sum class.

```

- ForkJoinPool
``` 
it is a special thread pool designed to work with fork-and-join task splitting.

Syntax
ForkJoinPool forkJoinPool = new ForkJoinPool(4);
Here a new ForkJoinPool with a parallelism level of 4 CPUs.

```
- RecursiveAction
``` 
RecursiveAction represents a task which does not return any value.

Syntax
class Writer extends RecursiveAction {
@Override
protected void compute() { }
}
``` 
- RecursiveTask
``` 

RecursiveTask represents a task which returns a value.

Syntax
class Sum extends RecursiveTask<Long> {
@Override
protected Long compute() { return null; }
}
```
