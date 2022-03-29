package com.gauro.java7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandra
 */
public class CatchingMultipleExceptions {
    private final static Logger LOGGER=java.util.logging.Logger.getLogger(CatchingMultipleExceptions.class.getName());

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
     * Sample implementation before Java 7
     *
     */
    private static void beforeJava7() {
       // int arr[]={1,2,3};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException nex){
            LOGGER.log(Level.SEVERE,nex.toString());
        }catch (ArrayIndexOutOfBoundsException aioex){
            LOGGER.log(Level.SEVERE,aioex.toString());
        }
    }

    /**
     * Sample implementation from Java 7
     *
     */
    private static void withJava7() {
       // int arr[]={1,2,3};
        int arr[]=null;
        try{
            for(int i=0;i<arr.length+1;i++){
                System.out.println(arr[i]);
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException nex){
           // nex.addSuppressed(new Throwable("Data issue"));
            LOGGER.log(Level.SEVERE,nex.toString());
        }
    }


}
