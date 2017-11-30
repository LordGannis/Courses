package com.firstspring.database.springdatabase.springdata.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.database.springdatabase.bean.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {

}
