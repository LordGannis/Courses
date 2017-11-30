package com.br.firstspring.firstspring.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness {

	@Inject
	SomeCdiDAO someCdiDAO;

	public SomeCdiDAO getSomeCdiDAO() {
		return someCdiDAO;
	}

	public void setSomeCdiDAO(SomeCdiDAO someCdiDAO) {
		this.someCdiDAO = someCdiDAO;
	}

	public int findGreatest() {
		int greatest = Integer.MIN_VALUE;
		for (int value : someCdiDAO.getData()) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}
