package com.abc.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.demo.entity.StudentEntity;

@Service
public interface StudentService {

	List<StudentEntity> findAll();

	void saveAll(List<StudentEntity> student);

}
