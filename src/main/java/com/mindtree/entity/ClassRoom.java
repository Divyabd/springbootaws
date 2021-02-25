package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class ClassRoom {

	@Id

	private int id;;
	private String name;
	private int numOfStudents;

	public ClassRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(int id, String name, int numOfStudents) {
		super();
		this.id = id;
		this.name = name;
		this.numOfStudents = numOfStudents;
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

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

}
