package com.project.dao;

import java.util.List;

import com.project.po.Course;

public interface CourseDAO {
	public void saveCourse(Course arg0);
	public void deleteCourse(Course arg0);
	public void updateCourse(Course arg0);
	public Course getCourseById(Integer arg0);
	public List<Course> getCoursesByHql(String hql);
	@SuppressWarnings("rawtypes")
	public List getList(String hql);
}
