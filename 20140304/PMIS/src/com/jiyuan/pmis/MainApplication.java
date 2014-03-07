package com.jiyuan.pmis;


import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;
import android.app.Application;
import android.widget.Toast;

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
	public String getReportType(String id){
		String bgxmc = "无效报工项";
		for(int i=0;i<this.reportTypes.length;i++){
			if (id.equals(this.reportTypes[i].bgxid))
				bgxmc = this.reportTypes[i].bgxmc;
		}
		return bgxmc;
	}
	public List<ProjectInfo> getAllProjectInfos(){
		DatabaseHandler db = new DatabaseHandler(this.getApplicationContext());
		List<ProjectInfo> list = db.getAllProjectInfos();
		String identifier = "";
		Project[] p = null;
		if (list.size()==0){
			identifier = "-1";
		}else
			identifier = list.get(0).getIdentifier();
		try {
			p = this.getProjects(identifier);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
			return list;
		}
		if (p==null)
			return list;
		for (int i=0;i<p.length;i++){
			ProjectInfo info = new ProjectInfo();
			info.setXmid(p[i].xmid);
			info.setXmjc(p[i].xmjc);
			info.setXmmc(p[i].xmmc);
			info.setIdentifier(p[i].identifier);
			list.add(info);
			if(!db.projectInfoExist(info.getXmid())){
				db.addProjectInfo(info);
			}else
				db.updateProjectInfo(info);
		}
		return list;
	}
	
	private Project[] getProjects(String indentifier) throws PmisException{
		final String METHOD_NAME = "getProjects";
		Soap soap = new Soap(Constant.project_namespace,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("indentifier");
		arg0.setValue(indentifier);
		arg0.setType(String.class);
		args.add(arg0);
		
		/*PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("arg2");
		arg1.setValue(indentifier);
		arg1.setType(String.class);
		args.add(arg1);*/

		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.project_url, Constant.project_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("获取项目列表是失败！");
		}
		if (ret.equals("1")){
			//throw new PmisException("项目列表已最新！");
			return null;
		}
		Gson gson = new Gson();
		try	{
			return gson.fromJson(ret, Project[].class);
		}catch(Exception e){
			throw new PmisException("当前没有项目！");
		}
	}
}
