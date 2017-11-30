package com.in28minutes.springrest.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springrest.dao.PostDAO;
import com.in28minutes.springrest.dao.UserDAO;
import com.in28minutes.springrest.model.Post;
import com.in28minutes.springrest.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PostDAO postDAO;

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public long usersCount() {
		return userDAO.count();
	}

	public User save(User user) {
		return userDAO.save(user);
	}

	public Optional<User> findOne(Integer id) {
		try {
			return userDAO.findById(id);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void delete(User user) {
		userDAO.delete(user);
	}
	
	public List<Post> findPostAll() {
		return postDAO.findAll();
	}
	
	public long postsCount() {
		return postDAO.count();
	}
	
	public Post savePost(Post post) {
		return postDAO.save(post);
	}
	
	public Optional<Post> findOnePost(Integer id) {
		try {
			return postDAO.findById(id);
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public void deletePost(Post post) {
		postDAO.delete(post);
	}

}
