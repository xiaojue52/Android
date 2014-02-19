package com.jiyuan.pmis.sqlite;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 2;
	final static String DB_NAME = "pmis";
	public DatabaseHandler(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String create_userinfo_table = "CREATE TABLE " + UserInfo.table_name + "("
				+ UserInfo.key_id + " INTEGER PRIMARY KEY," + UserInfo.key_username + " TEXT,"
				+ UserInfo.key_password + " TEXT" + ")";
		
		String create_projectinfo_table = "CREATE TABLE " + ProjectInfo.table_name + "("
				+ ProjectInfo.key_id + " INTEGER PRIMARY KEY," + ProjectInfo.key_xmid + " TEXT,"
				+ ProjectInfo.key_xmjc+ " TEXT," + ProjectInfo.key_xmmc+ " TEXT" + ")";
		db.execSQL(create_userinfo_table);
		db.execSQL(create_projectinfo_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + UserInfo.table_name);
		db.execSQL("DROP TABLE IF EXISTS " + ProjectInfo.table_name);
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	public void addUserInfo(UserInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(UserInfo.key_username, info.getUsername());
		values.put(UserInfo.key_password, info.getPassword());

		// Inserting Row
		db.insert(UserInfo.table_name, null, values);
		db.close(); // Closing database connection
	}
	
	public void addProjectInfo(ProjectInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(ProjectInfo.key_xmjc, info.getXmjc());
		values.put(ProjectInfo.key_xmmc, info.getXmmc());
		values.put(ProjectInfo.key_xmid, info.getXmid());

		// Inserting Row
		db.insert(ProjectInfo.table_name, null, values);
		db.close(); // Closing database connection
	}

	public boolean projectInfoExist(String xmid){
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + ProjectInfo.table_name+" where xmid = '"+xmid+"'";
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()){
			cursor.close();
			db.close();
			//Toast.makeText(context, "有记录！", Toast.LENGTH_SHORT).show();
			return true;
		}
		//Toast.makeText(context, "无记录！", Toast.LENGTH_SHORT).show();
		cursor.close();
		db.close();
		return false;
	}
	
	public ProjectInfo getLastProjectInfo(){
		ProjectInfo info = null;
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + ProjectInfo.table_name+" order by id desc";
		Cursor cursor = db.rawQuery(selectQuery, null);
		if(cursor.moveToFirst()){
			info = new ProjectInfo(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2),cursor.getString(3));
		}
		cursor.close();
		db.close();
		return info;
	}
	public UserInfo getUserInfo(int id) {
		UserInfo info = null;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(UserInfo.table_name, new String[] { UserInfo.key_id, UserInfo.key_username,
				UserInfo.key_password }, UserInfo.key_id + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor.moveToFirst())
			info = new UserInfo(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
		cursor.close();
		db.close();
		return info;
	}
	
	public ProjectInfo getProjectInfo(int id) {
		ProjectInfo info = null;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(ProjectInfo.table_name, new String[] { ProjectInfo.key_id, ProjectInfo.key_xmid,
				ProjectInfo.key_xmjc,ProjectInfo.key_xmmc }, ProjectInfo.key_id + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor.moveToFirst())
			info = new ProjectInfo(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2),cursor.getString(3));
		cursor.close();
		db.close();
		return info;
	}

	public List<UserInfo> getAllUserInfos() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + UserInfo.table_name;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				UserInfo info = new UserInfo();
				info.setId(Integer.parseInt(cursor.getString(0)));
				info.setUsername(cursor.getString(1));
				info.setPassword(cursor.getString(2));
				list.add(info);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return list;
	}
	
	public List<ProjectInfo> getAllProjectInfos() {
		List<ProjectInfo> list = new ArrayList<ProjectInfo>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + ProjectInfo.table_name;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ProjectInfo info = new ProjectInfo();
				info.setId(Integer.parseInt(cursor.getString(0)));
				info.setXmid(cursor.getString(1));
				info.setXmjc(cursor.getString(2));
				info.setXmmc(cursor.getString(3));
				list.add(info);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return list;
	}

	public int updateProjectInfo(ProjectInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(ProjectInfo.key_xmjc, info.getXmjc());
		values.put(ProjectInfo.key_xmmc, info.getXmmc());
		values.put(ProjectInfo.key_xmid, info.getXmid());

		// updating row
		int i = db.update(ProjectInfo.table_name, values, ProjectInfo.key_id + " = ?",
				new String[] { String.valueOf(info.getId()) });
		db.close();
		return i;
	}
	
	public int updateUserInfo(UserInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(UserInfo.key_username, info.getUsername());
		values.put(UserInfo.key_password, info.getPassword());

		// updating row
		int i = db.update(UserInfo.table_name, values, UserInfo.key_id + " = ?",
				new String[] { String.valueOf(info.getId()) });
		db.close();
		return i;
	}


	public void deleteUserInfo(UserInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(UserInfo.table_name, UserInfo.key_id + " = ?",
				new String[] { String.valueOf(info.getId()) });
		db.close();
	}
	
	public void deleteProjectInfo(ProjectInfo info) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(ProjectInfo.table_name, ProjectInfo.key_id + " = ?",
				new String[] { String.valueOf(info.getId()) });
		db.close();
	}

	public int getUserInfosCount() {
		String countQuery = "SELECT  * FROM " + UserInfo.table_name;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();
		cursor.close();
		// return count
		db.close();
		return count;
	}
	
	public int getProjectInfosCount() {
		String countQuery = "SELECT  * FROM " + ProjectInfo.table_name;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();
		cursor.close();
		// return count
		db.close();
		return count;
	}
}
