package com.packtpub.java7.concurrency.chapter9.core;

import java.util.concurrent.LinkedTransferQueue;

import com.packtpub.java7.concurrency.chapter9.recipe04.task.Consumer;
import com.packtpub.java7.concurrency.chapter9.recipe04.task.Producer;

/**
 * Main class of the example. It executes 100 producers and 100 consumers
 *
 */
public class Chapter9Recipe04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int THREADS=100;
		/*
		 * Create a Linked TransferQueue of Strings to store the objects
		 * generated by the producers and consumed by the consumer
		 */
		LinkedTransferQueue<String> buffer=new LinkedTransferQueue<>();
		/*
		 * An array to store the Thread objects that execute the producers
		 */
		Thread producerThreads[]=new Thread[THREADS];
		
		/*
		 * An array to store the Thread objects that execute the consumers
		 */
		Thread consumerThreads[]=new Thread[THREADS];
		
		/*
		 * Launch 100 Consumer tasks
		 */
		for (int i=0; i<THREADS; i++){
			Consumer consumer=new Consumer("Consumer "+i,buffer);
			consumerThreads[i]=new Thread(consumer);
			consumerThreads[i].start();
		}
		
		/*
		 * Launch 100 Producer tasks 
		 */
		for (int i=0; i<THREADS; i++) {
			Producer producer=new Producer("Producer: "+i,buffer);
			producerThreads[i]=new Thread(producer);
			producerThreads[i].start();
		}
		
		/*
		 * Wait for the finalization of the threads
		 */
		for (int i=0; i<THREADS; i++){
			try {
				producerThreads[i].join();
				consumerThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/*
		 * Write the size of the buffer in the Console
		 */
		System.out.printf("Main: Size of the buffer: %d\n",buffer.size());
		System.out.printf("Main: End of the example\n");
	}

}