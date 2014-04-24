package com.project.service;

import java.util.List;

import com.project.po.Teacher;

public interface TeacherService {
	public void saveTeacher(Teacher arg0);
	public void deleteTeacher(Teacher arg0);
	public void updateTeacher(Teacher arg0);
	public Teacher getTeacherById(Integer arg0);
	public List<Teacher> getTeachersByHql(String hql);
}
