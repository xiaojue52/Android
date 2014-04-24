package com.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.ClassRoomDAO;
import com.project.po.ClassRoom;

public class ClassRoomDAOImpl extends HibernateDaoSupport implements ClassRoomDAO{

	public void deleteClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(arg0);
	}

	public void saveClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(arg0);
	}

	public void updateClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(arg0);
	}

	@Override
	public ClassRoom getClassRoomById(Integer arg0) {
		
		// TODO Auto-generated method stub	
		return this.getHibernateTemplate().get(ClassRoom.class, arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassRoom> getClassRoomsByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		Query query=this.getSession().createSQLQuery(hql);
		return query.list();
	}

}
