package com.br.firstspring.firstspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.br.firstspring.firstspring.xml.XmlPersonDAO;

public class FirstspringApplicationXml {

	private static Logger LOGGER = LoggerFactory.getLogger(FirstspringApplicationXml.class);

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml")) {

			LOGGER.info("Beans Loaded -> {}", (Object) ac.getBeanDefinitionNames());

			XmlPersonDAO xmlPersonDAO = ac.getBean(XmlPersonDAO.class);

			LOGGER.info("{}", xmlPersonDAO);
			LOGGER.info("{}", xmlPersonDAO.getXmlJdbcConnection());
		}
	}
}
