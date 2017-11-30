package com.br.firstspring.firstspring.cdi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	@Mock
	SomeCdiDAO daoMock;

	@InjectMocks
	SomeCdiBusiness someCdiBusiness;

	@Test
	public void testBasic() {
		when(daoMock.getData()).thenReturn(new int[] { 1, 2, 6, 86, 24, 123 });
		int ret = someCdiBusiness.findGreatest();
		assertEquals(ret, 123);
	}

}
