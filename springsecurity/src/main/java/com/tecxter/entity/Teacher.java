package com.tecxter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	 
	   @NotEmpty( message = "please enter a valid name" )
	   private String name;
	   @NotEmpty
	   @Size(min = 5, message = "Subject should contain atleast 5 letters")
	   private String subject;
	 
	   @ManyToOne
	   @JoinColumn(name = "school_id")
	   private School school;
}
