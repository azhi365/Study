package com.packtpub.java7.concurrency.chapter3.recipe8;

import java.util.List;
import java.util.concurrent.Exchanger;


public class Consumer implements Runnable {

    private final Exchanger<List<String>> exchanger;
    private List<String> buffer;


    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        int cycle = 1;

        for (int i = 0; i < 1; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);

            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Consumer: %d\n", buffer.size());

            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.printf("Consumer: %s\n", message);
                buffer.remove(0);
            }

            cycle++;
        }

    }

}
