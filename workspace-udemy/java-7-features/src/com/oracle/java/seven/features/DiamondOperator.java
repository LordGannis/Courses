package com.oracle.java.seven.features;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiamondOperator {

	Map<String, List<Integer>> oldTrades = new TreeMap<String, List<Integer>> ();//Old way to do initializes
	Map<String, List<Integer>> newTrades = new TreeMap<> ();//Java 7 way - Diamond Operator
	Map<String, List<Integer>> wrongTrades = new TreeMap ();//Wrong way - you new the diamond operator

	
}
