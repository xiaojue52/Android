package com.dataclient;

/**
 * 储存全局变量
 */

import java.util.List;

import com.stracture.ClassRoom;

import android.app.Application;

public class MainApplication extends Application{
	private int tag;//0表示学生，1表示老师
	private ClassRoom[] classRooms;
	private String userId;

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public ClassRoom[] getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(ClassRoom[] classRooms) {
		this.classRooms = classRooms;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
