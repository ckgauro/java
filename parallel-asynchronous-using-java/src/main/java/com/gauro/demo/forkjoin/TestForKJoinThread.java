package com.gauro.demo.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
@Slf4j
public class TestForKJoinThread {
    static int noCompute = 0;

    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        List<Integer> numbers = IntStream.rangeClosed(1, 500).boxed().collect(Collectors.toList());
        System.out.println(numbers);
        ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
        Long result = forkJoinPool.invoke(new Sum(numbers, 0, numbers.size()));
        System.out.println(result);

    }

    private static class Sum extends RecursiveTask<Long> {
        int low;
        int high;
        List<Integer> array;
        String threadName="Thread :"+ (++noCompute)+"===>";

        public Sum(List<Integer> numbers, int i, int size) {
            this.array = numbers;
            low = i;
            high = size;
        }

        @Override
        protected Long compute() {
            System.out.println(threadName+" =======compute starts *******==========");
            System.out.println(threadName+" array" + (array.toString()));
            System.out.println(threadName+"i= " + low + "  and high= " + high);
            if (high - low <= 10) {
                return sumData(array.subList(low, high));

            } else {
                System.out.println(threadName+"=======compute left called");
                int mid = low + (high - low) / 2;
                System.out.println(threadName+"mid=>" + mid);
                Sum left = new Sum(array, low, mid);
                Sum right = new Sum(array, mid, high);
                left.fork();
                long rightResult = right.compute();
                long leftResult = left.join();

                return leftResult + rightResult;
            }

        }

        long sumData(List<Integer> array) {
            System.out.println(threadName+" =======sumData starts ##########");
            Optional<Integer> sum = array.stream().reduce(Integer::sum);
            delay(1000);
            System.out.println(threadName+" =======sumData Ends -----------");
            return sum.orElse(0);
        }
    }
}
