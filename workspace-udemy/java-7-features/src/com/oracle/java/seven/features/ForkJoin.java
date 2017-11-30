package com.oracle.java.seven.features;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoin {

	public static void main(String[] args) throws IOException, InterruptedException {

		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		ProblemTask problemTask = new ProblemTask();
		pool.invoke(problemTask);

	}

}
