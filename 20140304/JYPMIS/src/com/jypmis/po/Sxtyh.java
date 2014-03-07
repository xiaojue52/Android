package com.jypmis.po;

/**
 * 用户基本信息
 * 主键：yhid
 * 外键：bmid gwid wbdwid
 */
public class Sxtyh {

	// Fields

	private String yhid;
	private String bmid;
	private String gwid;
	private String wbdwid;
	private String yhxm;
	private String sjhm;
	private String dlkl;
	private String zt;
	private String bz;
	
	/*
	 * 新增加审核权限
	 */
	private String shqx;

	public String getShqx() {
		return shqx;
	}

	public void setShqx(String shqx) {
		this.shqx = shqx;
	}

	/** default constructor */
	public Sxtyh() {
	}

	/** minimal constructor */
	public Sxtyh(String yhid, String bmid, String gwid) {
		this.yhid = yhid;
		this.bmid = bmid;
		this.gwid = gwid;
	}

	/** full constructor */
	public Sxtyh(String yhid, String bmid, String gwid, String wbdwid, String yhxm,
			String sjhm, String dlkl, String zt, String bz, String shqx) {
		this.yhid = yhid;
		this.bmid=bmid;
		this.gwid=gwid;
		this.wbdwid=wbdwid;
		this.yhxm = yhxm;
		this.sjhm = sjhm;
		this.dlkl = dlkl;
		this.zt = zt;
		this.bz = bz;	
		this.shqx = shqx;
	}

	public String getYhid() {
		return this.yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getGwid() {
		return gwid;
	}

	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	public String getWbdwid() {
		return wbdwid;
	}

	public void setWbdwid(String wbdwid) {
		this.wbdwid = wbdwid;
	}

	public String getYhxm() {
		return this.yhxm;
	}

	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}

	public String getSjhm() {
		return this.sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	public String getDlkl() {
		return this.dlkl;
	}

	public void setDlkl(String dlkl) {
		this.dlkl = dlkl;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}