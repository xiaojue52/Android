package com.jypmis.func.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.jypmis.dbconn.OracleDBCONN;
import com.jypmis.exception.MyRuntimeException;
import com.jypmis.po.Bxmjbxx;
import com.jypmis.vo.BxmjbxxVO;

public class ProjectImpl implements IProject {
	public static String identifier = "1111";

//	private static final String QUERYDEPARTMENTPROJECTS = "select xm.xmid as xmid,xm.xmjc as xmjc "+
//	"from bxmjbxx xm,sbm where xm.zrbm=sbm.bmid and sbm.bmid=?";
	private static final String QUERYDEPARTMENTPROJECTS = "select xmid,xmjc,xm.xmmc from bxmjbxx xm,sbm where xm.zrbm=sbm.bmid and sbm.bmid=? and xmid !='-1'";
	private static final String QUERYPROJECTS="select xmid,xmjc,xmmc from bxmjbxx xm,sbm "+
	"where xm.zrbm=sbm.bmid and sbm.bmid=? and xm.xmjc like ? and xmid !='-1'";//选择bmid后，输入xmjc模糊查询，查询bmid下的指定项目
	private static final String QUERYALLPROJECTS="select xmid,xmjc,xmmc from bxmjbxx xm,sbm "+
	"where xm.zrbm=sbm.bmid and (sbm.bmid=? or xm.xmjc like ?) and xmid !='-1'";//选择bmid的值为-1时，输入xmjc模糊查询,可在所有项目中查询
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String getDepartmentProjects(String departmentid) {
		// TODO Auto-generated method stub
		System.out.println("客户端查询部门项目信息");
		Bxmjbxx bxmjbxx = new Bxmjbxx();
		List<Bxmjbxx> listbxmjbxx = findDepartmentProjects(departmentid);

		if (listbxmjbxx == null || listbxmjbxx.size() == 0) {
			System.out.println("该部门没有项目信息");
			return "-1";
		} else {
			Iterator<Bxmjbxx> itsbm = listbxmjbxx.iterator();
			String jsonString = null;
			List<BxmjbxxVO> list = new ArrayList<BxmjbxxVO>();
			Gson gson = new Gson();
			while (itsbm.hasNext()) {
				bxmjbxx = itsbm.next();
				System.out.println("项目ID：" + bxmjbxx.getXmid() + ",项目简称："
						+ bxmjbxx.getXmjc());
				BxmjbxxVO bxmjbxxvo = new BxmjbxxVO();
				bxmjbxxvo.xmid = bxmjbxx.getXmid();
				bxmjbxxvo.xmjc = bxmjbxx.getXmjc();
				bxmjbxxvo.xmmc = bxmjbxx.getXmmc();
				list.add(bxmjbxxvo);
				jsonString = gson.toJson(list);
			}
			System.out.println(jsonString);
			return jsonString;
		}
	}

	public List<Bxmjbxx> findDepartmentProjects(String departmentid) {
		// TODO Auto-generated method stub
		System.out.println("查询部门项目信息...");
		List<Bxmjbxx> listxmjbxx = new ArrayList<Bxmjbxx>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYDEPARTMENTPROJECTS);
			ps.setString(1, departmentid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bxmjbxx bxmjbxx = new Bxmjbxx();
				bxmjbxx.setXmid(rs.getString("xmid"));
				bxmjbxx.setXmjc(rs.getString("xmjc"));
				bxmjbxx.setXmmc(rs.getString("xmmc"));
				listxmjbxx.add(bxmjbxx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询部门项目信息失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listxmjbxx;
	}

	public String getProjects(String identifier) {
		// TODO Auto-generated method stub
		//System.out.println("客户端查询项目信息"+departmentid+"和"+projectName);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Calendar c = Calendar.getInstance();
		Date date = c.getTime();	
		ProjectImpl.identifier = df.format(date);
		System.out.println("客户端查询项目信息"+identifier);
		if (identifier.equals(ProjectImpl.identifier)){
			return "1";
		}
		Bxmjbxx bxmjbxx = new Bxmjbxx();
		List<Bxmjbxx> listbxmjbxx = findProjects("-1", "");

		if (listbxmjbxx == null || listbxmjbxx.size() == 0) {
			System.out.println("没有项目信息,请重新检索");
			return "-1";
		} else {
			Iterator<Bxmjbxx> itbxmjbxx = listbxmjbxx.iterator();
			String jsonString = null;
			List<BxmjbxxVO> list = new ArrayList<BxmjbxxVO>();
			Gson gson = new Gson();
			while (itbxmjbxx.hasNext()) {
				bxmjbxx = itbxmjbxx.next();
				System.out.println("项目ID：" + bxmjbxx.getXmid() + ",项目简称："
						+ bxmjbxx.getXmjc());
				BxmjbxxVO bxmjbxxvo = new BxmjbxxVO();
				bxmjbxxvo.xmid = bxmjbxx.getXmid();
				bxmjbxxvo.xmjc = bxmjbxx.getXmjc();
				bxmjbxxvo.xmmc = bxmjbxx.getXmmc();
				bxmjbxxvo.identifier = ProjectImpl.identifier;
				list.add(bxmjbxxvo);
				jsonString = gson.toJson(list);
			}
			System.out.println(jsonString);
			return jsonString;
		}
	}
	
	public List<Bxmjbxx> findProjects(String departmentid, String projectName) {
		// TODO Auto-generated method stub
		System.out.println("查询项目信息...");
		List<Bxmjbxx> listxmjbxx = new ArrayList<Bxmjbxx>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
//			if (departmentid==null||departmentid.length()==0)
				if (departmentid.equals("-1"))
				{
				System.out.println("模糊查询所有项目");
				ps = conn.prepareStatement(QUERYALLPROJECTS);
				}
			else
			{
				System.out.println("模糊查询departmentid下的项目");
				ps = conn.prepareStatement(QUERYPROJECTS);
				}
				
			ps.setString(1, departmentid);			
			ps.setString(2, "%"+projectName+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Bxmjbxx bxmjbxx = new Bxmjbxx();
				bxmjbxx.setXmid(rs.getString("xmid"));
				bxmjbxx.setXmjc(rs.getString("xmjc"));
				bxmjbxx.setXmmc(rs.getString("xmmc"));
				listxmjbxx.add(bxmjbxx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询项目信息失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listxmjbxx;
	}
}