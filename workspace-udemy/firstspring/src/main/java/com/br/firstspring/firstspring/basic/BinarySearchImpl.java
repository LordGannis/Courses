package com.br.firstspring.firstspring.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

	private static Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);
	
	@Autowired
	@Qualifier("quick")
	private SortAlgorithm bubbleSortAlgorithm;

	public int binarySearch(int[] numbers, int numberSearched) {
		
		numbers = bubbleSortAlgorithm.sort(numbers);
		
		System.out.println(bubbleSortAlgorithm);
		
		return 3;
	}
	
	@PostConstruct
	public void postConstruct() {
		LOGGER.info("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		LOGGER.info("preDestroy");
	}

}
