package com.abc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.demo.entity.StudentEntity;
import com.abc.demo.repository.StudentRepository;

@RestController
public class StudentController {
@Autowired StudentRepository studentRepository;
	

@PostMapping("/student")
public StudentEntity createStudent(@RequestBody StudentEntity student) {
    return studentRepository.save(student);
}

@GetMapping("/student/{id}")
public Optional<StudentEntity> getStudent(@PathVariable(value = "id") Long id) {
    return studentRepository.findById(id);
            
}

@DeleteMapping("/student/{id}")
public void deleteStudent(@PathVariable Long id) {
	studentRepository.deleteById(id);
}

@PutMapping("/student/{id}")
public ResponseEntity<Object> updateStudent(@RequestBody StudentEntity student, @PathVariable Long id) {

	Optional<StudentEntity> studentOptional = studentRepository.findById(id);

	if (!studentOptional.isPresent())
		return ResponseEntity.notFound().build();

	student.setId(id);
	
	studentRepository.save(student);

	return ResponseEntity.noContent().build();
}

}
