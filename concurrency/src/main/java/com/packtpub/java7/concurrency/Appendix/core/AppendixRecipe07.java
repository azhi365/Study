package com.packtpub.java7.concurrency.Appendix.core;

import com.packtpub.java7.concurrency.Appendix.recipe07.task.Task;

public class AppendixRecipe07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i<20; i++){
			Task task=new Task();
			Thread thread=new Thread(task);
			thread.start();
		}

	}

}
