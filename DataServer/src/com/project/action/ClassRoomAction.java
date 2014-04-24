package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.ClassRoom;
import com.project.service.ClassRoomService;

public class ClassRoomAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private ClassRoomService classRoomService;
	private List<ClassRoom> list;
	private ClassRoom classRoom;
	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}
	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}
	public List<ClassRoom> getList() {
		return list;
	}
	public void setList(List<ClassRoom> list) {
		this.list = list;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	public void addClassRoomAction(){
		this.classRoomService.saveClassRoom(classRoom);
	}
	public void listClassRoomsAction(){
		String hql = "from ClassRoom obj";
		this.list = this.classRoomService.getClassRoomsByHql(hql);
		Constant.flush(this.list);
	}
}
