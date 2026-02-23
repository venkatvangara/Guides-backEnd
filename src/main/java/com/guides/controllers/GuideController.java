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

import com.guides.models.Guide;
import com.guides.security.PermissionService;
import com.guides.services.GuideService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/guides")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GuideController {

	private final GuideService service;
	private final PermissionService permissionService;

	// GET ALL GUIDES (admin = all, user = invited only)
	@GetMapping
	public List<Guide> getAll(@RequestParam("userId") int userId) {

		if (permissionService.isAdmin(userId)) {
			return service.getAll();
		}

		if (permissionService.isUser(userId)) {
			return service.getGuidesForUser(userId);
		}

		throw new RuntimeException("Invalid user");
	}

	@GetMapping("/{id}")
	public Guide getById(@PathVariable("id") int id, @RequestParam("userId") int userId) {

		Guide guide = service.getById(id);

		// Admin can always view
		if (permissionService.isAdmin(userId)) {
			return guide;
		}

		// Normal users can also view (read-only)
		return guide;
	}

	// CREATE GUIDE (admin only)
	@PostMapping
	public Guide create(@RequestParam("userId") int userId, @RequestBody Guide g) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can create guides");
		}

		return service.create(g);
	}

	// UPDATE GUIDE (admin only)
	@PutMapping("/{id}")
	public Guide update(@PathVariable("id") int id, @RequestParam("userId") int userId, @RequestBody Guide g) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can update guides");
		}

		g.setId(id);
		return service.update(g);
	}

	// DELETE GUIDE (admin only)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id, @RequestParam("userId") int userId) {

		if (!permissionService.isAdmin(userId)) {
			throw new RuntimeException("Only admins can delete guides");
		}

		service.delete(id);
	}
}
