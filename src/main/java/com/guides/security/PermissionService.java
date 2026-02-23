package com.guides.security;

import org.springframework.stereotype.Service;

import com.guides.repositories.UserRepository;

@Service
public class PermissionService {

	private final UserRepository userRepository;

	public PermissionService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean isAdmin(int userId) {
		return userRepository.findById(userId).map(u -> "ADMIN".equalsIgnoreCase(u.getRole())).orElse(false);
	}

	public boolean isUser(int userId) {
		return userRepository.findById(userId).map(u -> "USER".equalsIgnoreCase(u.getRole())).orElse(false);
	}
}
