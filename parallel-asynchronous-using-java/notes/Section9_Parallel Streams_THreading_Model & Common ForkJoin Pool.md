- [x] #Section 9
- [x] #Chapter 30 Internals of Common ForkJoin Pool
-   Common ForkJoin Pool
    -ParallelStreams
    -CompletableFuture
        - Completable Future have options to use a User-defined ThreadPools
    -Common ForkJoin Pool is shared by the whole process

- [x] #Chapter 33
*** Parallel Streams - When not to use them?
  - Parallel Streams
    - Split
    - Execute
    - Combine
  - Data set is small
  - AutoBoxing and Unboxing doesn't perform better
  - Stream API operators -> **Iterate(),limit()  
