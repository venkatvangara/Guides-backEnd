package com.guides.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
	public int id;
	public String title;
	public String description;
	public String address;
	public String category;
	public String openingHours;
	public int visitorder;
	public int daynumber;

}
