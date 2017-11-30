package com.in28minutes.springrest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springrest.exception.UserNotFoundException;
import com.in28minutes.springrest.model.Post;
import com.in28minutes.springrest.model.User;
import com.in28minutes.springrest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) throws UserNotFoundException {
		Optional<User> user = userService.findOne(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		// HATEOAS
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/users")
	public void updateUser(@RequestBody User user) throws UserNotFoundException {
		Optional<User> optionalUser = userService.findOne(user.getId());
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("id-" + user.getId());
		}
		userService.save(optionalUser.get());
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
		Optional<User> user = userService.findOne(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		userService.delete(user.get());
	}

	@GetMapping(path = "/users/{id}/posts")
	public Set<Post> retrieveAllUsersPost(@PathVariable Integer id) throws UserNotFoundException {
		Optional<User> user = userService.findOne(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		return user.get().getListPosts();
	}

	@GetMapping(path = "/posts/{id}")
	public Post retrieveUserPost(@PathVariable Integer id) throws UserNotFoundException {
		Optional<Post> post = userService.findOnePost(id);
		if (!post.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		return post.get();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id, @Valid @RequestBody Post post)
			throws UserNotFoundException {
		Optional<User> user = userService.findOne(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		post.setUser(user.get());
		Post savedPost = userService.savePost(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/posts/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
