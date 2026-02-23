package com.guides.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guides.models.User;
import com.guides.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repo;

	public List<User> getAll() {
		return repo.findAll();
	}

	public User getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public User create(User u) {
		return repo.save(u);
	}

	public User update(int id, User u) {
		u.setId(id);
		return repo.save(u);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
