package com.firstspring.database.springdatabase.business;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.database.springdatabase.bean.Person;
import com.firstspring.database.springdatabase.jdbc.PersonJdbcDAO;

@Service
public class PersonJdbcBusiness {

	@Autowired
	PersonJdbcDAO dao;

	public Collection<Person> findAll() {
		return dao.findAll();
	}
	
	public Person findById(Long id) {
		return dao.findById(id);
	}
	
	public int deleteById(Long id) {
		return dao.deleteById(id);
	}
	
	public int insertPerson(Person person) {
		return dao.insert(person);
	}
	
	public int updatePerson(Person person) {
		return dao.update(person);
	}

}
