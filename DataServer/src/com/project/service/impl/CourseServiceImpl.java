package com.project.service.impl;

import java.util.List;

import com.project.dao.CourseDAO;
import com.project.po.Course;
import com.project.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDAO;
	
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public void saveCourse(Course arg0) {
		// TODO Auto-generated method stub
		courseDAO.saveCourse(arg0);
	}

	@Override
	public void deleteCourse(Course arg0) {
		// TODO Auto-generated method stub
		courseDAO.deleteCourse(arg0);
	}

	@Override
	public void updateCourse(Course arg0) {
		// TODO Auto-generated method stub
		courseDAO.updateCourse(arg0);
	}

	@Override
	public Course getCourseById(Integer arg0) {
		// TODO Auto-generated method stub
		return courseDAO.getCourseById(arg0);
	}

	@Override
	public List<Course> getCoursesByHql(String hql) {
		// TODO Auto-generated method stub
		return courseDAO.getCoursesByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		return this.courseDAO.getList(hql);
	}

}
