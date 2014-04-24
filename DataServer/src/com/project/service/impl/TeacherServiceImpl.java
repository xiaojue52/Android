package com.project.service.impl;

import java.util.List;

import com.project.dao.TeacherDAO;
import com.project.po.Teacher;
import com.project.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	private TeacherDAO teacherDAO;
	
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void saveTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		teacherDAO.saveTeacher(arg0);
	}

	@Override
	public void deleteTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		teacherDAO.deleteTeacher(arg0);
	}

	@Override
	public void updateTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		teacherDAO.updateTeacher(arg0);
	}

	@Override
	public Teacher getTeacherById(Integer arg0) {
		// TODO Auto-generated method stub
		return teacherDAO.getTeacherById(arg0);
	}

	@Override
	public List<Teacher> getTeachersByHql(String hql) {
		// TODO Auto-generated method stub
		return teacherDAO.getTeachersByHql(hql);
	}

}
