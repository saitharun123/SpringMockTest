package com.mrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrl.entity.Book;
import com.mrl.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public void addBooks(List<Book> books) {
		repo.saveAll(books);
	}
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
	
	public Book getBookById(long id) {
		return repo.findById(id).get();
	}
	
	public List<Book> getAllBooksByAuthorId(long id){
		return repo.findAllByAuthorId(id);
		
	}
	
	public List<Book> getAllBooksByLibraryId(long id){
		return repo.findAllByLibraryId(id);
	}
	
}
