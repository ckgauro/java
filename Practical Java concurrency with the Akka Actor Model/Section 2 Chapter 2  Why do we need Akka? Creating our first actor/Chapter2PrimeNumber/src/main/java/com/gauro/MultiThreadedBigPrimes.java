package com.gauro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MultiThreadedBigPrimes {
    public static void main(String[] args) throws InterruptedException {
        Long start=System.currentTimeMillis();
        Results results=new Results();
        Runnable status=new CurrentStatus(results);
        Thread statusTask=new Thread(status);
        statusTask.start();

        Runnable task=new PrimeGenerator(results);
        List<Thread> threads=new ArrayList<>();
        IntStream.range(1,101).forEach(i->{
            Thread t=new Thread(task);
            threads.add(t);
            t.start();
        });
        for(Thread t: threads){
            t.join();
        }

        results.print();
        Long end=System.currentTimeMillis();
        System.out.println("Time Taken :"+ (end-start)+" ms.");






    }
}
