package com.example.android1219.sql;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private static final int version = 1;
	private static final String name = "test";

	public DBHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String create_student_table = "create table "+Student.table_name+"("+Student.key_id+" integer primary key,"+Student.key_name+" text,"+Student.key_score+" text)";
		db.execSQL(create_student_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String drop_student_table = "drop table if exists "+Student.table_name;
		db.execSQL(drop_student_table);
	}
	public void insert(Student student){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Student.key_name, student.getName());
		values.put(Student.key_score, student.getScore());
		db.insert(Student.table_name, null, values);
		db.close(); 
	}
	public Student show(int id){
		Student info = null;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(Student.table_name, new String[] { Student.key_id, Student.key_name,
				Student.key_score }, Student.key_id + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor.moveToFirst()){
			info = new Student();
			info.setId(Integer.valueOf(cursor.getString(0)));
			info.setName(cursor.getString(1));
			info.setScore(cursor.getString(2));
		}
		cursor.close();
		db.close();
		return info;
	}
	public void delete(int id){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(Student.table_name, Student.key_id + " = ?",
				new String[] { String.valueOf(id) });
		db.close();
	}
	public void update(Student student){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Student.key_name, student.getName());
		values.put(Student.key_score, student.getScore());
		// updating row
		db.update(Student.table_name, values, Student.key_id + " = ?",
				new String[] { String.valueOf(student.getId()) });
		db.close();
	}
	public void clear(){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DELETE FROM "+Student.table_name);
		db.close();
	}
	public List<Object> getCustomizeObject(){
		List<Object> list = new ArrayList<Object>();
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "select student.id,student.name,student.score from "+Student.table_name+" student order by "+Student.key_score;
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToFirst()){
			do{
				Student student = new Student();
				student.setId(Integer.valueOf(cursor.getString(0)));
				student.setName(cursor.getString(1));
				student.setScore(cursor.getString(2));
				list.add(student);
			}while(cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return list;
	}

}
