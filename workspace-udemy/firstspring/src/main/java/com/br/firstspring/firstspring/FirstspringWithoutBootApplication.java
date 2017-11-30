package com.br.firstspring.firstspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.br.firstspring.firstspring.scope.JdbcConnection;
import com.br.firstspring.firstspring.scope.PersonDAO;

@Configuration
@ComponentScan
public class FirstspringWithoutBootApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(FirstspringWithoutBootApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
				FirstspringWithoutBootApplication.class)) {
			PersonDAO person = ac.getBean(PersonDAO.class);
			PersonDAO person2 = ac.getBean(PersonDAO.class);

			LOGGER.info("{}", person);
			LOGGER.info("{}", person.getJdbcConnection());

			LOGGER.info("{}", person2);
			LOGGER.info("{}", person2.getJdbcConnection());

			LOGGER.info("{}", ac.getBean(JdbcConnection.class));
		}
	}
}
