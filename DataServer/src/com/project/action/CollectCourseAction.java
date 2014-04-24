package com.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constant.Constant;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.project.po.CollectCourse;
import com.project.po.Course;
import com.project.service.CollectCourseService;

public class CollectCourseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482287939244643007L;
	
	private CollectCourseService collectCourseService;
	private List<CollectCourse> list;
	private CollectCourse collectCourse;
	private String idList;
	

	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public CollectCourseService getCollectCourseService() {
		return collectCourseService;
	}

	public void setCollectCourseService(CollectCourseService collectCourseService) {
		this.collectCourseService = collectCourseService;
	}

	public List<CollectCourse> getList() {
		return list;
	}

	public void setList(List<CollectCourse> list) {
		this.list = list;
	}

	public CollectCourse getCollectCourse() {
		return collectCourse;
	}

	public void setCollectCourse(CollectCourse collectCourse) {
		this.collectCourse = collectCourse;
	}

	public void addCollectCourseAction(){
		this.collectCourseService.saveCollectCourse(collectCourse);
		Constant.flush(1);
	}
	public void deleteCollectCourseAction(){
		String[] list = new Gson().fromJson(this.idList, String[].class);
		for (int i=0;i<list.length;i++){
			CollectCourse collectCourse = new CollectCourse();
			collectCourse.setId(Integer.valueOf(list[i]));
			this.collectCourseService.deleteCollectCourse(collectCourse);
		}
		Constant.flush(1);
	}
	public void showCollectCourseAction(){
		
	}
	public void updateCollectCourseAction(){
		
	}
	public void listCollectCoursesAction(){
		String hql = "from CollectCourse obj";
		this.list = this.collectCourseService.getCollectCoursesByHql(hql);
		Constant.flush(this.list);
	}
}
