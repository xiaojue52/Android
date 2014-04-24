package com.project.service.impl;

import java.util.List;

import com.project.dao.ClassRoomDAO;
import com.project.po.ClassRoom;
import com.project.service.ClassRoomService;

public class ClassRoomServiceImpl implements ClassRoomService {

	private ClassRoomDAO classRoomDAO;
	
	public void setClassRoomDAO(ClassRoomDAO classRoomDAO) {
		this.classRoomDAO = classRoomDAO;
	}

	@Override
	public void saveClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		classRoomDAO.saveClassRoom(arg0);
	}

	@Override
	public void deleteClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		classRoomDAO.deleteClassRoom(arg0);
	}

	@Override
	public void updateClassRoom(ClassRoom arg0) {
		// TODO Auto-generated method stub
		classRoomDAO.updateClassRoom(arg0);
	}

	@Override
	public ClassRoom getClassRoomById(Integer arg0) {
		// TODO Auto-generated method stub
		return classRoomDAO.getClassRoomById(arg0);
	}

	@Override
	public List<ClassRoom> getClassRoomsByHql(String hql) {
		// TODO Auto-generated method stub
		return classRoomDAO.getClassRoomsByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		return this.classRoomDAO.getList(hql);
	}

}
