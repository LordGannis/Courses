package com.mockito.firstmockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessImplMockAnnotationsTest {

	@Mock
	DataService dataServiceMock;

	@InjectMocks
	BusinessImpl businessImpl;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 4, 6, 12, 85, 13, 54, 21, 4 });
		assertEquals(businessImpl.findTheGreatestFromAllData(), 85);
	}

	@Test
	public void testFindTheGreatestFromOneData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 85 });
		assertEquals(businessImpl.findTheGreatestFromAllData(), 85);
	}

	@Test
	public void testFindTheGreatestFromNoData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(businessImpl.findTheGreatestFromAllData(), Integer.MIN_VALUE);
	}

}
