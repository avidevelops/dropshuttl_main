package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StationsLinesAPI
{
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_ID_LINE = "id_line";
  public static final String TABLE_NAME = "Stations_Lines";
  
  public ResultSet getAllStationLines(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("Stations_Lines", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		return null;
	}
  }
}
