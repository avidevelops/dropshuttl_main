package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterTableAPI
{
  public static final String COLUMN_CODE = "Code";
  public static final String COLUMN_ID = "StationId";
  public static final String COLUMN_IS_BUS = "isBus";
  public static final String COLUMN_IS_FEEDER = "isFeeder";
  public static final String COLUMN_IS_JUCTION = "isJunction";
  public static final String COLUMN_IS_PARKING = "isParking";
  public static final String COLUMN_IS_UNDERGROUNG = "isUnderGround";
  public static final String COLUMN_LANDLINE_NO = "LandlineNo";
  public static final String COLUMN_LAT = "Latitude";
  public static final String COLUMN_LONG = "Longitude";
  public static final String COLUMN_MOBILE_NO = "MobileNumber";
  public static final String COLUMN_STATION = "STATION";
  public static final String COLUMN_XCORD = "xCord";
  public static final String COLUMN_YCORD = "yCord";
  public static final String TABLE_NAME = "MasterTable";
  
  public ResultSet getAllStationsData(MetroDbHelper paramMetroDbHelper)
  {
    try {
		return paramMetroDbHelper.fetchData("MasterTable", null, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		return null;
	}
  }
}
