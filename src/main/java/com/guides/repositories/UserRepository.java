package com.guides.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guides.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
