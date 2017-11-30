package com.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	@Test
	void test() {
		boolean cond = true;
		assertEquals(cond, true);
		assertTrue(cond);
		assertFalse(cond);
	}

}
