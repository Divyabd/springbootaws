package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.ClassRoom;

public interface CollegeRepo extends JpaRepository<ClassRoom,Integer>{
public ClassRoom findById(int id);
}
