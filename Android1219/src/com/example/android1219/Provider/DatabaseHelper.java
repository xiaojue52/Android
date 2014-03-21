package com.example.android1219.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static String name = "note";
	private static int version = 11;
	
	public DatabaseHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + Note.table_name + " (" + Note.NOTE_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + Note.TITLE + " VARCHAR(255)," + Note.TEXT + " LONGTEXT" + ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + Note.table_name);
        onCreate(db);
	}
	public int delete(String whereClause,String[] whereArgs){
		SQLiteDatabase db = this.getWritableDatabase();
		int count = db.delete(Note.table_name, whereClause, whereArgs);
		db.close();
		return count;
	}
	public long insert(ContentValues values){
		SQLiteDatabase db = this.getWritableDatabase();
		long rowId = db.insert(Note.table_name, null, values);
		db.close();
		return rowId;
	}
	public int update( ContentValues values, String where, String[] whereArgs){
		SQLiteDatabase db = this.getWritableDatabase();
		int count = db.update(Note.table_name, values, where, whereArgs);
		db.close();
		return count;
	}
}
