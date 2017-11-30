package com.in28minutes.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springrest.model.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Integer> {

}