package com.gauro.java7;

/**
 * @author Chandra
 */
public class RethrowExceptions {
    public static void main(String[] args) throws Exception {
       // beforeJava7("First");
        withJava7("FIrst");
    }

    /**
     * Sample implementation before Java 7
     * @param exceptionName
     * @throws Exception
     */

    private static void beforeJava7(String exceptionName) throws Exception{
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Sample implementation after Java 7
     * @param exceptionName
     * @throws SecondException
     * @throws FirstException
     */

    private static void withJava7(String exceptionName) throws SecondException, FirstException {
        try{
            if(exceptionName.equals("First")){
                throw new FirstException();
            }else{
                throw new SecondException();
            }
        }catch (Exception e){
            throw e;
        }
    }



    static class FirstException extends Exception{}
    static class SecondException extends  Exception{}
}
