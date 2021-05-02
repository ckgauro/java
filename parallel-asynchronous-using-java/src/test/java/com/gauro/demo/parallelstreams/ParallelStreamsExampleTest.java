package com.gauro.demo.parallelstreams;

import com.gauro.demo.util.DataSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gauro.demo.util.CommonUtil.startTimer;
import static com.gauro.demo.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
class ParallelStreamsExampleTest {
    ParallelStreamsExample parallelStreamsExample=new ParallelStreamsExample();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stringTransform() {
        startTimer();
        List<String> stringList=parallelStreamsExample.stringTransform(DataSet.namesList());
        timeTaken();
        assertEquals(4, stringList.size());
        stringList.forEach(name-> assertTrue( name.contains("-")));
    }
}