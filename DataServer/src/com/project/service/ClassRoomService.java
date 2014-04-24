package com.project.service;

import java.util.List;

import com.project.po.ClassRoom;

public interface ClassRoomService {
	public void saveClassRoom(ClassRoom arg0);
	public void deleteClassRoom(ClassRoom arg0);
	public void updateClassRoom(ClassRoom arg0);
	public ClassRoom getClassRoomById(Integer arg0);
	public List<ClassRoom> getClassRoomsByHql(String hql);
	@SuppressWarnings("rawtypes")
	public List getList(String hql);
}
