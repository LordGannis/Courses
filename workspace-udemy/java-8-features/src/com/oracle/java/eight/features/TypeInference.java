package com.oracle.java.eight.features;

public class TypeInference {
	public static void main(String[] args) {
		final Value<String> value = new Value<>();
		value.getOrDefault("22", Value.defaultValue());
	}

}

class Value<T> {

	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault(T value, T defaultValue) {
		return (value != null) ? value : defaultValue;
	}

}
