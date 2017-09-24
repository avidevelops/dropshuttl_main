package com.app.dropshuttl.metro.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetroDbHelper
{
	//private static final String DATABASE_NAME = "DelhiMetroDB.sqlite";
	//private static final int DATABASE_VERSION = 44;
	//private static final String DB_PATH = "D:\\delhiMetro\\Delhi-NCR Metro_5.7_apk-dl.com\\assets\\";
	private static MetroDbHelper sInstance;
	private Connection conn;

	public static boolean checkDataBase()
	{
		boolean bool = false;
		Object connection = null;
		try
		{
			
			//String url = "jdbc:sqlite:D:\\delhiMetro\\Delhi-NCR Metro_5.7_apk-dl.com\\assets\\DelhiMetroDB.sqlite";
			//String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String url = "jdbc:mysql://localhost:3306/dropshuttl_db";
			Connection localConnection = DriverManager.getConnection(url,"admin","admin123");
			connection = localConnection;
			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					((Connection)connection).close();
					bool = true;
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return bool;
	}


	public static MetroDbHelper getInstance()
	{
		try
		{
			if (sInstance == null) {
				sInstance = new MetroDbHelper();
			}
			
			return sInstance;
		}
		finally {}
	}

	public void close()
	{
		try
		{
			if (this.conn != null) {
				try {
					this.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			return;
		}
		finally {}
	}

	public ResultSet fetchData(String paramString1, String[] paramArrayOfString, String paramString2) throws SQLException
	{
		String beforeWhere;
		String sqlQuery;
		if (paramArrayOfString == null)
			beforeWhere = "select * from " + paramString1;
		else{
			beforeWhere = "select " + String.join(",", paramArrayOfString) + " from " + paramString1 ;
		}
		if (paramString2 != null)
			sqlQuery =  beforeWhere + " where " + paramString2;
		else
			sqlQuery = beforeWhere;
		
		Statement select = conn.createStatement();
		return select.executeQuery(sqlQuery);
	}
	
	public ResultSet fetchNearestMetroStation(double latitude, double longitude) throws SQLException
	{
		PreparedStatement ps = conn.prepareStatement("select STATION, DISTANCE from ("
				+ "select * from("
					+ "select STATION, latitude, longitude, CAST(SQRT("
					+ "POWER(69.1 * (CAST(Latitude as DECIMAL(12,6)) - ?), 2) + POWER(69.1 * (? - CAST(longitude as DECIMAL(12,6))) * COS(CAST(latitude as DECIMAL(12,6)) / 57.3), 2)) AS DECIMAL(20,10)) "
					+ "AS DISTANCE FROM MasterTable) s where DISTANCE<15 order by DISTANCE) s limit 1 ");
		
		ps.setDouble(1, latitude);
		ps.setDouble(2, longitude);
		//Statement select = conn.createStatement();
		return ps.executeQuery();
	}

	public void openDataBase()
			throws SQLException
	{
//		OracleDataSource ods = new OracleDataSource();
//        ods.setURL("jdbc:oracle:thin:system/Password123@//localhost:1522/pdborcl.global.XXXXXXXX.com");
//        ods.setUser("hr");
//        ods.setPassword("hr");
		/*String url = "jdbc:oracle:thin:avnkumar/Password123@198.168.0.102:1521:orcl";
		//String url = "jdbc:sqlite:D:\\delhiMetro\\Delhi-NCR Metro_5.7_apk-dl.com\\assets\\DelhiMetroDB.sqlite";
		this.conn = DriverManager.getConnection(url);*/
//		
		String url = "jdbc:mysql://localhost:3306/dropshuttl_db";
		this.conn = DriverManager.getConnection(url,"admin","admin123");
		/*
		ResultSet rs = conn.getMetaData().getTables(null, null, "MASTERTABLE", null);
	while (rs.next()) {
			System.out.println(rs.getString(2));
			
		}*/
	}

	public void updateColumn(String paramString)
	{
		Statement queryStatement;
		try {
			queryStatement = conn.createStatement();
			queryStatement.execute(paramString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*public int updateData(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
	{
		String [] columns = paramContentValues.keySet().toArray(new String[0]);
		String updateColumnString = "";
		String updateQuery="";
		for (String column : columns) {
			if (updateColumnString.equals("")){
				updateColumnString =  column + "='" + paramContentValues.get(column) + "'";
			}else{
				updateColumnString = updateColumnString + "," + column + "='" + paramContentValues.get(column) + "'";
			}	
		}
		if (paramArrayOfString == null) {
			updateQuery = "update " + paramString1 + " set " + updateColumnString + " where " + paramString2;
		}
		
		try {
			Statement update = conn.createStatement();
			return update.executeUpdate(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		//return this.mDb.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
	}*/
}