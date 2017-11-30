package com.mockito.firstmockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class BusinessImplMockTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] { 4, 6, 12, 85, 13, 54, 21, 4 };
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 4, 6, 12, 85, 13, 54, 21, 4 });

		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);
		assertEquals(businessImpl.findTheGreatestFromAllData(), 85);
	}
	
	@Test
	public void testFindTheGreatestFromOneData() {
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] { 85 };
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 85 });
		
		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);
		assertEquals(businessImpl.findTheGreatestFromAllData(), 85);
	}

}
