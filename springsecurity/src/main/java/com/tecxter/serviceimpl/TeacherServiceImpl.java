package com.tecxter.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tecxter.dto.TeacherDto;
import com.tecxter.entity.Teacher;
import com.tecxter.exception.ResourceNotFoundException;
import com.tecxter.repository.TeacherRepository;
import com.tecxter.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherRepository teacherRepo;
	
	private ModelMapper mapper;
	
	
	public TeacherServiceImpl(TeacherRepository teacherRepo, ModelMapper mapper) {
		super();
		this.teacherRepo = teacherRepo;
		this.mapper = mapper;
	}

	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		Teacher teacher = teacherRepo.save(mapper.map(teacherDto, Teacher.class));
		return mapper.map(teacher, TeacherDto.class);
	}

	@Override
	public TeacherDto updateTeacher(TeacherDto teacherDto) throws Exception {
		Optional<Teacher> teacher = teacherRepo.findById(teacherDto.getId());
		
		if(teacher.isPresent()) {
			
			Teacher updatedTeacher = teacherRepo.save(mapper.map(teacherDto, Teacher.class));
			return mapper.map(updatedTeacher, TeacherDto.class);
			
		}
		else {
			throw new ResourceNotFoundException(teacherDto.getId());
		}
	}

	@Override
	public String deleteTeacherById(Long id) {

Optional<Teacher> teacher = teacherRepo.findById(id);
		
		if(teacher.isPresent()) {
			
			teacherRepo.deleteById(id);
			return "Teacher Profile Deleted Successfully";
			
		}
		else {
			throw new ResourceNotFoundException(id);
		}
	
	}

	@Override
	public TeacherDto findTeacherById(Long id) {
		Teacher teacher = teacherRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
		return mapper.map(teacher, TeacherDto.class);
	}

	@Override
	public List<TeacherDto> findAllTeachers() {
		List<Teacher> teachers = teacherRepo.findAll();
		
		return teachers.stream().map(teacher -> mapper.map(teacher, TeacherDto.class)).toList();
	}

	@Override
	public List<TeacherDto> findAllTeachers(PageRequest page) {
		Page<Teacher> all = teacherRepo.findAll(page);
		return all.stream().map(t -> mapper.map(t, TeacherDto.class)).toList();
	}

}
