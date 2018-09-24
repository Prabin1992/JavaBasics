package com.abc.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.abc.demo.entity.StudentEntity;

public class StudentCreationDto {

	private List<StudentEntity> students;

	public StudentCreationDto() {
		this.students = new ArrayList<>();

	}

	public StudentCreationDto(List<StudentEntity> students) {
		super();
		this.students = students;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public void addStudents(StudentEntity student) {
		this.students.add(student);
	}

}
