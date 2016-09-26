package com.packtpub.java7.concurrency.chapter1.recipe7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that simulates an initialization operation. It sleeps during six seconds 
 *
 */
public class NetworkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Begining network connections loading: %s\n",new Date());

		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Network connections loading has finished: %s\n",new Date());
	}
}