package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.jiyuan.pmis.reports.ReportsManagerActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	//private final String NAMESPACE = "http://login.user.pmis.com";
	//private final String URL = "http://192.168.1.101:8000/PMIS/services/Login";
	MainApplication app;
	private User user = new User();
	private final String NAMESPACE = "http://com.soap";
	private final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		app = (MainApplication) this.getApplication();
	}

	public void login(View v){
		EditText username_et = (EditText)this.findViewById(R.id.username_et);
		EditText password_et = (EditText)this.findViewById(R.id.password_et);
		String username = username_et.getText().toString();
		String password = password_et.getText().toString();
		if (username.length()==0||password.length()==0){
			Toast.makeText(context, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
			return;
		}
		Soap soap = new Soap(NAMESPACE, "login");
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("username");
		arg0.setValue(username);
		arg0.setType(String.class);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("password");
		arg1.setValue(password);
		arg1.setType(String.class);
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = null;
		try{
			ret = soap.getResponse(URL, URL+"/login");
		}catch(Exception e){
			//todo处理异常
			e.printStackTrace();
			return;
		}
		if (ret!=null){
			Log.v("pmis", ret);
			this.saveUser(ret);
			try {
				this.initData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int wait_count = getReportCount("0");
			int refuse_count = getReportCount("-1");
			Intent it = new Intent(context,ReportsManagerActivity.class);
			it.putExtra("wait_count", wait_count);
			it.putExtra("refuse_count", refuse_count);
			Log.v("pmis",wait_count+"...."+refuse_count);
			startActivity(it);
		}else
			Toast.makeText(context, "用户名或密码错误，请重新输入！", Toast.LENGTH_LONG).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void saveUser(String userStr){
		JsonParser parser = new JsonParser();
		String yhid = parser.parse(userStr).getAsJsonObject().get("yhid").getAsString();
		//System.out.println(yhid);
		String bmid = parser.parse(userStr).getAsJsonObject().get("bmid").getAsString();
		user.yhid = yhid;
		user.bmid = bmid;
		app.setUser(user);
	}	

	private int getReportCount(String zt){
		final String METHOD_NAME = "getReportCount";
		Soap soap = new Soap(NAMESPACE, METHOD_NAME);
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
		int ret = -1;
		try {
			ret = Integer.valueOf(soap.getResponse(URL, URL+"/"+METHOD_NAME));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return ret;
	}
	
	private void getReportTypes() throws Exception{
		final String METHOD_NAME = "getReportTypes";
		Soap soap = new Soap(this.NAMESPACE,METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(this.URL, this.URL+"/"+METHOD_NAME);
		Gson gson = new Gson();
		ReportType[] reportTypes = gson.fromJson(ret, ReportType[].class);
		Log.v("pmis",reportTypes[0].bgxid+reportTypes[0].bgxmc);
		app.setReportTypes(reportTypes);
	}
	
	private void getDepartments() throws Exception{
		final String METHOD_NAME = "getDepartments";
		Soap soap = new Soap(this.NAMESPACE,METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(this.URL, this.URL+"/"+METHOD_NAME);
		Gson gson = new Gson();
		Department[] departments = gson.fromJson(ret, Department[].class);
		Log.v("pmis",departments[0].bmid+departments[0].bmmc);
		app.setDepartments(departments);
	}
	private void initData() throws Exception{
		this.getReportTypes();
		this.getDepartments();
	}
}
