package com.jiyuan.pmis.sqlite;

public class RecentProjectInfo {
	final static String key_id = "id";
	final static String table_name = "rencentprojectinfo";
	final static String key_xmmc = "xmmc";
	final static String key_xmjc = "xmjc";
	final static String key_xmid = "xmid";
	final static String key_identifier = "identifier";
	final static String key_yhid = "yhid";
	final static String key_sj = "sj";
	private int id;
	private String xmmc;
	private String xmjc;
	private String xmid;
	private String identifier;
	private String yhid;
	private String sj;

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public String getSj() {
		return sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public RecentProjectInfo(int id, String xmid, String xmjc, String xmmc,
			String identifier,String yhid,String sj) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.xmid = xmid;
		this.xmjc = xmjc;
		this.xmmc = xmmc;
		this.identifier = identifier;
		this.sj = sj;
		this.yhid = yhid;
	}

	public RecentProjectInfo() {

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
