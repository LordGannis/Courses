package com.br.firstspring.firstspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.br.firstspring.firstspring.scope.JdbcConnection;
import com.br.firstspring.firstspring.scope.PersonDAO;

@SpringBootApplication
public class FirstspringScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(FirstspringScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FirstspringScopeApplication.class, args);
		PersonDAO person = ac.getBean(PersonDAO.class);
		PersonDAO person2 = ac.getBean(PersonDAO.class);

		LOGGER.info("{}", person);
		LOGGER.info("{}", person.getJdbcConnection());

		LOGGER.info("{}", person2);
		LOGGER.info("{}", person2.getJdbcConnection());
		
		LOGGER.info("{}", ac.getBean(JdbcConnection.class));
	}
}
