package com.mrl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", library=" + library + ", author=" + author + "]";
	}
	
	
}
