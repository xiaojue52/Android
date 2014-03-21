package com.jypmis.func.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List; //Generated by MyEclipse

import com.google.gson.Gson;
import com.jypmis.dbconn.OracleDBCONN;
import com.jypmis.exception.MyRuntimeException;
import com.jypmis.func.login.LoginImpl;
import com.jypmis.po.Bbg;
import com.jypmis.po.Bxmjbxx;
import com.jypmis.po.Sbgx;
import com.jypmis.po.Sbm;
import com.jypmis.vo.BbgVO;
import com.jypmis.vo.ReportSearchFieldVO;
import com.jypmis.vo.SbgxVO;
import com.jypmis.ztools.BHGenerator;
import com.jypmis.ztools.ReportQueryString;
import com.jypmis.ztools.TransTimetype;

public class ReportImpl implements IReport {

	final ReportQueryString cs = new ReportQueryString();
	final String QUERYREPORTYPES = cs.getQUERYREPORTYPES();
	final String INSERTREPORTS = cs.getINSERTREPORTS();
	final String DELETEREPORT = cs.getDELETEREPORT();
	final String UPDATEWODEREPORT = cs.getUPDATEWODEREPORT();

	final String QUERYREPORTBYSEARCHSTR1 = cs.getQUERYREPORTBYSEARCHSTR1();// 查询报工时间范围内的报工信息
	final String QUERYREPORTBYSEARCHSTR0 = cs.getQUERYREPORTBYSEARCHSTR0();// 查询工作日期范围内的报工信息

	final String QUERYREPORTBYID = cs.getQUERYREPORTBYID();
	final String QUERYREPORTWEITONGGUOCOUNT = cs
			.getQUERYREPORTWEITONGGUOCOUNT();// 查询未审核的报工条数
	final String QUERYREPORTDAISHENHECOUNT = cs.getQUERYREPORTDAISHENHECOUNT();// 审核人的待审核报工条数
	final String WEITONGGUO = cs.getWEITONGGUO();
	final String DAISHENHE = cs.getDAISHENHE();
	final String YITONGGUO = cs.getYITONGGUO();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 新增报工
	 */
	@SuppressWarnings("static-access")
	public String saveReport(String userid, String reportStr) {
		// TODO Auto-generated method stub
		//System.out.println("客户端新增报工内容：" + userid + "和" + reportStr);
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		Gson gson = new Gson();
		BbgVO bg = gson.fromJson(reportStr, BbgVO.class);
		String bgr=userid;
//		String shr = null;
//		if (bg.xmid.equals("-1")) {
//			System.out.println("新增的报工与项目无关，查找部门主任作为审核人");
//			shr = log.findDepManagerbyUserid(userid);
//		} else {
//			System.out.println("新增的报工跟项目有关，查找对应xmid下的项目经理作为审核人");
//			shr = log.findProjectManagerByXMID(bg.xmid);
//		}
		BHGenerator bh = new BHGenerator();
		String bgid = bh.getBh();// 设置报工ID，进行编号
		TransTimetype trans = new TransTimetype();
		String currentTime = trans.getCurrentTime();
		Timestamp bgsj = trans.String2Timestamp(currentTime);
		Date gzrq = trans.String2Date(bg.gzrq);

		try {
			  final String INSERTREPORTS = "insert into bbg(bgid,bglx,xmid,gzrq,gzxs,gzdd,gznr,bgr,bgsj,zt,czxth,sjbzm) "
				+ "values(?,?,?,?,?,?,?,?,?,?,'czxth0001','sjbzm0001')";
			ps = conn.prepareStatement(INSERTREPORTS);
			ps.setString(1, bgid);
			ps.setString(2, bg.bgxid);
			ps.setString(3, bg.xmid);
			ps.setDate(4, gzrq);
			ps.setFloat(5, Float.valueOf(bg.gzxs));
			ps.setString(6, bg.gzdd);
			ps.setString(7, bg.gznr);
			ps.setString(8, bgr);
			ps.setTimestamp(9, bgsj);
			ps.setString(10, "0");
			//ps.setString(11, shr);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
			return "-1";
			// throw new MyRuntimeException("新增报工失败");

		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		//System.out.println("新增报工成功，报工编号为：" + bgid);
		return "1";
	}

	/**
	 * 删除报工
	 */
	public String deleteReport(String reportid) {
		// TODO Auto-generated method stub
		//System.out.println("客户端删除了报工ID为：" + reportid + "的报工");
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(DELETEREPORT);
			ps.setString(1, reportid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
			return "-1";
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return "1";
	}

	/**
	 * 修改报工
	 */
	public String updateReport(String yhid, String reportStr,String type) {
		
		//System.out.println("客户端修改报工内容,传来：" + yhid + "和" + reportStr);
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		Gson gson = new Gson();
		BbgVO bg = gson.fromJson(reportStr, BbgVO.class);
		String shr=yhid;
		TransTimetype trans = new TransTimetype();
		Date gzrq = trans.String2Date(bg.gzrq);
		String currentTime = trans.getCurrentTime();
		Timestamp bgsj = trans.String2Timestamp(currentTime);
		Timestamp shsj = trans.String2Timestamp(currentTime);
		final String UPDATEWODEREPORT0="update bbg set bglx=?,xmid=?,gzrq=?,gzxs=?,gzdd=?,gznr=?"+
		",zt=?,shxx=?,bgsj=?,shsj=? where bgid=?";//报工修改
		final String UPDATEWODEREPORT1="update bbg set bglx=?,xmid=?,gzrq=?,gzxs=?,gzdd=?,gznr=?"+
		",zt=?,shr=?,shxx=?,bgsj=?,shsj=? where bgid=?";//报工修改
		
		if (type.equals("0"))
		{
			try {
				ps = conn.prepareStatement(UPDATEWODEREPORT0);
				ps.setString(1, bg.bgxid);
				ps.setString(2, bg.xmid);
				ps.setDate(3, gzrq);
				ps.setFloat(4, Float.valueOf(bg.gzxs));
				ps.setString(5, bg.gzdd);
				ps.setString(6, bg.gznr);
				if (bg.zt.equals(WEITONGGUO)) {
					ps.setString(7, DAISHENHE); // 修改后将状态修改为待审核
				} else
					ps.setString(7, bg.zt);
				ps.setString(8, bg.shxx);
				ps.setTimestamp(9, bgsj);	//修改报工时间为当前时间			
				ps.setTimestamp(10, trans.String2Timestamp(bg.shsj));
				ps.setString(11, bg.bgid);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				OracleDBCONN.getInstance().close(conn, ps, rs);
				return "-1";
			}
			
			
		}else{
			try {
				ps = conn.prepareStatement(UPDATEWODEREPORT1);
				ps.setString(1, bg.bgxid);
				ps.setString(2, bg.xmid);
				ps.setDate(3, gzrq);
				ps.setFloat(4, Float.valueOf(bg.gzxs));
				ps.setString(5, bg.gzdd);
				ps.setString(6, bg.gznr);
				ps.setString(7, bg.zt);
				ps.setString(8, shr);
				ps.setString(9, bg.shxx);
				ps.setTimestamp(10, trans.String2Timestamp(bg.bgsj));			
				ps.setTimestamp(11, shsj);////修改审核时间为当前时间	
				ps.setString(12, bg.bgid);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				OracleDBCONN.getInstance().close(conn, ps, rs);
				return "-1";
			}
		}		

		//System.out.println("修改了编号为：" + bg.bgid + "的报工");
		OracleDBCONN.getInstance().close(conn, ps, rs);
		return "1";
	}

	/**
	 * 查询bgid对应的报工
	 */
	public String showReport(String bgid) {
		// TODO Auto-generated method stub
		List<Bbg> listbbg = findReportByID(bgid);
		if (listbbg == null || listbbg.size() == 0) {
			//System.out.println("未查到报工记录，请重新检索");
			return "-1";
		} else {
			Iterator<Bbg> it = listbbg.iterator();
			Bbg bbg = new Bbg();
			Gson gson = new Gson();
			String jsonString = null;
			while (it.hasNext()) {
				bbg = it.next();
				BbgVO bgvo = new BbgVO();
				bgvo.bgid = bbg.getBgid();
				bgvo.bgxid = bbg.getBglx();
				bgvo.xmid= bbg.getXmid();
				bgvo.xmjc = bbg.getXmjc();
				bgvo.gzdd = bbg.getGzdd();
				LoginImpl log = new LoginImpl();
				String shr = log.findUsernameByUserid(bbg.getShr());// 作为审核
				bgvo.shr = shr;// 审核人
				bgvo.shxx = bbg.getShxx();
				bgvo.zt = bbg.getZt();
				bgvo.gznr = bbg.getGznr();
				bgvo.gzxs = bbg.getGzxs().toString();
				bgvo.gzrq = bbg.getGzrq();
				bgvo.bgsj= bbg.getBgsj();
				bgvo.shsj=bbg.getShsj();
				//LoginImpl log = new LoginImpl();
				String bgr = log.findUsernameByUserid(bbg.getBgr());// 作为报工人
				bgvo.bgr = bgr;
				jsonString = gson.toJson(bgvo);
				
			}
			//System.out.println("我的"+jsonString+"woded32342");
			return jsonString;
		}
	}

	/**
	 * 按条件搜索报工
	 */
	public String getReports(String reportSearchFieldStr) {
		//System.out.println("客户端按条件查询报工信息" + reportSearchFieldStr);
		// TODO Auto-generated method stub
		List<Bbg> listbbg = findReportBySearchStr(reportSearchFieldStr);
		Iterator<Bbg> it = listbbg.iterator();

		if (listbbg == null || listbbg.size() == 0) {
			//System.out.println("未查到报工记录，请重新检索");
			return "-1";
		} else {
			Bbg bbg = new Bbg();
			Gson gson = new Gson();
			String jsonString = null;
			//List<BbgSortVO> listsort=new ArrayList<BbgSortVO>();
			List<BbgVO> listAll = new ArrayList<BbgVO>();
			while (it.hasNext()) {
				bbg = it.next();
				BbgVO bgvo = new BbgVO();
				bgvo.gzrq = bbg.getGzrq();
				bbg.setBgr(bbg.getBgr());
				bgvo.gzxs = bbg.getGzxs().toString();
				bgvo.gznr = bbg.getGznr();
				bgvo.zt = bbg.getZt();
				bgvo.xmjc = bbg.getXmjc();
				bgvo.bgid=bbg.getBgid();
				bgvo.shxx=bbg.getShxx();
				LoginImpl log = new LoginImpl();
				String bgr = log.findUsernameByUserid(bbg.getBgr());// 作为报工人
				bgvo.bgr = bgr;
				bgvo.bgxid = bbg.getBglx();
				listAll.add(bgvo);	
				//System.out.println("bgvo:"+gson.toJson(bgvo));
			}
			/*while(listAll.size()>0){
				List<BbgVO> list = new ArrayList<BbgVO>();
				BbgVO b = listAll.get(0);
				list.add(b);
				listAll.remove(0);
				int i = 0;
				while(listAll.size()!=i){
					if(b.xmjc.equals(listAll.get(i).xmjc)){
						list.add(listAll.get(i));
						listAll.remove(i);
						i--;
					}
					i++;
				}
				BbgSortVO vo = new BbgSortVO();
				vo.xmjc = b.xmjc;
				
				vo.list = list;
				listsort.add(vo);
			}*/
			jsonString = gson.toJson(listAll);
			//System.out.println(jsonString);
			return jsonString;
		}
	}
	
	


	/**
	 * 查询报工数：未通过，待审核->用于在主页面显示提示
	 */
	public int getReportCount(String yhid, String zt) {
		// TODO Auto-generated method stub
		//System.out.println("客户端传来"+yhid+"，状态"+zt);
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
//		LoginImpl log = new LoginImpl();
//		String bgr = log.findUsernameByUserid(yhid);// 根据用户id查询用户姓名作报工人
//		String shr = log.findUsernameByUserid(yhid);
		String bgr=yhid;
		int count = 0;
		try {
			if (zt.equals(WEITONGGUO)) {
				//System.out.println("查询我的报工未通过的报工记录数");
				ps = conn.prepareStatement(QUERYREPORTWEITONGGUOCOUNT);
				ps.setString(1, bgr);
				ps.setString(2, zt);
				rs = ps.executeQuery();
				if (rs.next())
					count = rs.getInt(1);
				else return 0;
			} else if (zt.equals(DAISHENHE)) {
				//System.out.println("查询审核报工中待审核的报工记录数");
				Gson gson=new Gson();
				ReportSearchFieldVO rs1=new ReportSearchFieldVO();
				rs1.xmid="-1";
				rs1.kssj="2000-03-21";
				rs1.jssj="2016-03-21";
				rs1.xzwtg="0";
				rs1.xzdsh="1";
				rs1.xzysh="0";
				rs1.yhid=yhid;
				rs1.type="1";
				rs1.xzdy="1";
				rs1.xzxy="1";
				rs1.xzeq="1";
				rs1.bgxid="-1";
				String reportSearchFieldStr=gson.toJson(rs1);
				List<Bbg> listbbg =this.findReportBySearchStr(reportSearchFieldStr);
				if(listbbg.size()>0)
				{
					//System.out.println("待审核个数："+listbbg.size());
					count=listbbg.size();
				}
				//this.checkYHJSbyYHID(yhid);
//				ps = conn.prepareStatement(QUERYREPORTDAISHENHECOUNT);
//				ps.setString(1, shr);
//				ps.setString(2, zt);
			} else
				return 0;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询报工记录数失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return count;
	}

	/**
	 * 获取报工类型
	 */
	public String getReportTypes() {
		// TODO Auto-generated method stub
		//System.out.println("客户端查询报工类型");
		Sbgx sbgx = new Sbgx();
		List<Sbgx> listsbgx = findReportTypes();
		if (listsbgx == null || listsbgx.size() == 0) {
			//System.out.println("没有报工类型");
			return "-1";
		} else {
			Iterator<Sbgx> itsbgx = listsbgx.iterator();
			String jsonString = null;
			List<SbgxVO> list = new ArrayList<SbgxVO>();
			Gson gson = new Gson();
			while (itsbgx.hasNext()) {
				sbgx = itsbgx.next();
//				System.out.println("报工项ID：" + sbgx.getBgxid() + ",报工项名称："
//						+ sbgx.getBgxmc());
				SbgxVO sbgxvo = new SbgxVO();
				sbgxvo.bgxid = sbgx.getBgxid();
				sbgxvo.bgxmc = sbgx.getBgxmc();
				sbgxvo.zt = sbgx.getZt();

				list.add(sbgxvo);
				jsonString = gson.toJson(list);
				// System.out.println("jsonString:"+jsonString);
			}
			//System.out.println(jsonString);
			return jsonString;
		}
	}

	public List<Sbgx> findReportTypes() {
		// TODO Auto-generated method stub
		//System.out.println("查询报工类型...");
		List<Sbgx> listsbgx = new ArrayList<Sbgx>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYREPORTYPES);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sbgx sbgx = new Sbgx();
				sbgx.setBgxid(rs.getString("bgxid"));
				sbgx.setBgxmc(rs.getString("bgxmc"));
				sbgx.setZt(rs.getString("zt"));
				listsbgx.add(sbgx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询报工类型失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listsbgx;
	}

	public List<Bbg> findReportByID(String bgid) {
		// TODO Auto-generated method stub
		//System.out.println("查询" + bgid + "的报工信息...");
		List<Bbg> listbbg = new ArrayList<Bbg>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYREPORTBYID);
			ps.setString(1, bgid);
			rs = ps.executeQuery();
			TransTimetype trans = new TransTimetype();
			//System.out.println(rs.getTimestamp("bgsj"));
			String bgsj= null;
			//System.out.println(bgsj);
			String shsj= null;
			while(rs.next())
			{
				Bbg bbg = new Bbg();
				bgsj= trans.Timestamp2String(rs.getTimestamp("bgsj"));
				shsj= trans.Timestamp2String(rs.getTimestamp("shsj"));
				bbg.setBgid(bgid);
				//,bgsj,shsj
				bbg.setBglx(rs.getString("bglx"));
				bbg.setXmid(rs.getString("xmid"));
				bbg.setXmjc(rs.getString("xmjc"));
				bbg.setGzdd(rs.getString("gzdd"));
				bbg.setShr(rs.getString("shr"));
				bbg.setShxx(rs.getString("shxx"));
				bbg.setZt(rs.getString("zt"));
				bbg.setBgsj(bgsj);
				bbg.setShsj(shsj);
				bbg.setGznr(rs.getString("gznr"));
				bbg.setGzxs(rs.getFloat("gzxs"));
				String gzrq=trans.Date2String(rs.getDate("gzrq"));
				
				bbg.setGzrq(gzrq);
				
				bbg.setBgr(rs.getString("bgr"));
				listbbg.add(bbg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询" + bgid + "报工失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listbbg;
	}

	/**
	 * 按条件查询报工 报工时间段或工作日期间隔，工作小时等搜素条件
	 */
	public List<Bbg> findReportBySearchStr(String reportSearchFieldStr) {
		// TODO Auto-generated method stub
		//System.out.println("按条件查询报工信息...");
		List<Bbg> listbbg = new ArrayList<Bbg>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		Gson gson = new Gson();
		ReportSearchFieldVO rsfvo = gson.fromJson(reportSearchFieldStr,	ReportSearchFieldVO.class);		
//		LoginImpl log = new LoginImpl();
//		String bgr = log.findUsernameByUserid(rsfvo.yhid);// 作为报工人
		String bgr =rsfvo.yhid;// 作为报工人
//		String shr = log.findUsernameByUserid(rsfvo.yhid);// 作为审核人
//		String shr=rsfvo.yhid;
		String type = rsfvo.type;

		// 判断审核状态选择情况
		String xzwtg = "";
		String xzdsh = "";
		String xzysh = "";
		try {
		if (rsfvo.xzwtg.equals("1")) {
			xzwtg = "-1";
		} else {
			xzwtg = "";
		}
		if (rsfvo.xzdsh.equals("1")) {
			xzdsh = "0";
		} else {
			xzdsh = "";
		}
		if (rsfvo.xzysh.equals("1")) {
			xzysh = "1";
		} else {
			xzysh = "";
		}
		}catch (Exception e)
		{
			xzwtg = "";xzdsh = "0";xzysh = "";
		}

		String querystr = "";
		int itemp = 0;
		try {
			itemp = Integer.parseInt(rsfvo.xzdy + rsfvo.xzxy + rsfvo.xzeq);
		} catch (Exception e) {
			itemp = Integer.parseInt("111");
		}

		// 判断工作小时的选择情况
		switch (itemp) {
		case 111:
			querystr += " and (gzxs>8 or gzxs<8 or gzxs=8)";// 选择了>,<,=
			break;
		case 110:
			querystr += " and (gzxs>8 or gzxs<8 )";// 选择了>,<
			break;
		case 101:
			querystr += " and (gzxs>8 or gzxs=8 )";// 选择了>,=
			break;
		case 100:
			querystr += " and  gzxs>8";// 选择了>
			break;
		case 11:
			querystr += " and (gzxs<8 or gzxs=8)";// 选择了<,=
			break;
		case 10:
			querystr += " and gzxs<8";// 选择了<
			break;
		case 1:
			querystr += " and gzxs=8";// 选择了=
			break;
		case 0:
			querystr += "";// 未选择
			break;
		}

		TransTimetype trans = new TransTimetype();
		// 查询时间范围：近一天或两天等

		try {
			if (type.equals("1")) {
				//System.out.println("作为审核人");
				//查看当前用户角色
				String dshsqlstr=this.getMyDSHSQLStr(rsfvo);//查询待我审核的报工
				//System.out.println("查询待审核报工："+dshsqlstr);
				if(dshsqlstr.equals(""))
				{
					//System.out.println("无待审核报工");
				}else{
				ps=conn.prepareStatement(dshsqlstr);
				rs=ps.executeQuery();
			}
			} else {
				//System.out.println("报工人查看工作日期间隔内的报工");
				// 查询工作日期范围：
				Date kssj = null;
				try {
					kssj = trans.String2Date(rsfvo.kssj);// 开始日期
				} catch (Exception e) {
					kssj = trans.String2Date("1975-01-01");
				}

				Date jssj = trans.String2Date(rsfvo.jssj);// 结束日期
				
				//QUERYREPORTBYSEARCHSTR0="select gzrq,bgr,gzxs,gznr,zt,xmjc,bgid,shxx "+
				//"from bbg a,bxmjbxx b where a.xmid=b.xmid and (gzrq between ? and ?)"+
				//"and (zt=? or zt=? or zt=?) and bgr=? ";
				
				if (!rsfvo.xmid.equals("-1")) {
					//查询所有项目
					ps = conn.prepareStatement(QUERYREPORTBYSEARCHSTR0
							+ querystr + " and a.xmid='" + rsfvo.xmid + "'");
				} else {
					String bgxStr = "";
					if (!rsfvo.bgxid.equals("-1")){
					//查询所有报工类型
						bgxStr = " and a.bglx ='"+rsfvo.bgxid+"'";
					}
					ps = conn.prepareStatement(QUERYREPORTBYSEARCHSTR0
							+ querystr + bgxStr );
				}
				ps.setDate(1, kssj);
				ps.setDate(2, jssj);
				ps.setString(6, bgr);
				ps.setString(3, xzwtg);
				ps.setString(4, xzdsh);
				ps.setString(5, xzysh);
				rs = ps.executeQuery();
			}
			while (rs.next()) {
				Bbg bbg = new Bbg();
				String gzrq=trans.Date2String(rs.getDate("gzrq"));
				bbg.setGzrq(gzrq);
				bbg.setGzxs(rs.getFloat("gzxs"));
				bbg.setGznr(rs.getString("gznr"));
				bbg.setZt(rs.getString("zt"));
				bbg.setXmjc(rs.getString("xmjc"));
				bbg.setBgid(rs.getString("bgid"));
				bbg.setShxx(rs.getString("shxx"));
				bbg.setBgr(rs.getString("bgr"));
				bbg.setBglx(rs.getString("bglx"));
				listbbg.add(bbg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("按条件查询报工失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listbbg;
	}

	/**
	 * 从部门表中找到所有与yhid相同的部门主任+部门编号
	 * @param rsfvo
	 * @return
	 */
	 private List<Sbm>  getBMZRs(String  yhid){
		 
		 String QUERYBMZRS="select * from sbm where bmzr='"+ yhid + "'";
		 conn = OracleDBCONN.getInstance().getOracleDBCONN();
		 List<Sbm> listbmzrs = new ArrayList<Sbm>();		 
			try {
				ps = conn.prepareStatement(QUERYBMZRS);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Sbm sbm=new Sbm();
					sbm.setBmid(rs.getString("bmid"));
					sbm.setBmzr(rs.getString("bmzr"));
					sbm.setBmbh(rs.getString("bmbh"));
					listbmzrs.add(sbm);					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return listbmzrs;
	 }
	
	 /**
	  * 从项目列表中查找所有与yhid相同的项目经理
	  * @param rsfvo
	  * @return
	  */
	 public List<Bxmjbxx> getXMIDList(String yhid)
	 {
		 String QUERYBMZRS="select xmid from bxmjbxx where xmjl='" + yhid + "'";
		 
		 List<Bxmjbxx> xmjlxmid = new ArrayList<Bxmjbxx>();		 
			try {
				ps = conn.prepareStatement(QUERYBMZRS);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Bxmjbxx xm=new Bxmjbxx();
					xm.setXmid(rs.getString("xmid"));
					xmjlxmid.add(xm);					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return xmjlxmid;
	 }
	 
	 /**
	  * 判断用户角色，是否为部门主任、分部门主任、项目经理或者三种角色的组合形式
	  * @param rsfvo
	  * @return
	  */
	 public String checkYHJSbyYHID(String yhid)
	 {
		String []jstype={"0","0","0"};//分别对应：部门主任、分部门主任、项目经理		
		String bmbh="";	
		 //查看用户是否为部门主任或分部门主任
		 List<Sbm> listbmzrs=this.getBMZRs(yhid);
		 if(listbmzrs.size()>0)
		 {
				for(int i=0;i<listbmzrs.size();i++)
				{
					bmbh=listbmzrs.get(i).getBmbh();
					//System.out.println("编号："+bmbh);	
						if(bmbh.length()>4)
						{
						// System.out.println(yhid+"为"+bmbh+"分部门主任");
						 jstype[1]="1";
						}else if(bmbh.length()<=4)
						{
							//System.out.println(yhid+"为"+bmbh+"部门主任");
							jstype[0]="1";
						} 
				}
		 }else{
			 //System.out.println("您不是部门主任或分部门主任");
		 }
		 //查看用户是否为项目经理
		 List<Bxmjbxx> xmjlxmid=this.getXMIDList(yhid);
		 String xmjl="";
			try{
			xmjl=xmjlxmid.get(0).getXmid();
			}catch(Exception e)
			{
			}
			if(xmjl==null||xmjl.equals(""))
			{
			}else{
				jstype[2]="1";
			}
			return jstype[0]+jstype[1]+jstype[2];
	 }	
	 
	 //根据用户角色查看待审核报工
		public String getMyDSHSQLStr(ReportSearchFieldVO rsfvo){
			TransTimetype trans = new TransTimetype();
			Timestamp kssj = trans.String2Timestamp(rsfvo.kssj+" 00:00:01");// 开始时间
			Timestamp jssj = trans.String2Timestamp(rsfvo.jssj+" 23:59:59");// 结束时间
			String querystr = "";
			int itemp1 = 0;
			try {
				itemp1 = Integer.parseInt(rsfvo.xzdy + rsfvo.xzxy + rsfvo.xzeq);
			} catch (Exception e) {
				itemp1 = Integer.parseInt("111");
			}

			// 判断工作小时的选择情况
			switch (itemp1) {
			case 111:
				querystr += " and (gzxs>8 or gzxs<8 or gzxs=8) ";// 选择了>,<,=
				break;
			case 110:
				querystr += " and (gzxs>8 or gzxs<8 ) ";// 选择了>,<
				break;
			case 101:
				querystr += " and (gzxs>8 or gzxs=8 ) ";// 选择了>,=
				break;
			case 100:
				querystr += " and  gzxs>8 ";// 选择了>
				break;
			case 11:
				querystr += " and (gzxs<8 or gzxs=8) ";// 选择了<,=
				break;
			case 10:
				querystr += " and gzxs<8 ";// 选择了<
				break;
			case 1:
				querystr += " and gzxs=8 ";// 选择了=
				break;
			case 0:
				querystr += "";// 未选择
				break;
			}
			
			String yhid=rsfvo.yhid;
			String SSQL="select gzrq,bgr,gzxs,gznr,zt,a.xmid,nvl(xmjc, '--') xmjc,bgid,shxx,bglx "+
			"from bbg a left join bxmjbxx b on a.xmid=b.xmid where "+
			"(a.bgsj between to_timestamp('"+kssj+"', 'yyyy-mm-dd hh24:mi:ss.ff') and to_timestamp('"+jssj+"', 'yyyy-mm-dd hh24:mi:ss.ff'))"+
			"and zt='0' "+querystr;//查询附加条件
			//String osql=" order by a.bgsj desc";//结果排序

			String case1sql=SSQL+" and xmjl="+yhid+" and bgr!="+yhid+" and a.bglx='0001'";//项目经理
			
			String case10sql=SSQL+" and a.bgr in (select yhid as bgr from sbm p,sxtyh q "+
			"where p.bmid=q.bmid and length(bmbh)>4 and bmzr='"+yhid+"')"+
			"and bgr!="+yhid+" and a.bglx!='0001'";//分部门主任
			
			String case11sql=case1sql+" union "+case10sql;//分部门主任+项目经理
			
			String case100sql=SSQL+"and a.bgr in (select yhid as bgr from sbm p,sxtyh q where p.bmid=q.bmid and length(bmbh)<=4 and bmzr='"+yhid+"')"+
			" and a.bglx!='0001' "+" union "+SSQL+"and a.bgr in (select xmjl from bxmjbxx a,sbm b where a.zrbm=b.bmid and length(bmbh)<=4 and bmzr='"+yhid+"') "+
			"and a.bglx='0001' "+" union "+SSQL
			+"and a.bgr in ( select bmzr from sbm where substr(bmbh, 0, length(bmbh)-4) in (select bmbh  from sbm where length(bmbh)=4 and bmzr='"+yhid+"')) "+
			"and a.bglx!='0001' ";//部门主任
			
			String case101sql=case100sql+case1sql;//部门主任+项目经理
			
			String case110sql=case100sql+case10sql;//部门主任+分部门主任
			
			String case111sql=case110sql+case1sql;//部门主任+分部门主任+项目经理
			
			String compsql="";

			int itemp=0;
			try {
				itemp=Integer.parseInt(checkYHJSbyYHID(yhid));
			} catch (Exception e) {
				itemp = Integer.parseInt("000");//!(部门主任+分部门主任+项目经理)
			}
			switch(itemp)
			{		
			case 111:	compsql=case111sql;;//部门主任+分部门主任+项目经理
				break;
			case 110:	compsql=case110sql;//部门主任+分部门主任
				break;
			case 101:	compsql=case101sql;//部门主任+项目经理
				break;
			case 100:	compsql=case100sql;//部门主任
				break;
			case  11:	compsql=case11sql;//分部门主任+项目经理
				break;
			case  10:	compsql=case10sql;//分部门主任
				break;
			case   1:	compsql=case1sql;//项目经理
				break;
			default:
				break;
			}		
			return compsql;
		}

	public static void main(String[] args) {
		ReportImpl rep = new ReportImpl();
		Gson json=new Gson();
		System.out.println(rep.getReportCount("263", "0"));
		ReportSearchFieldVO rsfvo=new ReportSearchFieldVO();
		rsfvo.yhid="263";
		System.out.println(json.toJson(rep.getBMZRs("263")));
		System.out.println(rep.checkYHJSbyYHID("263"));
		

	}
}