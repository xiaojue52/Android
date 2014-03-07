	package com.jypmis.po;

	/**
	 * 部门信息
	 *
	 */
	public class Sbm {
	
		// Fields
	
		private String bmid;
		private String bmmc;
		private String bmjc;
		private String bmlx;
		private String zt;
		private String bz;
	
		// Constructors
	
		/** default constructor */
		public Sbm() {
		}
	
		/** minimal constructor */
		public Sbm(String bmid, String bmmc, String bmjc, String bmlx) {
			this.bmid = bmid;
			this.bmmc = bmmc;
			this.bmjc = bmjc;
			this.bmlx = bmlx;
		}
	
		/** full constructor */
		public Sbm(String bmid, String bmmc, String bmjc, String bmlx, String zt,
				String bz) {
			this.bmid = bmid;
			this.bmmc = bmmc;
			this.bmjc = bmjc;
			this.bmlx = bmlx;
			this.zt = zt;
			this.bz = bz;
		}
	
		public String getBmid() {
			return this.bmid;
		}
	
		public void setBmid(String bmid) {
			this.bmid = bmid;
		}
	
		public String getBmmc() {
			return this.bmmc;
		}
	
		public void setBmmc(String bmmc) {
			this.bmmc = bmmc;
		}
	
		public String getBmjc() {
			return this.bmjc;
		}
	
		public void setBmjc(String bmjc) {
			this.bmjc = bmjc;
		}
	
		public String getBmlx() {
			return this.bmlx;
		}
	
		public void setBmlx(String bmlx) {
			this.bmlx = bmlx;
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