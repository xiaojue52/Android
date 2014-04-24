package com.project.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.CourseDAO;
import com.project.po.Course;

public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO{

	public void deleteCourse(Course arg0) {
		// TODO Auto-generated method stub
		String sql1 = "delete from data_collect_course where course_id = "+arg0.getId()+";";
		String sql2 = "delete from data_course where id = "+arg0.getId()+";";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Connection conn = session.connection();
		try {
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			conn.setAutoCommit(false);
			stmt1.execute();
			conn.commit();
			stmt2.execute();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}

	public void saveCourse(Course arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(arg0);
	}

	public void updateCourse(Course arg0) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(arg0);
	}

	@Override
	public Course getCourseById(Integer arg0) {
		
		// TODO Auto-generated method stub	
		return this.getHibernateTemplate().get(Course.class, arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCoursesByHql(String hql) {
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
