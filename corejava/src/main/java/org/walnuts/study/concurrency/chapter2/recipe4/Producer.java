package org.walnuts.study.concurrency.chapter2.recipe4;


public class Producer implements Runnable {


    private EventStorage storage;


    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}