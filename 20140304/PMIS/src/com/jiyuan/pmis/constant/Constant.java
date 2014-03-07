package com.jiyuan.pmis.constant;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class Constant {
	public static final int REQUEST_CODE = 1;
	public static final int MY_REPORT_REQUEST_CODE = 2;
	public static final int REVIEW_REPORT_REQUEST_CODE = 3;
	//public static final int REFUSE_STATUS = 3;
	//public static final int PASS_STATUS = 2;
	//public static final int WEIT_STATUS = 1;
	//public static final int ALL = 0;
	//public static final String NAMESPACE = "http://com.soap";
	//public static final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	public static final String SUCCESS = "1";
	public static final String ERROR = "-1";
	
	
	public static String host = "192.168.1.101:8080";
	public static String projectName = "JYPMIS";
	public static final String department_namespace = "http://department.func.jypmis.com";
	public static final String department_url = "http://"+host+"/"+projectName+"/services/Department";
	
	public static final String login_namespace = "http://project.func.jypmis.com";
	public static final String login_url = "http://"+host+"/"+projectName+"/services/Login";
	
	public static final String project_namespace = "http://project.func.jypmis.com";
	public static final String project_url = "http://"+host+"/"+projectName+"/services/Project";
	
	public static final String report_namespace = "http://report.func.jypmis.com";
	public static final String report_url = "http://"+host+"/"+projectName+"/services/Report";
	
	//for test
	/*public static final String department_namespace = "http://com.soap";
	public static final String department_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String login_namespace = "http://com.soap";
	public static final String login_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String project_namespace = "http://com.soap";
	public static final String project_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String report_namespace = "http://com.soap";
	public static final String report_url = "http://192.168.1.17:8080/Soap/services/TestObject";*/
	
	
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
}
