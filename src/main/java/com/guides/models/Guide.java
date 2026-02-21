package com.guides.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public String title;
	public String description;
	public int days;
	public String season;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Activity> activities = new ArrayList<>();
	@ManyToMany
	private List<User> invitedUsers = new ArrayList<>();

}
