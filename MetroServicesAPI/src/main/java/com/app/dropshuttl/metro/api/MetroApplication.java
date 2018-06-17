/**
* The MetroAPplication program implements an application that
* returns Metro path between to stations.
*
* @author  Avnessh Kumar
* @version 1.0
* @since   2017-06-25 
*/
package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.app.dropshuttl.metro.exception.StationNotFound;

public class MetroApplication {
	
	private ArrayList<Object> nearestStation;
	
	public Result getBestMetroRoute(String stationFrom, String stationTo) throws StationNotFound, NumberFormatException, SQLException{
		StationHelper stationHelper = StationHelper.getInstance();
		stationHelper.fillData();
		String toStationID = StationHelper.getInstance().ifStationExists(stationFrom);
		if (toStationID == null) {
			throw new StationNotFound(stationFrom + " Not found");
		}
		String fromStationID = StationHelper.getInstance().ifStationExists(stationTo);
		if (fromStationID == null) {
			throw new StationNotFound(stationFrom + " Not found");
		}
		
		StationRoute route = new StationRoute(toStationID, fromStationID);
		route.calculateRoute();
		route.fillData();
		ArrayList<Result> results = route.getResultList();

		
		return Collections.max(results, new CompareRouteTime());
	}
	
	public ArrayList<Object> getNearestMetroStationData(double latitude, double longitude) throws StationNotFound, NumberFormatException, SQLException{
		try {
			nearestStation = new ArrayList<Object>();
			MetroDbHelper.getInstance().openDataBase();
			ResultSet rs =new NearestStationFinderAPI().getNearestMetroStation(MetroDbHelper.getInstance(), latitude, longitude);
			if (rs.isBeforeFirst()) {
				rs.next();
				nearestStation.add(rs.getString(rs.findColumn("STATION")));
				nearestStation.add(rs.getObject(rs.findColumn("DISTANCE")));
				nearestStation.add(rs.getString(rs.findColumn("STATIONID")));
			}else{
				MetroDbHelper.getInstance().close();
				throw new StationNotFound("No station found with 15 km please try another transport");
			}

			rs.close();
			MetroDbHelper.getInstance().close();
			return nearestStation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int getFare(String fromStationID, String toStationID) throws SQLException{
		ResultSet rs=null;
		try {
			MetroDbHelper.getInstance().openDataBase();
			rs = new FareAPI().getRecord(MetroDbHelper.getInstance(), fromStationID, toStationID);
			if (rs.isBeforeFirst()) {
				rs.next();
				return Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			MetroDbHelper.getInstance().close();
		}
		return -1;
	}
	
	private class CompareRouteTime implements Comparator<Result> {
	    public int compare(Result a, Result b) {
	        if (Integer.parseInt(a.getRunTime()) > Integer.parseInt(b.getRunTime()))
	            return -1; // highest value first
	        if (a.getRunTime().equals(b.getRunTime()))
	            return 0;
	        return 1;
	    }
	}
}


