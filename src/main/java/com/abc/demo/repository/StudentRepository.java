package com.abc.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long> {

	
}
