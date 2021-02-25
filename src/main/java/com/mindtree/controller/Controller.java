package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.entity.ClassRoom;
import com.mindtree.entity.Student;
import com.mindtree.exception.serviceException.ServiceException;
import com.mindtree.service.ServiceOne;

@RestController
@RequestMapping(path = "/student")
public class Controller {

	@Autowired
	public ServiceOne srv;

	@PostMapping("/cinsert")
	public ResponseEntity<?> addClassRoom(@RequestBody ClassRoom cr) {
		String s;
		try {
			srv.addClassRoom(cr);
			return new ResponseEntity<>("succesfully added\n" + cr, HttpStatus.CREATED);
		} catch (ServiceException e) {
			System.out.println("Controller error" + e);
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/sinsert/{id}")
	public ResponseEntity<?> addStudent(@RequestBody Student stu, @PathVariable("id") int id) {
		String s;
		try {

			Student details = srv.addStudent(stu, id);
			return new ResponseEntity<>(details, HttpStatus.CREATED);
		} catch (ServiceException e) {
			s = e + " ";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		String s;
		try {

			Student details = srv.getById(id);
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (ServiceException e) {
			s = e + "error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update/{id}/{age}")
	public ResponseEntity<?> updateAge(@PathVariable("id") int id, @PathVariable("age") int age) {
		String s;
		try {

			Student update = srv.updateAge(id, age);
			return new ResponseEntity<>(update, HttpStatus.CREATED);
		} catch (ServiceException e) {
			s = e + "  error";
		}

		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}
}
