package com.gauro.demo.util;

import org.apache.commons.lang3.time.StopWatch;
import static com.gauro.demo.util.LoggerUtil.log;
import static java.lang.Thread.sleep;
/**
 * @author Chandra
 */
public class CommonUtil {
    public static StopWatch stopWatch=new StopWatch();

    public static void delay(long delayMilliSeconds){
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            log("Exception is:"+ e.getMessage());
        }
    }

    public static String transForm(String s){
        CommonUtil.delay(500);
        return s.toUpperCase();
    }
    public static void startTimer(){
        stopWatch.start();
    }

    public static void timeTaken(){
        stopWatch.stop();
        log("Total Time taken: "+stopWatch.getTime());
    }

    public static void stopWatchReset(){
        stopWatch.reset();
    }

    public static int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }

}
