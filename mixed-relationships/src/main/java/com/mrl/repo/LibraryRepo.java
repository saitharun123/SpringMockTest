package com.mrl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrl.entity.Library;

public interface LibraryRepo extends JpaRepository<Library, Long> {

}
