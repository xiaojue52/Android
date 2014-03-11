package com.jypmis.po;

import java.sql.Date;

public class Bbg {
	// Fields

	private String bgid;
	private String bglx;
	private String xmid;
	private String xmjc;// 新增的属性，数据库中无
	private String gzrq;
	private Float gzxs;
	private String gzdd;
	private String gznr;
	private String bgr;
	private String bgsj;
	private String zt;
	private String shr;
	private String shsj;
	private String shxx;

	// Constructors

	/** default constructor */
	public Bbg() {
	}

	/** minimal constructor */
	public Bbg(String bgid) {
		this.bgid = bgid;
	}

	/** full constructor */
	public Bbg(String bgid, String bglx, String xmid, String gzrq, Float gzxs,
			String gzdd, String gznr, String bgr, String bgsj, String zt,
			String shr, String shsj, String shxx) {
		this.bgid = bgid;
		this.bglx = bglx;
		this.xmid = xmid;
		this.gzrq = gzrq;
		this.gzxs = gzxs;
		this.gzdd = gzdd;
		this.gznr = gznr;
		this.bgr = bgr;
		this.bgsj = bgsj;
		this.zt = zt;
		this.shr = shr;
		this.shsj = shsj;
		this.shxx = shxx;
	}

	// Property accessors

	public String getBgid() {
		return this.bgid;
	}

	public void setBgid(String bgid) {
		this.bgid = bgid;
	}

	public String getBglx() {
		return this.bglx;
	}

	public void setBglx(String bglx) {
		this.bglx = bglx;
	}

	public String getXmid() {
		return this.xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getGzrq() {
		return this.gzrq;
	}

	public void setGzrq(String gzrq) {
		this.gzrq = gzrq;
	}

	public Float getGzxs() {
		return this.gzxs;
	}

	public void setGzxs(Float gzxs) {
		this.gzxs = gzxs;
	}

	public String getGzdd() {
		return this.gzdd;
	}

	public void setGzdd(String gzdd) {
		this.gzdd = gzdd;
	}

	public String getGznr() {
		return this.gznr;
	}

	public void setGznr(String gznr) {
		this.gznr = gznr;
	}

	public String getBgr() {
		return this.bgr;
	}

	public void setBgr(String bgr) {
		this.bgr = bgr;
	}

	public String getBgsj() {
		return this.bgsj;
	}

	public void setBgsj(String bgsj) {
		this.bgsj = bgsj;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getShr() {
		return this.shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public String getShsj() {
		return this.shsj;
	}

	public void setShsj(String shsj) {
		this.shsj = shsj;
	}

	public String getShxx() {
		return this.shxx;
	}

	public void setShxx(String shxx) {
		this.shxx = shxx;
	}

	public String getXmjc() {
		return xmjc;
	}

	public void setXmjc(String xmjc) {
		this.xmjc = xmjc;
	}



}
