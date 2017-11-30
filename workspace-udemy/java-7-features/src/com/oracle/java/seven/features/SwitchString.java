package com.oracle.java.seven.features;

public class SwitchString {

	public void oldStringValidate(String someString) {
		if (someString.equalsIgnoreCase("NEW")) {
			// do something
		} else if (someString.equalsIgnoreCase("EXECUTE")) {
			// do something
		} else if (someString.equalsIgnoreCase("PENDING")) {
			// do something
		}
	}

	public void newSwitchString(String someString) {
		switch (someString) {
		case "NEW":
			// do something
			break;
		case "EXECUTE":
			// do something
			break;
		case "PENDING":
			// do something
			break;
		default:
			break;
		}
	}

}
