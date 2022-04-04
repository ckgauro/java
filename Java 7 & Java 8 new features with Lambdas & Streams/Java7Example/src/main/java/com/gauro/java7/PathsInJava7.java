package com.gauro.java7;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Chandra
 */
public class PathsInJava7 {
    private static String HOME_DIR="/Users/ckgauro/Tutorial/github/java/Java 7 & Java 8 new features with Lambdas & Streams/Java7Example/src/main/resources";

    public static void main(String[] args) {
        buildPath();
    }

    private static void buildPath() {
        Path path= Paths.get(HOME_DIR,"java7","Text.txt");
        Path fileName=path.getFileName();
        System.out.println("File Name is: "+fileName.toString());
        System.out.println("File System is: "+path.getFileSystem().toString());
        System.out.println("File System separator is :"+path.getFileSystem().getSeparator());

        for(int i=0;i<path.getNameCount();i++){
            Path subPath=path.getName(i);
            System.out.println("Path location at index :"+(i+1)+" is "+subPath.toString());
        }
        System.out.println("Sub path is "+path.subpath(0,2));
        System.out.println("Root path is :"+ path.getRoot());
        System.out.println("Parent path is :"+path.getParent());

        Path redundantPath=Paths.get(HOME_DIR,"java7",".","Test.txt");
        System.out.println("Redundant path is "+redundantPath.toString());
        Path cleanPath=redundantPath.normalize();
        System.out.println("Clean path is "+cleanPath.toString());
        URI uri=cleanPath.toUri();
        System.out.println("URI path is "+uri.toString());
        System.out.println("Absolute path is "+cleanPath.toAbsolutePath().toString());

        Path partialPath=Paths.get(HOME_DIR,"java7");
        Path combinePath=partialPath.resolve("Test.txt");
        System.out.println("Combined path is "+combinePath.toString());

        if(!partialPath.equals(combinePath)){
            System.out.println("Paths are not equal");
        }




    }
}
