package com.jypmis.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jypmis.exception.MyRuntimeException;

public class OracleDBCONN{
      private static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
      private static final String DBURL="jdbc:oracle:thin:@localhost:1521:ORCL";
      private static final String DBUSERNAME="test";
      private static final String DBPASSWORD="test";
      Connection conn=null;
      private static OracleDBCONN oracleDBCONN; 
    
    	static {
    	  try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("数据库驱动失败",e);
		}
      }
      /**
       * 实例化OracleDBCONN对象
       * @return
       */
    	public static OracleDBCONN getInstance()
      {
    	  if(oracleDBCONN==null)
    	  {
    		 oracleDBCONN=new OracleDBCONN(); 
    	  }
    	  return oracleDBCONN;
      }
    @SuppressWarnings("static-access")
	public Connection getOracleDBCONN()
    {
    	try {
			conn=DriverManager.getConnection(this.DBURL,this.DBUSERNAME,this.DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRuntimeException("数据库连接失败",e);
		}
    	return conn;
    }  
    
	/**
	 * 关闭数据库资源
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
