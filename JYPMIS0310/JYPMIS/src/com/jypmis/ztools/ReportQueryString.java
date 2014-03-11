package com.jypmis.ztools;

//获取常量类
public class ReportQueryString {


	/**
	 * 报工项sql
	 */
	private  final String QUERYREPORTYPES = "select bgxid,bgxmc,zt from sbgx ";
	/**
	 * 增加报工sql
	 */
	private  final String INSERTREPORTS = "insert into bbg(bgid,bglx,xmid,gzrq,gzxs,gzdd,gznr,bgr,bgsj,zt) "
			+ "values(?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 删除报工sql
	 */
	private final String DELETEREPORT="delete from bbg where bgid=?";//删除bgid报工
	//private final String UPDATEWODEREPORT="update bbg set bglx=?,xmid=?,gzrq=?,gzxs=?,gzdd=?,gznr=?,bgr=?,zt=? where bgid=? and zt=?";//对我的报工修改
	/**
	 * 更新报工sql
	 */
	private final String UPDATEWODEREPORT="update bbg set bglx=?,xmid=?,gzrq=?,gzxs=?,gzdd=?,gznr=?"+
	",zt=?,shr=?,shxx=?,bgsj=?,shsj=? where bgid=?";//报工修改
	/**
	 * 查询报工sql(审核)
	 */
	private final String QUERYREPORTBYSEARCHSTR1="select gzrq,bgr,gzxs,gznr,zt,nvl(xmjc, '--') xmjc,bgid,shxx,bglx "+
	"from bbg a left join bxmjbxx b on a.xmid=b.xmid where (bgsj between ? and ?)"+
	"and (zt=? or zt=? or zt=?) and shr=? ";//根据搜索条件查询，type=1时，查询报工时间范围
	/**
	 * 查询报工sql（自己）
	 */
	private final String QUERYREPORTBYSEARCHSTR0="select gzrq,bgr,gzxs,gznr,zt,nvl(xmjc, '--') xmjc,bgid,shxx,bglx "+
	"from bbg a left join bxmjbxx b on a.xmid=b.xmid where (gzrq between ? and ?)"+
	"and (zt=? or zt=? or zt=?) and bgr=? ";//根据搜索条件查询，type=0时，查询工作日期范围
	/**
	 * show报工
	 */
	private  final String QUERYREPORTBYID = "select bgid,bglx,a.xmid,nvl(xmjc, '--') xmjc,gzdd,shr,shxx,zt,gznr,gzxs,gzrq,a.bgsj,a.shsj,bgr "+
	"from bbg a left join bxmjbxx b on a.xmid=b.xmid where bgid=? ";
	/**
	 * 未通过数量
	 */
	private  final String QUERYREPORTWEITONGGUOCOUNT="select count(*) count from bbg where bgr=? and zt=?";//查询我的未通过的报工条数
	/**
	 * 待审核数量
	 */
	private  final String QUERYREPORTDAISHENHECOUNT="select count(*) count from bbg where shr=? and zt=?";//审核人的待审核的报工条数
	//private  final String QUERYREPORTYITONGGUOCOUNT="select count(*) count from bbg where bgr=? and zt=?";//我的报工中已通过的报工数
	/**
	 * 未通过
	 */
	private  final String WEITONGGUO="-1";//未通过
	/**
	 * 待审核
	 */
	private  final String DAISHENHE="0";//待审核
	private  final String YITONGGUO="1";//已通过
	
	/**
	 * 报工项sql
	 */
	public String getQUERYREPORTYPES() {
		return QUERYREPORTYPES;
	}
	/**
	 * 增加报工sql
	 */
	public String getINSERTREPORTS() {
		return INSERTREPORTS;
	}
	/**
	 * 删除报工sql
	 */
	public String getDELETEREPORT() {
		return DELETEREPORT;
	}
	/**
	 * 更新报工sql
	 */
	public String getUPDATEWODEREPORT() {
		return UPDATEWODEREPORT;
	}
	/**
	 * 查询报工sql(审核)
	 */	
	public String getQUERYREPORTBYSEARCHSTR1() {
		return QUERYREPORTBYSEARCHSTR1;
	}
	/**
	 * 查询报工sql（自己）
	 */
	public String getQUERYREPORTBYSEARCHSTR0() {
		return QUERYREPORTBYSEARCHSTR0;
	}
	/**
	 * show报工
	 */
	public String getQUERYREPORTBYID() {
		return QUERYREPORTBYID;
	}
	/**
	 * 未通过数量
	 */
	public String getQUERYREPORTWEITONGGUOCOUNT() {
		return QUERYREPORTWEITONGGUOCOUNT;
	}
	/**
	 * 待审核数量
	 */
	public String getQUERYREPORTDAISHENHECOUNT() {
		return QUERYREPORTDAISHENHECOUNT;
	}
	/**
	 * 未通过
	 */
	public String getWEITONGGUO() {
		return WEITONGGUO;
	}
	/**
	 * 待审核
	 */
	public String getDAISHENHE() {
		return DAISHENHE;
	}
	/**
	 * 已审核
	 */
	public String getYITONGGUO() {
		return YITONGGUO;
	}	

}
