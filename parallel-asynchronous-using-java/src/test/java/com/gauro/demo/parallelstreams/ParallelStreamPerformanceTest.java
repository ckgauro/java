package com.gauro.demo.parallelstreams;

import com.gauro.demo.util.DataSet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
class ParallelStreamPerformanceTest {

    ParallelStreamPerformance parallelStreamPerformance=new ParallelStreamPerformance();
    int n=1000000;
    int result=1784293664;


    @Test
    void sum_using_intstream() {
        int sum=parallelStreamPerformance.sum_using_intstream(n,false);
        System.out.println("Sum :"+sum);
        assertEquals(result,sum);
    }
    @Test
    void sum_using_intstream_parallel() {
        int sum=parallelStreamPerformance.sum_using_intstream(n,true);
        System.out.println("Sum :"+sum);
        assertEquals(result,sum);
    }

    @Test
    void sum_using_iterate() {
        int sum=parallelStreamPerformance.sum_using_iterate(n,false);
        System.out.println("Sum :"+sum);
        assertEquals(result,sum);
    }
    @Test
    void sum_using_iterate_parallel() {
        int sum=parallelStreamPerformance.sum_using_iterate(n,true);
        System.out.println("Sum :"+sum);
        assertEquals(result,sum);
    }

    @Test
    void sum_using_list() {
        ArrayList<Integer> inputList = DataSet.generateArrayList(n);
        //when
        int sum = parallelStreamPerformance.sum_using_list(inputList, false);
        System.out.println("sum : "+ sum);

        //then
        assertEquals(1784293664, sum);
    }
    @Test
    void sum_using_list_parallel() {
        //given

        ArrayList<Integer> inputList = DataSet.generateArrayList(n);
        //when
        int sum = parallelStreamPerformance.sum_using_list(inputList, true);
        System.out.println("sum : "+ sum);

        //then
        assertEquals(result, sum);
    }




}