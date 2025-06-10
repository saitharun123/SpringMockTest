package com.tecxter.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	 
	   @NotEmpty
	   @Size(min = 5, message ="School name should contain atleast 5 letters")
	   private String schoolName;
	   
	   @NotEmpty(message = "Please enter the district name")
	   private String district;
	 
	   @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	   private List<Teacher> teachers = new ArrayList<>();
	   
	   
}
