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
import com.tecxter.service.SchoolService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

	@Autowired
	private SchoolService service;


	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	private ResponseEntity<SchoolDto> createSchool(@Valid @RequestBody SchoolDto schoolDto) {
		SchoolDto school = service.createSchool(schoolDto);
		return new ResponseEntity<SchoolDto>(school,HttpStatus.CREATED);
	}
	
	public SchoolController(SchoolService service) {
		super();
		this.service = service;
	}

	@PutMapping("/update")
	private ResponseEntity<SchoolDto> updateSchool(@Valid @RequestBody SchoolDto schoolDto) throws Exception {
		SchoolDto updateSchool = service.updateSchool(schoolDto);
		return new ResponseEntity(updateSchool,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	private ResponseEntity<List<SchoolDto>> getSchools(){
		List<SchoolDto> allSchools = service.findAllSchools();
		return new ResponseEntity<>(allSchools,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<SchoolDto> getSchoolById(@PathVariable Long id){
		SchoolDto schoolById = service.findSchoolById(id);
		
		return new ResponseEntity<SchoolDto>(schoolById,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteSchoolById(@PathVariable Long id){
		String status = service.deleteSchoolById(id);
		
		return new ResponseEntity<>(status,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/page")
	public ResponseEntity<List<SchoolDto>> getAllSchoolsByPageAndSort(
			@RequestParam(value = "pageNo", defaultValue="0", required = false) int pageNo,
			@RequestParam(value = "size", defaultValue="5",required = false) int size,
			@RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue="ASC", required = false) String sortDir
			){
		Direction dir = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sort = Sort.by(dir, sortBy);
		PageRequest page = PageRequest.of(pageNo, size, sort);
		
		List<SchoolDto> allSchools = service.findAllSchools(page);
		return new ResponseEntity(allSchools,HttpStatus.OK);
	}
}
