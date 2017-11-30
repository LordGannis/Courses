package com.firstspring.database.springdatabase.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.database.springdatabase.bean.Person;
import com.firstspring.database.springdatabase.jpa.PersonJpaRepository;

@Service
public class PersonJpaBusiness {

	@Autowired
	PersonJpaRepository dao;

	public List<Person> findAll() {
		return dao.findAll();
	}

	public Person findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Person person) {
		dao.delete(person);
	}

	public Person insertPerson(Person person) {
		return dao.insertUpdate(person);
	}

	public Person updatePerson(Person person) {
		return dao.insertUpdate(person);
	}

}
