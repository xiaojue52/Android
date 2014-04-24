package com.project.service.impl;

import java.util.List;

import com.project.dao.CollectCourseDAO;
import com.project.po.CollectCourse;
import com.project.service.CollectCourseService;

public class CollectCourseServiceImpl implements CollectCourseService {

	private CollectCourseDAO collectCourseDAO;
	
	public void setCollectCourseDAO(CollectCourseDAO collectCourseDAO) {
		this.collectCourseDAO = collectCourseDAO;
	}

	@Override
	public void saveCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		collectCourseDAO.saveCollectCourse(arg0);
	}

	@Override
	public void deleteCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		collectCourseDAO.deleteCollectCourse(arg0);
	}

	@Override
	public void updateCollectCourse(CollectCourse arg0) {
		// TODO Auto-generated method stub
		collectCourseDAO.updateCollectCourse(arg0);
	}

	@Override
	public CollectCourse getCollectCourseById(Integer arg0) {
		// TODO Auto-generated method stub
		return collectCourseDAO.getCollectCourseById(arg0);
	}

	@Override
	public List<CollectCourse> getCollectCoursesByHql(String hql) {
		// TODO Auto-generated method stub
		return collectCourseDAO.getCollectCoursesByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		return this.collectCourseDAO.getList(hql);
	}

}
