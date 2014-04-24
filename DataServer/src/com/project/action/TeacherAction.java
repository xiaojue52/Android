package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Teacher;
import com.project.service.TeacherService;

public class TeacherAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private TeacherService teacherService;
	private List<Teacher> list;
	private Teacher teacher;
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public List<Teacher> getList() {
		return list;
	}
	public void setList(List<Teacher> list) {
		this.list = list;
	}

	public void addTeacherAction(){
		String hql = "from Teacher teacher where teacher.name = '"+teacher.getName()+"'";
		if(this.teacherService.getTeachersByHql(hql).size()>0){
			Constant.flush("-1");
		}else{
			this.teacherService.saveTeacher(teacher);
			Constant.flush("1");
		}
	}
}
