package com.jiyuan.pmis;

import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;

import android.app.Application;

public class MainApplication extends Application{
	private User user;
	private ReportType[] reportTypes;
	private Department[] departments;
	@Override
	public void onCreate(){
		super.onCreate();
	}
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return this.user;
	}
	public ReportType[] getReportTypes() {
		return reportTypes;
	}
	public void setReportTypes(ReportType[] reportTypes) {
		this.reportTypes = reportTypes;
	}
	public Department[] getDepartments() {
		return departments;
	}
	public void setDepartments(Department[] departments) {
		this.departments = departments;
	}
}
