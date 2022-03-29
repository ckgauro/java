package com.gauro.java7;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandra
 */
public class ExceptionHandlingForReflectiveMethods {
    private final static Logger LOGGER=Logger.getLogger(ExceptionHandlingForReflectiveMethods.class.getName());

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        beforeJava7();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("With Java 7====>");
        withJava7();
    }

    /**
     * Before Java7
     */

    private static void beforeJava7() {
        try{
            Class.forName("com.gauro.java7.CatchingMultipleExceptions").getMethod("withJava7").invoke(null, new Object[]{});
        }catch (InvocationTargetException | NoSuchMethodException | ClassNotFoundException | IllegalAccessException nex) {
            LOGGER.log(Level.SEVERE,nex.toString());
        }
    }

    /**
     * After Jva 7
     */

    private static void withJava7() {
        try {
            Class.forName("com.gauro.java7.CatchingMultipleExceptions").getMethod("withJava7").invoke(null, new Object[]{});
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE,e.toString());
        }
    }
}
