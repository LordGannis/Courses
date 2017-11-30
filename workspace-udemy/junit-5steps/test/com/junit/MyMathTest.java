package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MyMathTest {

	MyMath math = new MyMath();

	@Before
	public void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}

	@Test
	public void sumWithThreeNumbers() {
		System.out.println("Test1");
		assertEquals(6, math.sum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sumWithOneNumbers() {
		System.out.println("Test2");
		assertEquals(3, math.sum(new int[] { 3 }));
	}

}
