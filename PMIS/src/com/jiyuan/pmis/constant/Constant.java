package com.jiyuan.pmis.constant;

import java.util.Calendar;

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
	
	public static String getCurrentDataString(int arg){
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int mi = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		if (arg==0){
			
			return new StringBuilder().append(year).append("-")
				.append(month + 1).append("-").append(day).toString();
		}else
		{
			return new StringBuilder().append(year).append("-")
			.append(month + 1).append("-").append(day).append(" ").append(hour).append(":").append(mi).append(":").append(s).toString();
		}
	}
}
