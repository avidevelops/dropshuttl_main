package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GatesInfoAPI
{
  public static final String COLUMN_GATE = "gate";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_TOWARDS = "towards";
  public static final String TABLE_NAME = "GatesInfo";
  
  public ResultSet getAllGatesInfo(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("GatesInfo", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}
