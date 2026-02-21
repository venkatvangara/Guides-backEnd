package com.guides.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guides.models.User;
import com.guides.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository rep = null;

	public List<User> getAll() {
		return rep.findAll();
	}

	public User create(User u) {
		return rep.save(u);
	}

	public void delete(int id) {
		rep.deleteById(id);
	}

}
