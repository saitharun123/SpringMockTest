package com.mrl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrl.entity.Author;
import com.mrl.entity.Book;

public interface AuthorRepo extends JpaRepository<Author, Long>{

	
	//List<Book> findAllBooksByAuthorId(long id);

}
