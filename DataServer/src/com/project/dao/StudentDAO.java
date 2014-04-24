package com.project.dao;

import java.util.List;

import com.project.po.Student;

public interface StudentDAO {
	public void saveStudent(Student arg0);
	public void deleteStudent(Student arg0);
	public void updateStudent(Student arg0);
	public Student getStudentById(Integer arg0);
	public List<Student> getStudentsByHql(String hql);
	@SuppressWarnings("rawtypes")
	public List getList(String hql);
}
