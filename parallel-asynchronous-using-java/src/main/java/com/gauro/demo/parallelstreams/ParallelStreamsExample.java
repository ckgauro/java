package com.gauro.demo.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
               // .sequential()
                .collect(Collectors.toList());
    }

    private  String transform(String name) {
        delay(500);
       // log("Transforming: "+name);
        return name.length()+"-"+name;
    }
    public List<String> stringTransform_1(List<String> namesList, boolean isParallel){
        Stream<String> nameStream=namesList.stream();
        if(isParallel)
            nameStream.parallel();
        return nameStream.map(this::transform)
                .collect(Collectors.toList());
    }
    public List<String> string_toLowerCase(List<String> nameList){
        return nameList.parallelStream().map(String::toLowerCase).collect(Collectors.toList());
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
