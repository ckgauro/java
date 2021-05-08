package com.gauro.demo.parallelstreams;

import com.gauro.demo.util.DataSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
class ArrayListSpliteratorExampleTest {
    ArrayListSpliteratorExample arrayListSpliteratorExample=new ArrayListSpliteratorExample();

    @BeforeEach
    void setUp() {
    }

    @RepeatedTest(5)
    void multiplyEachValue() {
        int size=1000000;
        ArrayList<Integer> inputList= DataSet.generateArrayList(size);
        //when
        List<Integer> result=arrayListSpliteratorExample.multiplyEachValue(inputList,2,false);

        //then
        assertEquals(size,result.size());
    }

    @RepeatedTest(10)
    void multiplyEachValue_parallel() {
        int size = 1000000;
        ArrayList<Integer> inputList = DataSet.generateArrayList(size);

        //When
        List<Integer> result=arrayListSpliteratorExample.multiplyEachValue(inputList,2,true);
        //then
        assertEquals(size,result.size());
    }
    @RepeatedTest(5)
    void multiplyEachValue_IntStream() {
        int n=1000000;
        List<Integer> result=arrayListSpliteratorExample.multiplyEachValue(n,2,false);
        assertEquals(n,result.size());
    }

    @RepeatedTest(5)
    void multiplyEachValue_IntStream_parallel() {
        int n = 1000000;
        //when

        List<Integer> result = arrayListSpliteratorExample.multiplyEachValue(1000000, 2, true);

        //then
        assertEquals(n, result.size());
    }


}