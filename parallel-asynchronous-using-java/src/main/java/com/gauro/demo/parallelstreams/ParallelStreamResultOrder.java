package com.gauro.demo.parallelstreams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.gauro.demo.util.LoggerUtil.log;

/**
 * @author Chandra
 */
public class ParallelStreamResultOrder {
    public static List<Integer> listOrder(List<Integer> inputList){
        return inputList.parallelStream()
                .map(i->i*2)
                .collect(Collectors.toList());

    }
    public static Set<Integer> listOrder_Set(List<Integer> inputList){
        return  inputList.parallelStream()
                .map(i->i*2)
                .collect(Collectors.toSet());
    }
    public static Set<Integer> setOrder(Set<Integer> inputList){
        return  inputList.parallelStream()
                .map(i->i*2)
                .collect(Collectors.toSet());
    }
    public static List<Integer> setOrder_List(Set<Integer> inputList){
        return inputList.parallelStream()
                .map(i->i*2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(1,2,3,4,5,6,7,8,9);
        log("inputList : "+input);
        List<Integer> result=listOrder(input);
        log("result :"+result);

        Set<Integer> inputSet = Set.of(1,2,3,4,5,6,7,8,9);
        log("inputList : "+inputSet);
        Set<Integer> resultSEt = setOrder(inputSet);
        log("result : "+resultSEt);

        List<Integer> inputList1 = List.of(1,2,3,4,5,6,7,8,9);
        log("inputList : "+inputList1);
       // List<Integer> result1 = listOrder_Set(inputList1);
       // log("result : "+listOrder_Set(result1));*/

        Set<Integer> input2 = Set.of(1,2,3,4,5,6,7,8,9);
        log("inputList : "+input2);
        log("result : "+setOrder_List(input2));

    }
}
