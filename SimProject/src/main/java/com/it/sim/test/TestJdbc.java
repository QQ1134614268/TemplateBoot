package com.it.sim.test;

import org.junit.Test;

import java.sql.*;

public class TestJdbc {

	static class JdbcDao {

		protected static String dbClassName = "com.mysql.jdbc.Driver";// MySQL数据库驱动类的名称
		protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/test";// 访问MySQL数据库的路径
		protected static String dbUser = "root";// 访问MySQL数据库的用户名
		protected static String dbPwd = "123456";// 访问MySQL数据库的密码
		public static Connection conn = null;// MySQL数据库的连接对象

		static {// 静态初始化Dao类
			try {
				Class.forName(dbClassName).newInstance();// 实例化MySQL数据库的驱动
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// 连接MySQL数据库
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);// 系统停止运行
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private JdbcDao() {
		}

		public static String selectVersion() throws SQLException {
			String string = null;
			String sql = "select version()";
			try (Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					string = rs.getString(1);
				}
			}
			return string;
		}
	}

	@Test
	public void main() {
		try {
			String version = JdbcDao.selectVersion();
			System.err.println(version);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
