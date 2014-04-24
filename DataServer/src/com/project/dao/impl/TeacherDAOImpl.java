package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.TeacherDAO;
import com.project.po.Teacher;

public class TeacherDAOImpl extends HibernateDaoSupport implements TeacherDAO {

	@Override
	public void saveTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(arg0);
	}

	@Override
	public void deleteTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(arg0);
	}

	@Override
	public void updateTeacher(Teacher arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(arg0);
	}

	@Override
	public Teacher getTeacherById(Integer arg0) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Teacher.class, arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getTeachersByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}

}
