package com.jypmis.func.project;

import java.util.List;

import com.jypmis.po.Bxmjbxx;

public interface IProject {
	
	/**
	 * 部门项目信息，手机端接口函数
	 * @param departmentid
	 * @return
	 */
	public String getDepartmentProjects(String departmentid);
	
	/**
	 * 查询部门项目信息
	 * @param departmentid
	 * @return
	 */
	public List<Bxmjbxx>findDepartmentProjects(String departmentid);
	
	/**
	 * 项目信息，手机端接口函数
	 * @param departmentid
	 * @param projectName
	 * @return
	 */
	public String getProjects(String identifier);
	
	/**
	 * 查询项目基本信息，项目名称支持模糊查询
	 * @param departmentid
	 * @param projectName
	 * @return
	 */
	public List<Bxmjbxx>findProjects(String departmentid,String projectName);
}