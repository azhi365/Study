package com.packtpub.java7.concurrency.chapter7.core;

import com.packtpub.java7.concurrency.chapter7.recipe10.Consumer;
import com.packtpub.java7.concurrency.chapter7.recipe10.Event;
import com.packtpub.java7.concurrency.chapter7.recipe10.MyPriorityTransferQueue;
import com.packtpub.java7.concurrency.chapter7.recipe10.Producer;

import java.util.concurrent.TimeUnit;

/**
 * 实现一个基于优先级的传输队列
 */
public class Chapter7Recipe10 {


    public static void main(String[] args) throws Exception {


        MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<>();


        Producer producer = new Producer(buffer);


        Thread producerThreads[] = new Thread[10];
        for (int i = 0; i < producerThreads.length; i++) {
            producerThreads[i] = new Thread(producer);
            producerThreads[i].start();
        }

        Consumer consumer = new Consumer(buffer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();


        System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());


        Event myEvent = new Event("Core Event", 0);
        buffer.transfer(myEvent);
        System.out.printf("Main: My Event has ben transfered.\n");


        for (int i = 0; i < producerThreads.length; i++) {
            producerThreads[i].join();
        }


        TimeUnit.SECONDS.sleep(1);


        System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());


        myEvent = new Event("Core Event 2", 0);
        buffer.transfer(myEvent);


        consumerThread.join();


        System.out.printf("Main: End of the program\n");
    }

}
