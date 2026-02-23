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

import com.guides.models.Activity;
import com.guides.services.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

	private final ActivityService service;

	@GetMapping("/guide/{guideId}")
	public List<Activity> getByGuide(@PathVariable("guideId") int guideId) {
		return service.getByGuideId(guideId);
	}

	@PostMapping("/guide/{guideId}")
	public Activity create(@PathVariable("guideId") int guideId, @RequestParam("userId") int userId,
			@RequestBody Activity a) {

		return service.create(guideId, userId, a);
	}

	@PutMapping("/{id}")
	public Activity update(@PathVariable("id") int id, @RequestParam("userId") int userId, @RequestBody Activity a) {

		return service.update(id, userId, a);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id, @RequestParam("userId") int userId) {

		service.delete(id, userId);
	}
}
