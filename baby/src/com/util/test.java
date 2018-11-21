package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String USERNAME = "scott";
	private static String PASSWORD = "tiger";

	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new test().getCon());
	}

	public static void close(Connection con, Statement sm, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (sm != null) {
				sm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
