package com.in28minutes.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springrest.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}