package com.jypmis.po;

/**
 * 报工项
 * 报工里面的报工类型从该表选择
 *
 */
public class Sbgx {
    // Fields    

    private String bgxid;
    private String bgxmc;
    private String glbm;
    private String zt;


   // Constructors

   /** default constructor */
   public Sbgx() {
   }

	/** minimal constructor */
   public Sbgx(String bgxid) {
       this.bgxid = bgxid;
   }
   
   /** full constructor */
   public Sbgx(String bgxid, String bgxmc, String glbm, String zt) {
       this.bgxid = bgxid;
       this.bgxmc = bgxmc;
       this.glbm = glbm;
       this.zt = zt;
   }

   public String getBgxid() {
       return this.bgxid;
   }
   
   public void setBgxid(String bgxid) {
       this.bgxid = bgxid;
   }

   public String getBgxmc() {
       return this.bgxmc;
   }
   
   public void setBgxmc(String bgxmc) {
       this.bgxmc = bgxmc;
   }

   public String getGlbm() {
       return this.glbm;
   }
   
   public void setGlbm(String glbm) {
       this.glbm = glbm;
   }

   public String getZt() {
       return this.zt;
   }
   
   public void setZt(String zt) {
       this.zt = zt;
   }
}
