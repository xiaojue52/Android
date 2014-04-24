package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Student;
import com.project.service.StudentService;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private StudentService studentService;
	private List<Student> list;
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String listStudentsAction(){
		String hql = "from Student student";
		list = this.studentService.getStudentsByHql(hql);
		return SUCCESS;
	}
	
	public void addStudentAction(){
		String hql = "from Student obj where obj.name = '"+student.getName()+"'";
		if(this.studentService.getStudentsByHql(hql).size()>0){
			Constant.flush("-1");
		}else{
			this.studentService.saveStudent(student);
			Constant.flush("1");
		}
	}
}
