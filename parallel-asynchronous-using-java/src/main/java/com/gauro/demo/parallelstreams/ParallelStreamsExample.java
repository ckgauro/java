package com.gauro.demo.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;

import static com.gauro.demo.util.CommonUtil.*;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class ParallelStreamsExample {
    public List<String> stringTransform(List<String> namesList) {
        return namesList.parallelStream()
                .map(this::transform)
                //.parallel()
                .sequential()
                .collect(Collectors.toList());
    }

    private  String transform(String name) {
        delay(500);
        log("Transforming: "+name);
        return name.length()+"-"+name;
    }

    public static void main(String[] args) {
        List<String> nameList=List.of("Bob", "Jamie", "Jill", "Rick");
        log("namesList: "+nameList);
        startTimer();
        ParallelStreamsExample parallelStreamsExample=new ParallelStreamsExample();
        List<String> resultList=parallelStreamsExample.stringTransform(nameList);
        timeTaken();
        log("resultList : " + resultList);

    }
}
