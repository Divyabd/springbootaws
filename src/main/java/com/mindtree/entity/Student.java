package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity

public class Student {
	
	@Id
	private int id;
	private String name;
	private int age;
	@OneToOne
	private ClassRoom cNumber;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int age, ClassRoom cNumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.cNumber = cNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ClassRoom getcNumber() {
		return cNumber;
	}
	public void setcNumber(ClassRoom cNumber) {
		this.cNumber = cNumber;
	}
	

}
