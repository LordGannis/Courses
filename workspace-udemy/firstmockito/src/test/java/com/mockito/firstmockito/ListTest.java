package com.mockito.firstmockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10);
		assertEquals(listMock.size(), 10);
	}
	
	@Test
	public void testSecond() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10).thenReturn(20);
		assertEquals(listMock.size(), 10);
		assertEquals(listMock.size(), 20);
	}
	
	@Test
	public void testThird() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn(10);
		assertEquals(listMock.get(0), 10);
		assertEquals(listMock.get(1), null);
	}
	
	@Test
	public void testFourth() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn(10).thenReturn(20);
		assertEquals(listMock.get(0), 10);
		assertEquals(listMock.get(1), 20);
		assertEquals(listMock.get(2), 20);
	}

}
