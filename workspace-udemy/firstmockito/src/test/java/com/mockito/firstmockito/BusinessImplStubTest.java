package com.mockito.firstmockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusinessImplStubTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		BusinessImpl businessImpl = new BusinessImpl(new DataServiceStub());
		assertEquals(businessImpl.findTheGreatestFromAllData(), 22);
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 4, 6, 12, 85, 13, 54, 21, 4 };
	}

}