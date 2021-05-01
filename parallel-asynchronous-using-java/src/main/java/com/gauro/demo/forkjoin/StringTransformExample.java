package com.gauro.demo.forkjoin;

import com.gauro.demo.util.DataSet;

import java.util.ArrayList;
import java.util.List;

import static com.gauro.demo.util.CommonUtil.delay;
import static com.gauro.demo.util.CommonUtil.stopWatch;
import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class StringTransformExample {
    public static void main(String[] args) {
        stopWatch.start();
        List<String> resultList=new ArrayList<>();
        List<String> names= DataSet.namesList();
        log("names :"+names);
        names.forEach((name)->{
            String newValue=addNameLengthTransform(name);
            resultList.add(newValue);
        });
        stopWatch.stop();
        log("Final Result : "+ resultList);
        log("Total Time Taken : "+ stopWatch.getTime());

    }
    private static String addNameLengthTransform(String name){
        delay(500);
        return name.length()+" - "+name;
    }
}
