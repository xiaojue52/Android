package com.jiyuan.pmis.constant;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jiyuan.pmis.structure.ServerInfo;

@SuppressLint("SimpleDateFormat")
public class Constant {
	public static final int REQUEST_CODE = 1;
	public static final int MY_REPORT_REQUEST_CODE = 2;
	public static final int REVIEW_REPORT_REQUEST_CODE = 3;
	public static final String SUCCESS = "1";
	public static final String ERROR = "-1";
	public static String host = "115.29.16.108:80";
	public static String projectName = "JYPMIS";
	public static String department_namespace = "http://department.func.jypmis.com";
	public static String department_url = "http://"+host+"/"+projectName+"/services/Department";
	public static String login_namespace = "http://project.func.jypmis.com";
	public static String login_url = "http://"+host+"/"+projectName+"/services/Login";
	public static String project_namespace = "http://project.func.jypmis.com";
	public static String project_url = "http://"+host+"/"+projectName+"/services/Project";
	
	public static String report_namespace = "http://report.func.jypmis.com";
	public static String report_url = "http://"+host+"/"+projectName+"/services/Report";
	
	
	public static void configServer(ServerInfo serverInfo){
		host = serverInfo.server_addr+":"+serverInfo.server_port;
		department_url = "http://"+host+"/"+projectName+"/services/Department";
		login_url = "http://"+host+"/"+projectName+"/services/Login";
		project_url = "http://"+host+"/"+projectName+"/services/Project";
		report_url = "http://"+host+"/"+projectName+"/services/Report";
	}
	
	@SuppressLint("SimpleDateFormat")
	public static String getCurrentDataString(String format){
		DateFormat df = new SimpleDateFormat(format);
		final Calendar c = Calendar.getInstance();
		Date date = c.getTime();	
		return df.format(date);
	}
	public static String getBeforeCurrentDataString(String format,int day){
		DateFormat df = new SimpleDateFormat(format);
		final Calendar c = Calendar.getInstance();
		int d = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, d-day);
		Date date = c.getTime();	
		return df.format(date);
	}
	public static String toDateString(Date date, String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	public static String doCode(String arg){
		char[] array = arg.toCharArray();
		String str = "";
		for(int i=0;i<array.length;i++){
			char ch = (char) (array[i]+10);
			str+=ch;
		}
		return str;
	}
	public static String deCode(String arg){
		char[] array = arg.toCharArray();
		String str = "";
		for(int i=0;i<array.length;i++){
			char ch = (char) (array[i]-10);
			str+=ch;
		}
		return str;
	}
	
	public static void selectDate(Context context,final TextView v) {
		// new DateLayout(this.context,this.getView(),v);
		Calendar c = Calendar.getInstance();
		
		new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener(){

			@Override
			public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				//Toast.makeText(context, arg1+";"+arg2+";"+arg3, Toast.LENGTH_SHORT).show();
				Calendar ca = Calendar.getInstance();
				ca.set(Calendar.YEAR, arg1);
				ca.set(Calendar.MONTH, arg2);
				ca.set(Calendar.DAY_OF_MONTH, arg3);
				v.setText(Constant.toDateString(ca.getTime(), "yyyy-MM-dd"));
			}
			
		}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
	}
	
	public static final String server_identifier = "server_identifier";
	public static void saveServerInfo(ServerInfo serverInfo,Context context){

		SharedPreferences settings = context.getSharedPreferences(server_identifier, 0);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putString(ServerInfo.server_addr_key, serverInfo.server_addr);
	    editor.putString(ServerInfo.server_port_key, serverInfo.server_port);
	      // Commit the edits!
	    editor.commit();
	    configServer(serverInfo);
	}
	public static ServerInfo getServerInfo(Context context){
		SharedPreferences settings = context.getSharedPreferences(server_identifier, 0);
		ServerInfo serverInfo = new ServerInfo();
		serverInfo.server_addr = settings.getString(ServerInfo.server_addr_key, "115.29.16.108");
		serverInfo.server_port = settings.getString(ServerInfo.server_port_key, "8080");
		return serverInfo;
	}
	
	public static String getCurVersion(Context ctx) {
		try {
			PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(
					ctx.getPackageName(), 0);
			//curVersion = pInfo.versionName;
			//curVersionCode = pInfo.versionCode;
			return pInfo.versionName;
		} catch (NameNotFoundException e) {
			//Log.e("update", e.getMessage());
			//curVersion = "1.1.1000";
			//curVersionCode = 111000;
			return "1.0";
		}

	}
}
