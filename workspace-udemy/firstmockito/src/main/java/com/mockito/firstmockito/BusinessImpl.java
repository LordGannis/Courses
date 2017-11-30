package com.mockito.firstmockito;

public class BusinessImpl {
	private DataService dataService;

	public BusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public BusinessImpl() {
		super();
	}

	int findTheGreatestFromAllData() {
		int greatest = Integer.MIN_VALUE;
		for (int value : dataService.retrieveAllData()) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}