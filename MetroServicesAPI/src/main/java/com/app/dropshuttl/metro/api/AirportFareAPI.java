package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportFareAPI
  extends ParentAPI
{
  public static final String COLUMN_STATION_ID = "StationID";
  public static final String TABLE_NAME = "AirportFare";
  
  public ResultSet getAllAirportStationFare(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("AirportFare", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public ResultSet getRecord(MetroDbHelper paramMetroDbHelper, String paramString1, String paramString2)
  {
    paramString2 = '"' + paramString2 + '"';
    paramString1 = "StationID='" + paramString1 + "'";
    try {
		return paramMetroDbHelper.fetchData("AirportFare", new String[] { paramString2 }, paramString1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}
