package com.guides.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guides.models.User;
import com.guides.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	public UserRepository rep;

	public List<User> getAll() {
		return rep.findAll();
	}

}
