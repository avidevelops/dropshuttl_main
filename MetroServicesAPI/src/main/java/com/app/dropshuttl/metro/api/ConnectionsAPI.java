package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionsAPI
{
  public static final String COLUMN_CONNECTION = "connection";
  public static final String COLUMN_CONNECTION_COLOR = "connection_color";
  public static final String COLUMN_DISTANCE = "distance";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_TOWARDS = "towards";
  public static final String TABLE_NAME = "Connections";
  
  public ResultSet getAllConnections(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("Connections", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}
