package com.gauro.demo.parallelstreams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.gauro.demo.util.CommonUtil.startTimer;
import static com.gauro.demo.util.CommonUtil.timeTaken;

/**
 * @author Chandra
 */
public class ParallelStreamPerformance {
    public int sum_using_intstream(int count , boolean isParallel){
        startTimer();
        IntStream intStream=IntStream.rangeClosed(0,count);

        if(isParallel)
            intStream.parallel();

        int sum=intStream.sum();
        timeTaken();
        return sum;

    }

    public int sum_using_list(List<Integer> inputList, boolean isParallel){
        startTimer();
        Stream<Integer> inputstream=inputList.stream();
        if(isParallel)
            inputstream.parallel();
        int sum=inputstream.mapToInt(Integer::intValue)
                .sum();
        timeTaken();
        return  sum;
    }

    public int sum_using_iterate(int n, boolean isParallel){
        startTimer();
        Stream<Integer> integerStream=Stream.iterate(0,i->i+1);
        if(isParallel)
            integerStream.parallel();
        int sum=integerStream.limit(n+1)
                .reduce(0,Integer::sum);
        timeTaken();
        return sum;

    }
}
