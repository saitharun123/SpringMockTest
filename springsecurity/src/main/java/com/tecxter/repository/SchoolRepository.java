package com.tecxter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecxter.entity.School;

public interface SchoolRepository extends JpaRepository<School,Long> {

}
