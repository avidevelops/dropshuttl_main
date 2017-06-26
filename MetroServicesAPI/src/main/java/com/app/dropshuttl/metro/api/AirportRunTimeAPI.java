package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportRunTimeAPI
  extends ParentAPI
{
  public static final String COLUMN_STATION_ID = "station_id";
  public static final String TABLE_NAME = "AirportRunTime";
  
  public ResultSet getAllAirportStationTime(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("AirportRunTime", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public ResultSet getRecord(MetroDbHelper paramMetroDbHelper, String paramString1, String paramString2)
  {
    paramString2 = '"' + paramString2 + '"';
    paramString1 = "station_id='" + paramString1 + "'";
    try {
		return paramMetroDbHelper.fetchData("AirportRunTime", new String[] { paramString2 }, paramString1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}
