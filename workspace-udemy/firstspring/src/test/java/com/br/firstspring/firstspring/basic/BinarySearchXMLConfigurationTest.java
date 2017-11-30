package com.br.firstspring.firstspring.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="/testContext.xml")
public class BinarySearchXMLConfigurationTest {

	@Autowired
	BinarySearchImpl binarySearch;

	@Test
	public void testBasic() {
		int ret = binarySearch.binarySearch(new int[] { 1, 2, 5, 67, 8 }, 2);
		assertEquals(ret, 3);
	}

}
