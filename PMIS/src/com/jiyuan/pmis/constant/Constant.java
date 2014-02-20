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
	public static final String NAMESPACE = "http://com.soap";
	public static final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	public static final String SUCCESS = "1";
	public static final String ERROR = "-1";
	
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
}
