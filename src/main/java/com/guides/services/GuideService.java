package com.guides.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guides.models.Guide;
import com.guides.repositories.GuideRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuideService {

	private final GuideRepository rep;

	public List<Guide> getAll() {
		return rep.findAll();
	}

	public Guide getById(int id) {
		return rep.findById(id).orElse(null);
	}

	public Guide create(Guide g) {
		return rep.save(g);
	}

	public void delete(int id) {
		rep.deleteById(id);
	}

	public Guide save(Guide guide) {
		return rep.save(guide);
	}

	public List<Guide> getGuidesForUser(int userId) {
		return rep.findByInvitedUsersId(userId);
	}
}
