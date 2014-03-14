package com.example.android1219.sql;

public class Student {

	public static String table_name = "student";
	public static String key_id = "id";
	public static String key_name = "name";
	public static String key_score = "score";
	private int id;
	private String name;
	private String score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
