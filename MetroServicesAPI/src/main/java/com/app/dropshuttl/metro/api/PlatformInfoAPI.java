package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatformInfoAPI
{
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_PLATFORM_ID = "platformId";
  public static final String COLUMN_TOWARDS = "towards1";
  public static final String TABLE_NAME = " PlatformInfo";
  
  public ResultSet getAllPlatformInfo(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("PlatformInfo", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
}


/* Location:              D:\delhiMetro\dex2jar\classes-dex2jar.jar!\com\data\metro\database\PlatformInfoAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */