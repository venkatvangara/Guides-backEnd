package com.guides.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guides.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
