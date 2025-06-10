package com.tecxter.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tecxter.dto.SchoolDto;


public interface SchoolService {

	SchoolDto createSchool(SchoolDto schoolDto);
	
	SchoolDto updateSchool(SchoolDto schoolDto) throws Exception;
	
	String deleteSchoolById(Long id);
	
	SchoolDto findSchoolById(Long id);

	List<SchoolDto> findAllSchools();
	
	List<SchoolDto> findAllSchools(PageRequest page);
}
