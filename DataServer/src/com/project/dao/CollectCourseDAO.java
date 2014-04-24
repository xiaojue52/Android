package com.project.dao;

import java.util.List;

import com.project.po.CollectCourse;

public interface CollectCourseDAO {
	public void saveCollectCourse(CollectCourse arg0);
	public void deleteCollectCourse(CollectCourse arg0);
	public void updateCollectCourse(CollectCourse arg0);
	public CollectCourse getCollectCourseById(Integer arg0);
	public List<CollectCourse> getCollectCoursesByHql(String hql);
	@SuppressWarnings("rawtypes")
	public List getList(String hql);
}
