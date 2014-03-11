package com.jiyuan.pmis.sqlite;

public class ProjectInfo {
	final static String key_id = "id";
	final static String table_name = "projectinfo";
	final static String key_xmmc = "xmmc";
	final static String key_xmjc = "xmjc";
	final static String key_xmid = "xmid";
	final static String key_identifier = "identifier";
	private int id;
	private String xmmc;
	private String xmjc;
	private String xmid;
	private String identifier;
	public ProjectInfo(int id, String xmid, String xmjc,
			String xmmc,String identifier) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.xmid = xmid;
		this.xmjc = xmjc;
		this.xmmc = xmmc;
		this.identifier = identifier;
	}
	public ProjectInfo(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getXmjc() {
		return xmjc;
	}
	public void setXmjc(String xmjc) {
		this.xmjc = xmjc;
	}
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
