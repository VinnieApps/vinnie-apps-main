package org.visola.howthewebworks.serverside;

import java.util.Random;

public class Main {

    public static void main (String [] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Process is shutting down...");
                try {
                    while (true) {
                        System.out.println("I'm not going to die...");
                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    // Ignore exception
                }
            }
        });

        Random random = new Random();
        while (true) { // Infinite loop
            int next = random.nextInt(1000);
            System.out.printf("Next random number was: %d%n", next);
            Thread.sleep(1000);
        }
    }

}
