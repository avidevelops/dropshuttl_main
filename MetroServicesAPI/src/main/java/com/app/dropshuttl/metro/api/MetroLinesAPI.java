package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MetroLinesAPI
{
  public static final String COLUMN_DISTANCE = "DISTANCE";
  public static final String COLUMN_DIVERSIONS = "diversions";
  public static final String COLUMN_DIVERSION_OF = "DIVERSION_OF";
  public static final String COLUMN_EPOINT = "EPOINT";
  public static final String COLUMN_FARE = "FARE";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_NAME = "NAME";
  public static final String COLUMN_NPTIME = "NPTIME";
  public static final String COLUMN_PTIME = "PTIME";
  public static final String COLUMN_SPOINT = "SPOINT";
  public static final String COLUMN_STOPS = "STOPS";
  public static final String TABLE_NAME = " MetroLines";
  
  public ResultSet getAllMetroLines(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData(" MetroLines", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}


/* Location:              D:\delhiMetro\dex2jar\classes-dex2jar.jar!\com\data\metro\database\MetroLinesAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */