package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainTimingsAPI
{
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_IS_START_TIME = "isStartTime";
  public static final String COLUMN_TIME = "time";
  public static final String COLUMN_TOWARDS = "towards";
  public static final String TABLE_NAME = "TrainTimings";
  
  public ResultSet getAllTrainTimings(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("TrainTimings", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}
