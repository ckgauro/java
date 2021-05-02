- [] #Section 6
- [x] #Chapter 15
* Streams API
1. Streams API got introduced in Java8
2. Streams API is used to process a collection of Objects
3. Streams in Java are created by using the stream() method.

* ParallelStreams
1. This allows your code to run in parallel
2. ParallelStreams are designed to solve **Data Parallelism**

------------
- [x] #Chapter 16
* https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/parallelstreams/ParallelStreamsExample.java
* Run com.gauro.demo.parallelstreams.ParallelStreamsExample 
``` 
 public List<String> stringTransform(List<String> namesList) {
        return namesList.stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }
    -----
    Result
    12:00:45.518 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time taken: 2028
    
    
```
- Now Modify stringTransform
``` 
    public List<String> stringTransform(List<String> namesList) {
        return namesList.stream()
                .map(this::transform)
                .parallel()
                .collect(Collectors.toList());
    }
    -------
   Result
    12:02:29.638 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time taken: 526
```
- Now Modify stringTransform
``` 
   public class ParallelStreamsExample {
    public List<String> stringTransform(List<String> namesList) {
        return namesList.parallelStream()
                .map(this::transform)
                //.parallel()
                .collect(Collectors.toList());
    }
    -------
   Result
12:04:54.865 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time taken: 525
```
- Now Modify stringTransform adding sequential
``` 
  public List<String> stringTransform(List<String> namesList) {
        return namesList.parallelStream()
                .map(this::transform)
                //.parallel()
                .sequential()
                .collect(Collectors.toList());
    }
    -------
   Result
12:06:00.875 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time taken: 2027
```


------------
- [x] #Chapter 17
Why Unit Tests
1. Unit Testing allows you to programmaticallt test your code
2. Manual Testing slows down the development and delivery.
3. Unit Testing allows the developer or the app team to make enhacemnets to the existing code easily and faster
  
[press command +enter to Generate popMenu of corresponding method]
* https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/test/java/com/learnjava/parallelstreams/ParallelismExampleTest.java
* [Run Test] com.gauro.demo.parallelstreams.ParallelismExampleTest  

------------
- [] #Chapter 18

