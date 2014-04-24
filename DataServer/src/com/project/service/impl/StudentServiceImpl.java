package com.project.service.impl;

import java.util.List;

import com.project.dao.StudentDAO;
import com.project.po.Student;
import com.project.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void saveStudent(Student arg0) {
		// TODO Auto-generated method stub
		studentDAO.saveStudent(arg0);
	}

	@Override
	public void deleteStudent(Student arg0) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(arg0);
	}

	@Override
	public void updateStudent(Student arg0) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(arg0);
	}

	@Override
	public Student getStudentById(Integer arg0) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentById(arg0);
	}

	@Override
	public List<Student> getStudentsByHql(String hql) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		return this.studentDAO.getList(hql);
	}

}
