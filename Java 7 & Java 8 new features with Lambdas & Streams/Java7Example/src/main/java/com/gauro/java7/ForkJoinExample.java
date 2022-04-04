package com.gauro.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Chandra
 */
public class ForkJoinExample extends RecursiveAction {
    private static final long serialVersionUID=1L;
    private static final long threshold=2;
    private volatile long number;

    public static void main(String[] args) {

        ForkJoinExample task=new ForkJoinExample(6);
        new ForkJoinPool().invoke(task);
        System.out.println(task.getNumber());

    }
    @Override
    protected void compute() {
        long n=number;
        if(n<=threshold){
            number=fib(n);
        }else{
            ForkJoinExample f1=new ForkJoinExample(n-1);
            ForkJoinExample f2=new ForkJoinExample(n-2);
            ForkJoinExample.invokeAll(f1,f2);
            number=f1.number+f2.number;

        }

    }

    public ForkJoinExample(long number){
        this.number=number;
    }

    public long getNumber() {
        return number;
    }
    private static long fib(long n){
        if(n<=1){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }


}
