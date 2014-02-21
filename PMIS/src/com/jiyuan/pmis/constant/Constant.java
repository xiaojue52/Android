package com.jiyuan.pmis.constant;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class Constant {
	public static final int REQUEST_CODE = 1;
	public static final int REFUSE_STATUS = 3;
	public static final int PASS_STATUS = 2;
	public static final int WEIT_STATUS = 1;
	public static final int ALL = 0;
	//public static final String NAMESPACE = "http://com.soap";
	//public static final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	public static final String SUCCESS = "1";
	public static final String ERROR = "-1";
	
	private static final String host = "http://192.168.1.37:8000";
	public static final String department_namespace = "http://department.func.jypmis.com";
	public static final String department_url = host+"/JYPMIS/services/Department";
	
	public static final String login_namespace = "http://project.func.jypmis.com";
	public static final String login_url = host+"/JYPMIS/services/Login";
	
	public static final String project_namespace = "http://project.func.jypmis.com";
	public static final String project_url = host+"/JYPMIS/services/Project";
	
	public static final String report_namespace = "http://report.func.jypmis.com";
	public static final String report_url = host+"/JYPMIS/services/Report";
	
	//for test
	/*public static final String department_namespace = "http://com.soap";
	public static final String department_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String login_namespace = "http://com.soap";
	public static final String login_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String project_namespace = "http://com.soap";
	public static final String project_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	
	public static final String report_namespace = "http://com.soap";
	public static final String report_url = "http://192.168.1.17:8080/Soap/services/TestObject";
	*/
	
	@SuppressLint("SimpleDateFormat")
	public static String getCurrentDataString(String format){
		DateFormat df = new SimpleDateFormat(format);
		final Calendar c = Calendar.getInstance();
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
}
