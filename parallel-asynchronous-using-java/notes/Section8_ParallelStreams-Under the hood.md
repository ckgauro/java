- [] #Section 8
- [x] #Chapter 22
* 
ParallelStreams-How it works?
``` 
A parallel Stream is a stream that splits its elements into multiple chunks, process each chunk with different thread. Thus you can automatically partition the workload of a given operation on all the cores of your multicore processor and keep all of them equally busy. Getting parallel stream is very easy, calling parallelStream() method on collection classes or parallel() method on sequential stream returns a parallel stream as demonstrated below.
 ```
***  parallelStream(): It divides into following three group 
  1. **Split** the data into chunks

    ```
     Spliterator is the new interface introduced in jdk8 that traverses and partitions elements of a source. The name itself suggests that, these are the iterators that can be splitted as and when require. As like Iterator, Spliterator is also used for traversing elements but meant to be used within stream only. Spliterator has defined some important methods that drives both sequential and parallel stream processing.
    
    ```

[Split](https://java-8-tips.readthedocs.io/en/stable/parallelization.html)
https://www.baeldung.com/java-spliterator
https://howtodoinjava.com/java/collections/java-spliterator/


  2 **Execute** the data chunks
  3 **Combine** the result


  
--------


- [] #Chapter 23
* Streams API
  {revise}
    
- https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/parallelstreams/ArrayListSpliteratorExample.java
  