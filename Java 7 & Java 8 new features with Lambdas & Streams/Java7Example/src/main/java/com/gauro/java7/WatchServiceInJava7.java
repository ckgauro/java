package com.gauro.java7;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author Chandra
 */
public class WatchServiceInJava7 {
    private static String HOME_DIR="/Users/ckgauro/Tutorial/github/java/Java 7 & Java 8 new features with Lambdas & Streams/Java7Example/src/main/resources";

    public static void main(String[] args) throws IOException, InterruptedException {
        directoryWatchService();
    }

    private static void directoryWatchService() throws IOException, InterruptedException {
        WatchService watchService= FileSystems.getDefault().newWatchService();
        Path path= Paths.get(HOME_DIR);
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE );
        boolean poll=true;
        WatchKey key=watchService.take();
        while (poll){
            for(WatchEvent<?> event: key.pollEvents()){
                System.out.println("Event kind: "+event.kind()+"- for the file:"+event.context());
            }
            poll= key.reset();
        }

    }
}
