package com.jypmis.func.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.jypmis.dbconn.OracleDBCONN;
import com.jypmis.exception.MyRuntimeException;
import com.jypmis.po.Sbm;
import com.jypmis.vo.SbmVO;

public class DepartmentImpl implements IDepartment {
	
	private static final String QUERYDEPARTMENTS= "select bmid,bmmc from sbm ";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String getDepartments() {
		// TODO Auto-generated method stub
		System.out.println("客户端查询部门信息");
		Sbm sbm=new Sbm();
		List<Sbm>listsbm=findDepartments();
		if (listsbm == null || listsbm.size() == 0) {
			System.out.println("没有部门信息");
			return "-1";
		} else {
			Iterator<Sbm> itsbm = listsbm.iterator();
			String jsonString = null;
			List<SbmVO> list = new ArrayList<SbmVO>();
			Gson gson = new Gson();
			while (itsbm.hasNext()) {
				sbm= itsbm.next();
				System.out.println("部门ID：" + sbm.getBmid() + ",部门名称："
						+ sbm.getBmmc());
				SbmVO sbmvo = new SbmVO();
				sbmvo.bmid = sbm.getBmid();
				sbmvo.bmmc = sbm.getBmmc();
				list.add(sbmvo);
				jsonString = gson.toJson(list);
			}
			System.out.println(jsonString);
			return jsonString;
		}
	}

	/**
	 * 查询部门信息
	 * 返回必须字段：部门id，部门名称
	 * @return
	 */
	public List<Sbm> findDepartments() {
		// TODO Auto-generated method stub
		System.out.println("查询部门信息...");
		List<Sbm> listsbm = new ArrayList<Sbm>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps=conn.prepareStatement(QUERYDEPARTMENTS);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Sbm sbm=new Sbm();
				sbm.setBmid(rs.getString("bmid"));
				sbm.setBmmc(rs.getString("bmmc"));
				listsbm.add(sbm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询部门信息失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listsbm;
	}

}