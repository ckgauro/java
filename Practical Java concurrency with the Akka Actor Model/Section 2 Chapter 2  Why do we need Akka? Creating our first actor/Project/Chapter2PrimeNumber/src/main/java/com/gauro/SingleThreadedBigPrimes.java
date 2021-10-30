package com.gauro;

import java.math.BigInteger;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class SingleThreadedBigPrimes {
    public static void main(String[] args) {
        Long start=System.currentTimeMillis();
        SortedSet<BigInteger> primes=new TreeSet<>();
        while (primes.size()<=100){
            BigInteger bigInteger=new BigInteger(2000, new Random());
            primes.add(bigInteger.nextProbablePrime());
            System.out.println("Primes Size :"+primes.size());
        }
        Long end=System.currentTimeMillis();
        //System.out.println(primes);
        primes.forEach(System.out::println);
        System.out.println("The Time taken was :" + (end-start)+ " ms.");
    }
}
