package com.mrl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrl.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

	List<Book> findAllByAuthorId(long id);

	List<Book> findAllByLibraryId(long id);

}
