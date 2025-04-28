package com.mrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrl.entity.Author;
import com.mrl.entity.Book;
import com.mrl.repo.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo repo;
	
	public void addAuthor(Author author) {
		repo.save(author);
	}
	
	public Author getAuthorById(long id) {
		return repo.findById(id).orElseThrow();
	}
	public void deleteAuthorById(long id) {
		repo.deleteById(id);
	}
//	public List<Book> getAllBooksByAuthor(long id){
//		return repo.findAllBooksByAuthorId(id);
//	}
}
