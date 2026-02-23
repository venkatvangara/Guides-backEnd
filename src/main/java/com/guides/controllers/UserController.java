package com.guides.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guides.models.User;
import com.guides.security.PermissionService;
import com.guides.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private final UserService service;
	private final PermissionService permissionService;

	// GET ALL USERS (admin only)
	@GetMapping
	public List<User> getAll(@RequestParam int userId) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can view users");
		}

		return service.getAll();
	}

	// GET USER BY ID (admin only)
	@GetMapping("/{id}")
	public User getById(@PathVariable int id, @RequestParam int userId) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can view users");
		}

		return service.getById(id);
	}

	// CREATE USER (admin only)
	@PostMapping
	public User create(@RequestParam int userId, @RequestBody User u) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can create users");
		}

		return service.create(u);
	}

	// UPDATE USER (admin only)
	@PutMapping("/{id}")
	public User update(@PathVariable int id, @RequestParam int userId, @RequestBody User u) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can update users");
		}

		return service.update(id, u);
	}

	// DELETE USER (admin only)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id, @RequestParam int userId) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can delete users");
		}

		service.delete(id);
	}
}
