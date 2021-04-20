package com.example.demo.section2;

/**
 * @author Chandra
 */
public class FirstLambdaExample {
    public static void main(String[] args) {

        Thread t1 = new Thread(
                () ->  System.out.println("Thread executed"));
        t1.start();

        //Runnable

    }
}
