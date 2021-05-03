package com.gauro.demo.forkjoin;

import com.gauro.demo.util.DataSet;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static com.gauro.demo.util.CommonUtil.delay;
import static com.gauro.demo.util.CommonUtil.stopWatch;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
@Slf4j
public class ForkJoinUsingRecursion extends RecursiveTask<List<String>> {
    private List<String> inputList;

    public ForkJoinUsingRecursion(List<String> inputList) {
        this.inputList = inputList;
    }


    /**
     * Recursively split the list and runs each half as a ForkJoinTask
     * Right way of using Fork/Join Task
     */
    @Override
    protected List<String> compute() {
        log.info("Compute starts ===>");
        if (this.inputList.size() <= 1) {
            log.info("compute ====>  "+this.inputList.size());
            List<String> resultList = new ArrayList<>();
            inputList.forEach(name -> resultList.add(transform(name)));
            return resultList;
        }
        int midPoint = inputList.size() / 2;
        ForkJoinTask<List<String>> leftInputList = new ForkJoinUsingRecursion(inputList.subList(0, midPoint))//left side of the list
                .fork(); // 1. asynchronously arranges this task in the deque,
        inputList = inputList.subList(midPoint, inputList.size()); //right side of the list
        List<String> rightResult = compute();
        List<String> leftResult = leftInputList.join();
        log("leftResult : " + leftResult);
        leftResult.addAll(rightResult);
        return leftResult;
    }

    private String transform(String name) {
        delay(500);
        return name.length() + " - " + name;

    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinUsingRecursion forkJoinUsingRecursion = new ForkJoinUsingRecursion(DataSet.namesList());
        stopWatch.start();
// Start things running and get the result back, This is blocked until the results are calculated.

        List<String> resultList = forkJoinPool.invoke(forkJoinUsingRecursion);
        log("resultList : " + resultList);

        stopWatch.stop();
        log("Total time taken : " + stopWatch.getTime());


    }
}
