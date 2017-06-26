package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NearestStationFinderAPI {
	
	public ResultSet getNearestMetroStation(MetroDbHelper paramaMetroDbHelper, double latitude, double longitude ){
		
		try {
			return paramaMetroDbHelper.fetchNearestMetroStation(latitude, longitude);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
