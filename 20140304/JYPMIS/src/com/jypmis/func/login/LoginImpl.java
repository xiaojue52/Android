package com.jypmis.func.login;

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
import com.jypmis.po.Sxtyh;
import com.jypmis.vo.SxtyhVO;
import com.jypmis.ztools.MD5Util;

//Generated by MyEclipse

public class LoginImpl implements ILogin {

	private static final String QUERYUSERBASICINFO = "select yhid,bmid from sxtyh where yhxm=? and dlkl=?";
	private static final String QUERYUSERNAMEBYUSERID = "select yhxm from sxtyh where yhid=?";
	private static final String QUERYSHRBYDEPID="select bmzr from sbm a,sxtyh b where a.bmid=b.bmid and yhid=?";
	private static final String QUERYPROJECTMANAGERBYXMID="select xmjl from bxmjbxx where xmid=?";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String login(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("客户端传来： " + username + "," + password);
		List<Sxtyh> listsxtyh = new ArrayList<Sxtyh>();
		listsxtyh = findUserBasicInfo(username, password);
		Sxtyh sxtyh = new Sxtyh();
		if (listsxtyh == null || listsxtyh.size() == 0) {
			System.out.println("登陆失败");
			return "-1";
		} else {
			Iterator<Sxtyh> itsxtyh = listsxtyh.iterator();
			while (itsxtyh.hasNext()) {
				sxtyh = itsxtyh.next();
				System.out.println("用户ID：" + sxtyh.getYhid() + "\t部门ID："
						+ sxtyh.getBmid()+new Gson().toJson(sxtyh));
			}
			System.out.println("登录成功");
			SxtyhVO sxtyhvo = new SxtyhVO();
			sxtyhvo.yhid = sxtyh.getYhid();
			sxtyhvo.bmid = sxtyh.getBmid();
			sxtyhvo.shqx = sxtyh.getShqx();

			Gson gson = new Gson();
			String jsonString = gson.toJson(sxtyhvo);
			System.out.println(jsonString);
			return jsonString;
		}
	}
	/**
	 * 查询用户基本信息，根据username和password
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Sxtyh> findUserBasicInfo(String username, String password) {
		// TODO Auto-generated method stub
		List<Sxtyh> listsxtyh = new ArrayList<Sxtyh>();
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		String dlkl = MD5Util.MD5(password);// 使用MD5对密码加密后，在数据库中查询
		Sxtyh sxtyh = new Sxtyh();
		try {
			ps = conn.prepareStatement(QUERYUSERBASICINFO);
			ps.setString(1, username);
			ps.setString(2, dlkl);
			rs = ps.executeQuery();
			while (rs.next()) {
				sxtyh.setYhid(rs.getString("yhid"));
				sxtyh.setBmid(rs.getString("bmid"));
				sxtyh.setShqx("1");
				listsxtyh.add(sxtyh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询用户信息失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return listsxtyh;
	}

	/**
	 * 根据用户id查询用户名
	 * @param userid
	 * @return
	 */
	public String findUsernameByUserid(String userid) {
		// TODO Auto-generated method stub
		String username=null;
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYUSERNAMEBYUSERID);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while(rs.next())
			{
			username=rs.getString("yhxm").toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询姓名失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return username;
	}

	/**
	 * 查询部门主任作为报工时的审核人
	 * @param userid
	 * @return
	 */
	public String findDepManagerbyUserid(String userid) {
		// TODO Auto-generated method stub
		System.out.println("查询部门主任");
		String bmzr=null;
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYSHRBYDEPID);
			ps.setString(1,userid);
			rs = ps.executeQuery();
			while(rs.next())
			{
			bmzr=rs.getString("bmzr").toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询部门主任失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return bmzr;
	}
	
	/**
	 * 根据项目id查询项目经理
	 * @param xmid
	 * @return
	 */
	public String findProjectManagerByXMID(String xmid) {
		// TODO Auto-generated method stub
		String xmjl=null;
		conn = OracleDBCONN.getInstance().getOracleDBCONN();
		try {
			ps = conn.prepareStatement(QUERYPROJECTMANAGERBYXMID);
			ps.setString(1, xmid);
			rs = ps.executeQuery();
			while(rs.next())
			{
			xmjl=rs.getString("xmjl").toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("查询姓名失败");
		} finally {
			OracleDBCONN.getInstance().close(conn, ps, rs);// 关闭资源
		}
		return xmjl;
	}
	//函数测试
	public static void main(String []args)
	{
		LoginImpl log=new LoginImpl();
		System.out.println(log.findUsernameByUserid("2"));
		System.out.println(log.findDepManagerbyUserid("2"));
		System.out.println(log.findProjectManagerByXMID("20140217155529928002"));
	}




}