package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RunTimeAPI
  extends ParentAPI
{
  public static final String COLUMN_STATION_NO = "Sno";
  public static final String TABLE_NAME = "RunTime";
  
  public ResultSet getAllAirportStationFare(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("RunTime", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public ResultSet getRecord(MetroDbHelper paramMetroDbHelper, String paramString1, String paramString2)
  {
    paramString2 = "\"" + paramString2 + "\"";
    paramString1 = "Sno='" + paramString1 + "'";
    try {
		return paramMetroDbHelper.fetchData("RunTime", new String[] { paramString2 }, paramString1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public ResultSet getRow(MetroDbHelper paramMetroDbHelper, String paramString)
  {
    try {
		return paramMetroDbHelper.fetchData("RunTime", null, "Sno = '" + paramString + "'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public ResultSet getRow1(MetroDbHelper paramMetroDbHelper, String paramString)
  {
    try {
		return paramMetroDbHelper.fetchData("RunTime", null, "Sno = " + paramString);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}

