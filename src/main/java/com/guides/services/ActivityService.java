package com.guides.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guides.models.Activity;
import com.guides.models.Guide;
import com.guides.repositories.ActivityRepository;
import com.guides.repositories.GuideRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository repo;
	private final GuideRepository guideRepo;

	public List<Activity> getByGuideId(int guideId) {
		return repo.findByGuideId(guideId);
	}

	public Activity create(int guideId, int userId, Activity a) {
		Guide g = guideRepo.findById(guideId).orElseThrow();
		a.setGuide(g);
		return repo.save(a);
	}

	public Activity update(int id, int userId, Activity a) {
		a.setId(id);
		return repo.save(a);
	}

	public void delete(int id, int userId) {
		repo.deleteById(id);
	}
}
