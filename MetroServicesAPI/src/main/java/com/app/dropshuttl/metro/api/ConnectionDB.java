package com.app.dropshuttl.metro.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	/**
	 * Connect to a sample database
	 * @throws SQLException 
	 */
	public Connection connect() throws SQLException {
		Connection conn = null;
		// db parameters
		String url = "jdbc:sqlite:D:\\delhiMetro\\Delhi-NCR Metro_5.7_apk-dl.com\\assets\\DelhiMetroDB.sqlite";
		// create a connection to the database
		conn = DriverManager.getConnection(url);

		System.out.println("Connection to SQLite has been established.");
		return conn;
	}
}
