package com.br.firstspring.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.br.firstspring.firstspring.basic.BinarySearchImpl;

@SpringBootApplication
public class FirstspringApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FirstspringApplication.class, args);
		System.out.println(ac.getBean(BinarySearchImpl.class).binarySearch(new int[] { 124, 6, 12, 30, 2, 1, 400 }, 6));
	}
}
