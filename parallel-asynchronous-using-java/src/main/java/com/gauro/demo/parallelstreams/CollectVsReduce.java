package com.gauro.demo.parallelstreams;

import com.gauro.demo.util.DataSet;

import java.util.List;

import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class CollectVsReduce {
    public static String collect() {
        List<String> list = DataSet.namesList();

        String result = list.parallelStream()
                .reduce("", (s1, s2) -> s1 + s2);
        return result;
    }

    public static String reduce(){
        List<String> list=DataSet.namesList();
        String result=list.parallelStream().reduce("",(s1,s2)->s1+s2);
        return result;
    }

    public static void main(String[] args) {
        log("collect :"+collect());
        log("reduce :"+reduce());
    }
}
