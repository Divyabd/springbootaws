package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	public Student findById(int id);
	
}
