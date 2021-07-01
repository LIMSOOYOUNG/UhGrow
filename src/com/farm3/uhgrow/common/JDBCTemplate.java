package com.farm3.uhgrow.common;

import java.sql.Statement;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {

	public static Connection getConnection() {

		Connection con = null; // Connection을 지정해주기 위한 선언

		Properties prop = new Properties(); // 경로 지정을 위한 properties 인스턴스 생성

		try {
			prop.load(new FileReader("config/driver.properties")); 	// config/폴더의 driver.properties폴더로부터 파일을 읽어들임
			String driver = prop.getProperty("driver"); 			// driver에 저장된값을 DRIVER로 사용하기 위해 String에 저장
			String url = prop.getProperty("url"); 					// url에 저장된 값을 URL로 사용하기 위에 String에 저장

			Class.forName(driver);

			con = DriverManager.getConnection(url, prop);

			con.setAutoCommit(false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
