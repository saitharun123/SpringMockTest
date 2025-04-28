package com.mrl.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String isbn;
	
	@OneToMany(mappedBy = "library")
	private List<Book> books;

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", isbn=" + isbn + "]";
	}
	
	
	
}
