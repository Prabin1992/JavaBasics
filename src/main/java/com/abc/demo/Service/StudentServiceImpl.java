package com.abc.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abc.demo.entity.StudentEntity;
import com.abc.demo.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {

	static Map<Long, StudentEntity> studentsDB = new HashMap<>();

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<StudentEntity> findAll() {
		return new ArrayList<>(studentsDB.values());
	}

	@Override
	public void saveAll(List<StudentEntity> student) {
		long nextId = getNextId();
		for (StudentEntity std : student) {
			if (std.getId() == 0) {
				std.setId(nextId++);
			}
		}

	
	
	Map<Long, StudentEntity> studentMap = student.stream()
            .collect(Collectors.toMap(StudentEntity::getId, Function.identity()));

        studentsDB.putAll(studentMap);
	}

	private long getNextId() {
		return studentsDB.keySet().stream().mapToLong(value -> value).max().orElse(0) + 1;
	}
}
