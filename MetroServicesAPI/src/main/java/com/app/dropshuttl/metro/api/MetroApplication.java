/**
* The MetroAPplication program implements an application that
* returns Metro path between to stations.
*
* @author  Avnessh Kumar
* @version 1.0
* @since   2017-06-25 
*/
package com.app.dropshuttl.metro.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.app.dropshuttl.metro.exception.StationNotFound;

public class MetroApplication {
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
		StationHelper stationHelper = StationHelper.getInstance();
		return stationHelper.getNearestStation(latitude, longitude);
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


