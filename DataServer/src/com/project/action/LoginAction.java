package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Student;
import com.project.po.Teacher;
import com.project.service.StudentService;
import com.project.service.TeacherService;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tag = 0;
	private TeacherService teacherService;
	private StudentService studentService;
	private String name;
	private String password;
	
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(){
		System.out.println(tag+"...."+name+"...."+password);
		int data = -1;
		if(tag==0){
			String hql = "from Student obj where obj.name = '"+name+"' and obj.password = '"+password+"'";
			List<Student> list = this.studentService.getStudentsByHql(hql);
			if(list.size()>0){
				data = list.get(0).getId();
			}else
			{
				data = -1;
			}
		}else{
			String hql = "from Teacher obj where obj.name = '"+name+"' and obj.password = '"+password+"'";
			List<Teacher> list = this.teacherService.getTeachersByHql(hql);
			if(list.size()>0){
				data = list.get(0).getId();
			}else
			{
				data = -1;
			}
		}
		Constant.flush(data);
	}
}
