package com.jypmis.ztools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransTimetype {

	/**
	 * String类型转换成TimeStamp型
	 */
	public Timestamp String2Timestamp(String str)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	public String Timestamp2String(Timestamp ts)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
		//Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
		String str="";
		try{
			str = df.format(ts);	
		}catch(Exception e){
			return str;
		}
		//System.out.println(str);
		return str;
	}
	/**
	 * 获取当前的时间
	 * @return
	 */
	public String getCurrentTime()
	{
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(currentTime);
		String str=sd.format(date).toString();
		return str;
	}
	
	public String DateTime2String(Date date)
	{
		//Date转化成String: 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(sdf.format(new Date()));
		String str=sdf.format(date);
		return str;
	}

	public String Date2String(Date date)
	{
		//将日期转成String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
	public java.sql.Date String2Date(String str)
	{
//		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date =fmt.parse(str);
//			//System.out.println(fmt.format(date));
////			fmt.format(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		java.sql.Date date=java.sql.Date.valueOf(str);
		return date;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransTimetype trans=new TransTimetype();
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(currentTime);
		String str=trans.DateTime2String(date);
		Timestamp ts=trans.String2Timestamp(str);
		String str2=trans.Timestamp2String(ts);
		System.out.println(formatter.format(date));
		System.out.println("DateTime2String："+str);
		System.out.println("String2Timestamp:"+ts);
		System.out.println("Timestamp2String:"+str2);
		System.out.println("当前时间"+trans.getCurrentTime());
		System.out.println("Date2String："+trans.Date2String(date));
		System.out.println("string2date:"+trans.String2Date("2012-10-01"));
		System.out.println("日期直接转String："+date.toString());
		
		String a="1";
		String b="0";
		String c="1";
		String d=a+b+c;
		int i=Integer.parseInt(d);
		System.out.println(i);
		
	}

}
