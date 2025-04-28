package com.mrl.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mrl.entity.Author;
import com.mrl.entity.Book;
import com.mrl.entity.Library;
import com.mrl.service.AuthorService;
import com.mrl.service.BookService;
import com.mrl.service.LibraryService;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private LibraryService libService;
	@Override
	public void run(String... args) throws Exception {
		
		Library lib1 = new Library();
		lib1.setIsbn("007");
		lib1.setName("Central Library");
	
		Author a1 = new Author();
		a1.setName("Chetan Bhagat");
		
		Author a2 = new Author();
		a2.setName("Reema Thereja");
		
		Book b1 = new Book();
		b1.setTitle("A Dawn");
		b1.setAuthor(a1);
		b1.setLibrary(lib1);
		
		Book b2 = new Book();
		b2.setTitle("C Programming made easy");
		b2.setAuthor(a2);
		b2.setLibrary(lib1);
		
		Book b3 = new Book();
		b3.setTitle("The rise");
		b3.setAuthor(a1);
		b3.setLibrary(lib1);
		
		a1.setBooks(Arrays.asList(b1,b3));
		a2.setBooks(Arrays.asList(b2));
		
		lib1.setBooks(Arrays.asList(b1,b2,b3));
		
		libService.addLibrary(lib1);
		authorService.addAuthor(a1);
		authorService.addAuthor(a2);
		
		List<Book> allBooks = bookService.getAllBooksByAuthorId(1);
		for(Book b : allBooks) {
			System.out.println("Book Name :"+b.getTitle()+" -> Author : "+b.getAuthor().getName());
		}

		List<Book> booksByLib = bookService.getAllBooksByLibraryId(1);
		booksByLib.forEach(n -> System.out.println("Book Name : "+n.getTitle()+" -> Library Name : "+n.getLibrary().getName()));
	}

}
