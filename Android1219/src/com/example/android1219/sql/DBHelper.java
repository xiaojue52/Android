package com.example.android1219.sql;

import android.content.Context;
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


}
