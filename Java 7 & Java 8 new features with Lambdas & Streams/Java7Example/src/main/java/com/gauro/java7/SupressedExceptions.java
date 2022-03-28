package com.gauro.java7;

import util.CustomDirtyResource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandra
 */
public class SupressedExceptions {
    private final static Logger LOGGER=Logger.getLogger(SupressedExceptions.class.getName());

    /**
     *
     * @param args
     */
    public static void main(String[] args)  {
        System.out.println("Prior Java 7====>");
        try {
            beforeJava7();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("With Java 7====>");
        try {
            withJava7();
        }catch(Exception ex){
            LOGGER.log(Level.SEVERE,ex.getMessage());
            final Throwable[] suppressedExceptions=ex.getSuppressed();
            final int numSuppressed=suppressedExceptions.length;
            if(numSuppressed>0){
                for(final Throwable exception:suppressedExceptions){
                    LOGGER.log(Level.SEVERE,exception.getMessage());
                }
            }
        }

    }
    /**
     * Sample implementation before Java 7
     *
     * @throws Exception
     */
    public static void beforeJava7() throws Exception {
        System.out.println("beforeJava7 Java 7 Example=======");
        CustomDirtyResource cr=null;
        try{
            cr=new CustomDirtyResource();
            cr.readFromResource();
        }finally {
            cr.close();
        }

    }

    /**
     * Sample implementation from Java 7
     * @throws Exception
     */
    public static void withJava7() throws Exception {
        System.out.println("With Java 7 Example=======");
        try (CustomDirtyResource cr = new CustomDirtyResource();) {
            cr.readFromResource();
        }
    }

}
