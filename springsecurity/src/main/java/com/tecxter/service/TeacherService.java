package com.tecxter.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tecxter.dto.TeacherDto;



public interface TeacherService {

	TeacherDto createTeacher(TeacherDto teacherDto);
	
	TeacherDto updateTeacher(TeacherDto teacherDto) throws Exception;
	
	String deleteTeacherById(Long id);
	
	TeacherDto findTeacherById(Long id);

	List<TeacherDto> findAllTeachers();
	
	List<TeacherDto> findAllTeachers(PageRequest page);
}
