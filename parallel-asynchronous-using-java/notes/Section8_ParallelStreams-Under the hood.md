- [] #Section 8
- [x] #Chapter 22
* ParallelStreams-How it works?

A parallel Stream is a stream that splits its elements into multiple chunks, process each chunk with different thread. Thus you can automatically partition the workload of a given operation on all the cores of your multicore processor and keep all of them equally busy. Getting parallel stream is very easy, calling parallelStream() method on collection classes or parallel() method on sequential stream returns a parallel stream as demonstrated below.

***  parallelStream(): It divides into following three group 
  1. **Split** the data into chunks

   Spliterator is the new interface introduced in jdk8 that traverses and partitions elements of a source. The name itself suggests that, these are the iterators that can be splitted as and when require. As like Iterator, Spliterator is also used for traversing elements but meant to be used within stream only. Spliterator has defined some important methods that drives both sequential and parallel stream processing.
    
  - Data Source is split into small data chunks
     - Example - **List Collection** split into chunks of elements to **size 1**
  - This is done using **Spliterators**
     - For ArrayList, the **Spliterator**  is **ArrayListSpliterator** 
  - Additional resources
    - [java-8-tips](https://java-8-tips.readthedocs.io/en/stable/parallelization.html), [baeldung](https://www.baeldung.com/java-spliterator), [howtodoinjava](https://howtodoinjava.com/java/collections/java-spliterator/)


  2 **Execute** the data chunks

  - Data chunks are applied to the Stream Pipeline and the **Intermediate**  operations executed in a **Common ForkJoin Pool**


  3 **Combine** the result
  
  - Combine the executed results into a final result
  - Combine phase is Streams API maps to **terminal** operations
  - Uses collect() and reduce() functions
    
    - **collect(toList())**


  
--------


- [x] #Chapter 23

- https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/parallelstreams/ArrayListSpliteratorExample.java
- https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/test/java/com/learnjava/parallelstreams/ArrayListSpliteratorExampleTest.java
- [Run Test] com.gauro.demo.parallelstreams.multiplyEachValue
``` 
11:41:46.417 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - Total Time taken: 57
11:41:46.419 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - completed
11:41:46.452 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - Total Time taken: 22
11:41:46.453 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - completed
11:41:46.536 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - Total Time taken: 80
11:41:46.536 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - completed
11:41:46.563 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - Total Time taken: 25
11:41:46.563 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - completed
11:41:46.594 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - Total Time taken: 28
11:41:46.594 [Test worker] INFO com.gauro.demo.util.LoggerUtil - [Test worker] - completed 
```

--------

- [x] #Chapter 24
    
    - Invoking **parallelStream()** does not guarantee faster performance of your code
    - Need to perform additional steps compared to sequential
    - Splitting, Executing and Combining

- [Run Test] com.gauro.demo.parallelstreams.multiplyEachValue.LinkedListSpliteratorExampleTest

``` 

```

--------

- [x] #Chapter 25
    *** Parallel Streams - Final Computation Result Order
  - The Order of the collection depends on:
    - Type of Colelction
    - Spliterator Implementation of the collection
  - Example : ArrayList
    - Type of Collection - **Ordered**
    - Spliterator Implementation -Ordered Spliterator Implementation
  - Example: Set
    - Type of Collection - ** UnOrdered**
    - Spliterator Implementation -UnOrdered Spliterator Implementation

- [Run] com.gauro.demo.parallelstreams.ParallelStreamResultOrder
``` 
> Task :ParallelStreamResultOrder.main()
13:03:58.583 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - inputList : [1, 2, 3, 4, 5, 6, 7, 8, 9]
13:03:58.595 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - result :[2, 4, 6, 8, 10, 12, 14, 16, 18]
13:03:58.596 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - inputList  Set: [9, 8, 7, 6, 5, 4, 3, 2, 1]
13:03:58.598 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - result Set : [16, 2, 18, 4, 6, 8, 10, 12, 14]
13:03:58.598 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - inputList : [1, 2, 3, 4, 5, 6, 7, 8, 9]
13:03:58.598 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - inputList : [9, 8, 7, 6, 5, 4, 3, 2, 1]
13:03:58.599 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - result : [18, 16, 14, 12, 10, 8, 6, 4, 2]
```

--------

- [] #Chapter 26
{revise}
  [Reduce vs Collect part 1](https://www.youtube.com/watch?v=oWlWEKNM5Aw) , [Reduce vs Collect part 2](https://www.youtube.com/watch?v=H7VbRz9aj7c)
--------

- [x] #Chapter 27
  
    - [Run] com.gauro.demo.service.CheckoutService

- [] #Chapter 28
  {revise}
  Identity in reduce()
  Identity gives you the same   

    - [Run Test] com.gauro.demo.parallelstreams.ReduceExampleTest
    
- [] #Chapter 29
  {revise}

   - [Run Test] com.gauro.demo.parallelstreams.ParallelStreamPerformanceTest

