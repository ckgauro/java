package com.gauro.java7;
import util.CustomResource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Chandra
 */
public class TryWithResources {
    static String path="/Users/ckgauro/Tutorial/github/java/Java 7 & Java 8 new features with Lambdas & Streams/Java7Example/src/main/resources/data.txt";


    public static void main(String[] args) throws Exception {
        beforeJava7();
        System.out.println("------");
        withJava7();
        System.out.println("------");
        withCustomResInJava7();

    }

    /**
     * Sample implementation before Java 7
     * @throws Exception
     */
    public static void beforeJava7() throws Exception{
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader(path));
            String sCurrentLine;
            while((sCurrentLine= br.readLine())!=null){
                System.out.println(sCurrentLine);
            }

        }finally{
            br.close();
        }

    }

    /**
     * Sample implementation from Java 7
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void withJava7() throws IOException {
        try(BufferedReader br=new BufferedReader(new FileReader(path)); ){
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                System.out.println(sCurrentLine);
            }
        }

    }
    /**
            * Sample implementation from Java 7
            * @throws Exception
	 */
    public static void withCustomResInJava7() throws Exception {
        try(CustomResource cr=new CustomResource();){
            cr.readFromResource();
        }

    }
}
