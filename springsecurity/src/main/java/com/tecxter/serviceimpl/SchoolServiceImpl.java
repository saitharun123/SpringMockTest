package com.tecxter.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tecxter.dto.SchoolDto;
import com.tecxter.entity.School;
import com.tecxter.exception.ResourceNotFoundException;
import com.tecxter.repository.SchoolRepository;
import com.tecxter.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	
	private SchoolRepository schoolRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public SchoolServiceImpl(SchoolRepository schoolRepo) {
		super();
		this.schoolRepo = schoolRepo;
	}

	@Override
	public SchoolDto createSchool(SchoolDto schoolDto) {
		School school = schoolRepo.save(mapper.map(schoolDto, School.class));
		return mapper.map(school, SchoolDto.class);
	}

	@Override
	public SchoolDto updateSchool(SchoolDto schoolDto) throws Exception {
		Optional<School> school = schoolRepo.findById(schoolDto.getId());
		
		if(school.isPresent()) {
			
			School updatedSchool = schoolRepo.save(mapper.map(schoolDto, School.class));
			return mapper.map(updatedSchool, SchoolDto.class);
			
		}
		else {
			throw new ResourceNotFoundException(schoolDto.getId());
		}
		
	}

	@Override
	public String deleteSchoolById(Long id) {
		
		Optional<School> school = schoolRepo.findById(id);
		
		if(school.isPresent()) {
			schoolRepo.deleteById(id);
			return "School Deleted Successfully";
			
		}
		else {
			throw new ResourceNotFoundException(id);
		}
		
	}

	@Override
	public SchoolDto findSchoolById(Long id) {
		School school = schoolRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return mapper.map(school, SchoolDto.class);
	}

	@Override
	public List<SchoolDto> findAllSchools() {
		List<School> schools = schoolRepo.findAll();
		
		return schools.stream().map(school -> mapper.map(school, SchoolDto.class)).toList();
	}

	@Override
	public List<SchoolDto> findAllSchools(PageRequest page) {
		Page<School> all = schoolRepo.findAll(page);
		return all.stream().map(school -> mapper.map(school, SchoolDto.class)).toList();
	}

}
