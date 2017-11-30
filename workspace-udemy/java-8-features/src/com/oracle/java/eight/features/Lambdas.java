package com.oracle.java.eight.features;

import java.util.Arrays;

public class Lambdas {

	public static void main(String[] args) {
		Arrays.asList("a1", "b1", "d1").forEach(e -> System.out.println(e));
		Arrays.asList("a2", "b2", "d2").forEach((String e) -> System.out.println(e));

		Arrays.asList("a3", "b3", "d3").forEach(e -> {
			System.out.print("Another lambda impl: " + e);
		});

		String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));

		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));

	}

}

@FunctionalInterface
interface Functional {
	void method();
}

@FunctionalInterface
interface FunctionalDefaultMethods {
	void method();

	default void defaultMethod() {
		// do something
	}
}
