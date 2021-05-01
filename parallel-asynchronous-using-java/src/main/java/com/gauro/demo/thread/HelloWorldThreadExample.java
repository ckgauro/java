package com.gauro.demo.thread;

import static com.gauro.demo.util.CommonUtil.delay;

/**
 * @author Chandra
 */
public class HelloWorldThreadExample {
    private static String result="";

    private static void hello(){
        delay(700);
        result=result.concat("Hello");
    }
    private static void  world(){
        delay(600);
        result=result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread helloThread=new Thread(()->hello());
        Thread worldThread=new Thread(()-> world());

        //Starting thr thread
        helloThread.start();
        worldThread.start();

        //Joining the thread (waiting for the threads to finish)
        helloThread.join();
        worldThread.join();
        System.out.println("Result is :"+result);


    }


}
