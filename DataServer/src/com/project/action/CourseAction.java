package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.Course;
import com.project.service.CourseService;

public class CourseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private CourseService courseService;
	private List<Course> list;
	private Course course;
	private String idList;

	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void addCourseAction(){
		this.courseService.saveCourse(course);
		Constant.flush(1);
	}
	
	public void showCourseAction(){
		Course arg = this.courseService.getCourseById(course.getId());
		Constant.flush(arg);
	}
	public void deleteCourseAction(){
		String[] list = new Gson().fromJson(this.idList, String[].class);
		for (int i=0;i<list.length;i++){
			Course course = new Course();
			course.setId(Integer.valueOf(list[i]));
			this.courseService.deleteCourse(course);
		}
		Constant.flush(1);
	}
	
	public void updateCourseAction(){
		this.courseService.updateCourse(course);
		Constant.flush(1);
	}
	public void listCoursesAction(){
		String hql = "from Course obj";
		this.list = this.courseService.getCoursesByHql(hql);
		Constant.flush(this.list);
	}
}
