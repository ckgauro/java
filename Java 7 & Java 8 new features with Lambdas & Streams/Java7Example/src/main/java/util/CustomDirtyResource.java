package com.gauro.java7;

/**
 * @author Chandra
 */
public class CustomDirtyResource implements AutoCloseable{
    @Override
    public void close() throws Exception{
        System.out.println("OOPs . It is very bad to have a NUllPointerException");
        throw new NullPointerException("OOPs . It is very bad to have a NUllPointerException");

    }
    public void readFromResource(){
        throw new RuntimeException("I am sorry. I don't have data available right now due to network issue!!!");
    }
}
