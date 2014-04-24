package com.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.CollectCourseDAO;
import com.project.po.CollectCourse;

public class CollectCourseDAOImpl extends HibernateDaoSupport implements CollectCourseDAO{

	public void deleteCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(arg0);
	}

	public void saveCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(arg0);
	}

	public void updateCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(arg0);
	}

	@Override
	public CollectCourse getCollectCourseById(Integer arg0) {
		
		// TODO Auto-generated method stub	
		return this.getHibernateTemplate().get(CollectCourse.class, arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CollectCourse> getCollectCoursesByHql(String hql) {
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
