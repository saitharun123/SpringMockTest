package com.mrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrl.entity.Library;
import com.mrl.repo.LibraryRepo;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepo repo;

	public void addLibrary(Library library) {
		repo.save(library);
	}
	
	public List<Library> getAllLibraries() {
		return repo.findAll();
	}
	
	public Library getLibraryById(long id) {
		return repo.findById(id).get();
	}
	

}
