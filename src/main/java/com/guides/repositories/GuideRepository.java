package com.guides.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guides.models.Guide;

public interface GuideRepository extends JpaRepository<Guide, Integer> {
	List<Guide> findByInvitedUsersId(Long userId);
}
