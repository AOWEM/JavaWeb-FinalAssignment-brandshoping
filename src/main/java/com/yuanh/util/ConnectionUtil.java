package com.yuanh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {
	private ConnectionUtil() {}
	private static final ConnectionUtil connectionUtil = new ConnectionUtil();

	private String url = "jdbc:mysql://localhost:3306/user?useSSL=true&characterEncoding=utf-8"; //数据链接
	private String user = "root"; //用户名
	private String password = "123456"; //密码

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //数据库驱动
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return connectionUtil;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//调用释放
	public void close(Connection conn) {
		close(conn, null, null);
	}
	public void close(Connection conn,PreparedStatement ps) {
		close(conn, ps, null);
	}
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}

