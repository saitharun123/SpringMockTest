package com.tecxter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecxter.dto.SchoolDto;
import com.tecxter.dto.TeacherDto;
import com.tecxter.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	@Autowired
	private TeacherService service;


	public TeacherController(TeacherService service) {
		super();
		this.service = service;
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	private ResponseEntity<TeacherDto> createTeacher(@Valid @RequestBody TeacherDto teacherDto) {
		TeacherDto teacher = service.createTeacher(teacherDto);
		return new ResponseEntity<TeacherDto>(teacher,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	private ResponseEntity<TeacherDto> updateTeacher(@Valid @RequestBody TeacherDto teacherDto) throws Exception {
		TeacherDto updateTeacher = service.updateTeacher(teacherDto);
		return new ResponseEntity(updateTeacher,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	private ResponseEntity<List<TeacherDto>> getTeachers(){
		List<TeacherDto> allTeachers = service.findAllTeachers();
		return new ResponseEntity<>(allTeachers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
		TeacherDto teacherById = service.findTeacherById(id);
		
		return new ResponseEntity(teacherById,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteTeacherById(@PathVariable Long id){
		String status = service.deleteTeacherById(id);
		
		return new ResponseEntity<>(status,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/page")
	public ResponseEntity<List<SchoolDto>> getAllTeachersByPageAndSort(
			@RequestParam(value = "pageNo", defaultValue="0", required = false) int pageNo,
			@RequestParam(value = "size", defaultValue="5",required = false) int size,
			@RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue="ASC", required = false) String sortDir
			){
		Direction dir = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sort = Sort.by(dir, sortBy);
		PageRequest page = PageRequest.of(pageNo, size, sort);
		
		List<TeacherDto> teachers = service.findAllTeachers(page);
		return new ResponseEntity(teachers,HttpStatus.OK);
	}
}
