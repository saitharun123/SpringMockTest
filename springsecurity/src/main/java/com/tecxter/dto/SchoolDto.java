package com.tecxter.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {
	
   private Long id;
   private String schoolName;
   private String district;
   private List<TeacherDto> teachers;
   
}
