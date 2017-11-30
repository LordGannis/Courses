package com.oracle.java.eight.features;

import java.util.function.Supplier;

interface Defaulable {

	default String notRequired() {
		return "Default implementation";
	}

	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}

}

class DefaultableImpl implements Defaulable {
}

class OverridableImpl implements Defaulable {

	@Override
	public String notRequired() {
		return "Overridden implementation";
	}

}
