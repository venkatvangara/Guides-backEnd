package com.guides.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guides.models.Activity;
import com.guides.repositories.ActivityRepository;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = "*")
public class ActivityController {
	@Autowired
	private ActivityRepository rep;

	@GetMapping
	public List<Activity> getAll() {
		return rep.findAll();
	}

	@PostMapping
	public Activity create(@RequestBody Activity activity) {
		return rep.save(activity);
	}
}
