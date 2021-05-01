#Section 5  --Ongoing
[x] #Chapter 8  

## Section Overview
* Covers Asynchronous and Prallel Programming prior Java 8
* Threads, Future and ForkJoin Framework and its limitations
* Covers Theory and Hands On

--------
[x]  #Chapter 9  --Done

[UML Diagram](uml/ProductService.uml)
* Run com.gauro.demo.service.ProductService 
> Find Time taken
``` 
> Task :ProductService.main()
09:36:27.709 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Total Time Taken:2010
09:36:27.769 [main] INFO com.gauro.demo.util.LoggerUtil - [main] - Product is Product(productId=ABC123, productInfo=ProductInfo(productId=ABC123, productOptions=[ProductOption(productionOptionId=1, size=64GB, color=Black, price=699.99, inventory=null), ProductOption(productionOptionId=2, size=128GB, color=Black, price=749.99, inventory=null)]), review=Review(noOfReviews=200, overallRating=4.5))

```
--------
#Chapter 10  --Ongoing

* Threads API
1.  Threads API got introduced in JAVA1
2.  Threads are basically used to offload the blocking tasks as background tasks
3.  Threads allowed the developers to write asynchronous style of code

https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/blob/final/src/main/java/com/learnjava/thread/ProductServiceUsingThread.java

* Run com.gauro.demo.service.ProductServiceUsingThread

-------------

#Chapter 11  

* Limitations Of Thread
1.  Create the thread
2.  Start the thread
3.  Join the thread

* Threads are expensive
1.  Threads have their own runtime-stack , memory, registers and more

**THread Pool was created specifically to solve this problem**


