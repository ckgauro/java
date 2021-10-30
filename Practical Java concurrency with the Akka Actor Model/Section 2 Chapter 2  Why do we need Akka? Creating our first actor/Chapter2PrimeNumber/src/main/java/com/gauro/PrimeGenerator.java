package com.gauro;

import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator  implements  Runnable{
    private final Results results;

    public PrimeGenerator(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
       // System.out.println("PrimeGenerator generate ========>");
        BigInteger bigInteger=new BigInteger(2000, new Random());
        results.addPrime(bigInteger.nextProbablePrime());
      //  System.out.println("PrimeGenerator ends ========>"+results.getSize());


    }
}
