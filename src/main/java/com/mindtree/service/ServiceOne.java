package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.entity.ClassRoom;
import com.mindtree.entity.Student;
import com.mindtree.exception.serviceException.ServiceException;
import com.mindtree.repo.CollegeRepo;
import com.mindtree.repo.StudentRepo;

@org.springframework.stereotype.Service

public class ServiceOne {

	@Autowired
	public CollegeRepo clgRepo;

	public ClassRoom addClassRoom(ClassRoom cr) throws ServiceException {
		try {
			int id = cr.getId();

			ClassRoom em = null;
			em = clgRepo.findById(id);
			System.out.println("value=" + em);

			if (em == null) {
				clgRepo.save(cr);
				return cr;
			} else {
				throw new ServiceException("id already present in database");
			}
		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException("id already present in database");
		}
	}

	@Autowired
	public StudentRepo stdRepo;

	public Student addStudent(Student stu, int id) throws ServiceException {
		try {
			ClassRoom cr = clgRepo.findById(id);
			if (cr != null) {
				Student st = stdRepo.findById(stu.getId());
				if (st == null) {
					stu.setcNumber(cr);
					stdRepo.save(stu);
					return stu;
				} else {
					throw new ServiceException("id already present in database");

				}
			} else {
				throw new ServiceException("class room does not exit");

			}

		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);

		}

	}

	public Student getById(int id) throws ServiceException {
		try {
			Student std = stdRepo.findById(id);

			if (std != null) {
				return std;
			} else {
				throw new ServiceException("student id not found");
			}

		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);

		}

	}

	public Student updateAge(int id, int age) throws ServiceException {
		try {
			Student std = stdRepo.findById(id);
			if (std != null) {
				std.setAge(age);
				stdRepo.save(std);
				return std;
			} else {
				throw new ServiceException("student id not found");
			}

		} catch (ServiceException e) {
			e.getStackTrace();
			throw new ServiceException(e);

		}

	}

}
