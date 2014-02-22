package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.setting.SettingActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ReportsManagerActivity extends Activity {
	private ListView reports_manager_listView;
	private Context context;
	private MainApplication app;
	private User user;
	
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_reports_manager);
		this.context = this;
		app = (MainApplication) this.getApplication();
		user = app.getUser();	
	}
	@Override
	protected void onResume(){
		super.onResume();
		try {
			this.initDate();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		this.initListView();
		
	}

	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_LONG).show();
			switch(arg2){
			case 0:
				Intent it0 = new Intent(context,AddReportsActivity.class);
				startActivity(it0);
				break;
			case 1:
				Intent it1 = new Intent(context,MyReportsActivity.class);
				startActivity(it1);
				break;
			case 2:
				Intent it2 = new Intent(context,ReviewReportsActivity.class);
				startActivity(it2);
				break;
			default:
				break;
			}
		}
		
	};
	public void back(View v){
		this.finish();
	}
	public void setting(View v){
		//Toast.makeText(this, "设置界面", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(this,SettingActivity.class);
		startActivity(it);
	}
	
	public void initListView(){
		List<Item> items = new ArrayList<Item>();
		this.reports_manager_listView = (ListView)this.findViewById(R.id.reports_manager_listView);
		String[] values = null;
		String[] description = null;
		if (app.getUser().shqx!=null&&app.getUser().shqx.equals("1")){
			values = new String[] { "新建报工","我的报工", "审核报工"};
			description = new String[] {"创建新的报工","查看我的报工","查看我要审核的报工"};
		}
		else{
			values = new String[] { "新建报工","我的报工"};
			description = new String[] {"创建新的报工","查看我的报工"};
		}
		for (int i=0;i<values.length;i++){
			Item item = new Item();
			item.firstLineText = values[i];
			item.secondLineText = description[i];
			if(i==0)
				item.count = "";
			else if (i==1)
				try {
					item.count = getReportCount("-1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "网络连接错误！", Toast.LENGTH_SHORT).show();
				}
			else if (i==2)
				try {
					item.count = getReportCount("0");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "网络连接错误！", Toast.LENGTH_SHORT).show();
				}
			item.imageRid = R.drawable.ic_launcher;
			item.showCheckbox = false;
			items.add(item);
		}
		
		final SimpleAdapter adapter = new SimpleAdapter(this,
				items);
		this.reports_manager_listView.setAdapter(adapter);
		this.reports_manager_listView.setOnItemClickListener(item_listener);
	}
	
	private void initDate() throws PmisException{
		try{
			this.getReportTypes();
			this.getDepartments();
		}catch(Exception e){
			throw new PmisException("网络连接错误！"); 
		}
	}
	

	private void getReportTypes() throws Exception {
		final String METHOD_NAME = "getReportTypes";
		Soap soap = new Soap(Constant.report_namespace, METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(Constant.report_url, Constant.report_url + "/" + METHOD_NAME);
		Gson gson = new Gson();
		ReportType[] reportTypes = gson.fromJson(ret, ReportType[].class);
		Log.v("pmis", reportTypes[0].bgxid + reportTypes[0].bgxmc);
		app.setReportTypes(reportTypes);
	}

	private void getDepartments() throws Exception {
		final String METHOD_NAME = "getDepartments";
		Soap soap = new Soap(Constant.department_namespace, METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(Constant.department_url, Constant.department_url + "/" + METHOD_NAME);
		Gson gson = new Gson();
		Department[] departments = gson.fromJson(ret, Department[].class);
		Log.v("pmis", departments[0].bmid + departments[0].bmmc);
		app.setDepartments(departments);
	}
	private String getReportCount(String zt) throws Exception {
		final String METHOD_NAME = "getReportCount";
		Soap soap = new Soap(Constant.report_namespace, METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("yhid");
		arg0.setValue(user.yhid);
		arg0.setType(String.class);

		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("zt");
		arg1.setValue(zt);
		arg1.setType(String.class);
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = soap
				.getResponse(Constant.report_url, Constant.report_url + "/" + METHOD_NAME);
		return ret;
	}

}
