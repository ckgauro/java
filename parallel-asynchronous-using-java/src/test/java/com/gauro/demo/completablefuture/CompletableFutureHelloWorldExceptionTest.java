package com.gauro.demo.completablefuture;

import com.gauro.demo.service.HelloWorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Chandra
 */
@ExtendWith(MockitoExtension.class)
class CompletableFutureHelloWorldExceptionTest {
    @Mock
    HelloWorldService helloWorldService=mock(HelloWorldService.class);

    @InjectMocks
    CompletableFutureHelloWorldException hwcfe;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void helloWorld_3_async_calls_handle() {
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result=hwcfe.helloWorld_3_async_calls_handle();
//
//        //then
        String expectedResult= " WORLD!  HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult,result);



    }
    @Test
    void helloWorld_3_async_calls_handle_2() {

        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result = hwcfe.helloWorld_3_async_calls_handle();

        //then
        String expectedResult = " HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult, result);
    }

    @Test
    void helloWorld_3_async_calls_handle_3() {

        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = hwcfe.helloWorld_3_async_calls_handle();

        //then
        String expectedResult = "HELLO WORLD! HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult, result);
    }
    @Test
    void helloWorld_3_async_calls_exceptionally() {
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result=hwcfe.helloWorld_3_async_calls_exceptionally();

        //then
        String expectedResult=" HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult,result);
    }
    @Test
    void helloWorld_3_async_whenComplete() {

        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result=hwcfe.helloWorld_3_async_whenComplete();

        //then
        String expectedResult="HELLO WORLD!  HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult, result);
    }

    @Test
    void helloWorld_3_async_whenComplete_2() {

        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result=hwcfe.helloWorld_3_async_whenComplete();

        //then
        String expectedResult= " HI COMPLETABLEFUTURE!";
        assertEquals(expectedResult, result);

    }



}