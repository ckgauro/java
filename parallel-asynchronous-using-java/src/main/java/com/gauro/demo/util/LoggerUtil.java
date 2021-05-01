package com.gauro.demo.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chandra
 */
@Slf4j
public class LoggerUtil {
    public static void log(String message){
        log.info("["+Thread.currentThread().getName()+"] - "+message);

    }
}
