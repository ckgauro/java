package com.gauro;

public class CurrentStatus  implements Runnable{
    private final Results results;

    public CurrentStatus(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        System.out.println("Calling Thread======>");
        while (results.getSize()<100){
            System.out.println("Got "+ results.getSize()+" so far ...");
            //results.print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Ends======>");

    }
}
