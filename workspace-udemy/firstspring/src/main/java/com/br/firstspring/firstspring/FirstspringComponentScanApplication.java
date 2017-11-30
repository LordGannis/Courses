package com.br.firstspring.firstspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.br.firstspring.componentscans.ComponentPersonDAO;
import com.br.firstspring.firstspring.scope.JdbcConnection;

@SpringBootApplication
@ComponentScan("com.br.firstspring")
public class FirstspringComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(FirstspringComponentScanApplication.class);

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FirstspringComponentScanApplication.class, args);
		ComponentPersonDAO person = ac.getBean(ComponentPersonDAO.class);
		ComponentPersonDAO person2 = ac.getBean(ComponentPersonDAO.class);

		LOGGER.info("{}", person);
		LOGGER.info("{}", person.getJdbcConnection());

		LOGGER.info("{}", person2);
		LOGGER.info("{}", person2.getJdbcConnection());
		
		LOGGER.info("{}", ac.getBean(JdbcConnection.class));
	}
}
