package com.firstspring.database.springdatabase.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firstspring.database.springdatabase.bean.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager em;

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = em.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}

	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	public void delete(Person person) {
		em.remove(findById(person.getId()));
	}

	public Person insertUpdate(Person person) {
		return em.merge(person);
	}

}
