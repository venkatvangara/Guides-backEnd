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
import org.springframework.web.bind.annotation.RestController;

import com.guides.models.Guide;
import com.guides.services.GuideService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/guides")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GuideController {

	private final GuideService service;

	@GetMapping
	public List<Guide> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Guide getById(@PathVariable("id") int id) {
		return service.getById(id);
	}

	@PostMapping
	public Guide create(@RequestBody Guide g) {
		return service.create(g);
	}

	@PutMapping("/{id}")
	public Guide update(@PathVariable("id") int id, @RequestBody Guide g) {
		g.setId(id);
		return service.create(g);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	@GetMapping("/user/{userId}")
	public List<Guide> getGuidesForUser(@PathVariable("userId") int userId) {
		return service.getGuidesForUser(userId);
	}
}
