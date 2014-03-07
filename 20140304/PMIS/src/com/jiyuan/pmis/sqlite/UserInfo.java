package com.jiyuan.pmis.sqlite;

public class UserInfo {
	final static String key_id = "id";
	final static String table_name = "userinfo";
	final static String key_username = "username";
	final static String key_password = "password";
	private int id;
	private String username;
	private String password;
	public UserInfo(){
		
	}
	public UserInfo(int id,String username,String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public UserInfo(String username,String password){
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
