package com.br.firstspring.firstspring.cdi;

import javax.inject.Named;

@Named
public class SomeCdiDAO {

	public int[] getData() {
		return new int[] { 5, 6, 8, 123 };
	}

}
