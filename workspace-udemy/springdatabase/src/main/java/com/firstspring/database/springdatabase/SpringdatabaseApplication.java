package com.firstspring.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.firstspring.database.springdatabase.bean.Person;
import com.firstspring.database.springdatabase.business.PersonJdbcBusiness;
import com.firstspring.database.springdatabase.business.PersonJpaBusiness;
import com.firstspring.database.springdatabase.springdata.jpa.PersonSpringDataRepository;

@SpringBootApplication
@ComponentScan(value = "com.firstspring.database")
public class SpringdatabaseApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SpringdatabaseApplication.class);

	@Autowired
	private PersonJdbcBusiness business;

	@Autowired
	private PersonJpaBusiness businessJPA;

	@Autowired
	private PersonSpringDataRepository springDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// JDBC
		logger.warn("======JDBC SECTION======");
		logger.debug(business.toString());
		logger.info("{}", business.findAll());
		logger.info("{}", business.findById(10001l));
		logger.info("Deleted {} objects!", business.deleteById(10001l));
		logger.info("{}", business.findAll());

		Person person = new Person(10001l, "Joao Maria", "Bahia", new Date());
		logger.info("Inserted {} objects!", business.insertPerson(person));

		person.setName("Jose Maria");
		logger.info("Updated {} objects!", business.updatePerson(person));

		logger.info("{}", business.findAll());

		// JPA
		logger.warn("======JPA SECTION======");
		logger.debug(businessJPA.toString());
		logger.info("{}", businessJPA.findAll());
		logger.info("{}", businessJPA.findById(10001l));
		person = businessJPA.findById(10001l);
		businessJPA.delete(person);
		logger.info("Deleted {} objects!", person);
		logger.info("{}", businessJPA.findAll());

		person = new Person("Joao Maria", "Bahia", new Date());
		person = businessJPA.insertPerson(person);
		logger.info("Inserted {} objects!", person);

		person.setName("Jose Maria");
		logger.info("Updated {} objects!", businessJPA.updatePerson(person));
		logger.info("{}", businessJPA.findAll());

		// Spring Data
		logger.warn("======Spring Data SECTION======");
		logger.debug(springDataRepository.toString());
		logger.info("{}", springDataRepository.findAll());
		logger.info("{}", springDataRepository.findById(10002l));
		person = springDataRepository.findById(10002l).get();
		springDataRepository.delete(person);
		logger.info("Deleted {} objects!", person);
		logger.info("{}", springDataRepository.findAll());

		person = new Person("Joao Maria", "Bahia", new Date());
		person = springDataRepository.save(person);
		logger.info("Inserted {} objects!", person);

		person.setName("Jose Maria");
		logger.info("Updated {} objects!", springDataRepository.save(person));
		logger.info("{}", springDataRepository.findAll());
	}
}
