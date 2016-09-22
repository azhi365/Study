package com.packtpub.java7.concurrency.Appendix.recipe07.task;

import com.packtpub.java7.concurrency.Appendix.recipe07.util.DBConnectionOK;

public class Task implements Runnable {

	@Override
	public void run() {

		System.out.printf("%s: Getting the connection...\n",Thread.currentThread().getName());
		DBConnectionOK connection=DBConnectionOK.getConnection();
		System.out.printf("%s: End\n",Thread.currentThread().getName());
	}

}
