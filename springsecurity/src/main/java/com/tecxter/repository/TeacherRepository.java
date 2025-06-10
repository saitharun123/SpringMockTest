package com.tecxter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecxter.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
