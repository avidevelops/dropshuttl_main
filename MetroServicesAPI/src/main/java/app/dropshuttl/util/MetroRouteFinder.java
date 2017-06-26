package app.dropshuttl.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.app.dropshuttl.metro.api.MetroApplication;
import com.app.dropshuttl.metro.api.MetroDbHelper;
import com.app.dropshuttl.metro.api.Result;
import com.app.dropshuttl.metro.api.ResultNode;
import com.app.dropshuttl.metro.api.StationHelper;
import com.app.dropshuttl.metro.api.StationRoute;
import com.app.dropshuttl.metro.exception.StationNotFound;

public class MetroRouteFinder {

	public static void main(String[] args) throws NumberFormatException, SQLException {

		MetroApplication app = new MetroApplication();
		try {
			ArrayList<Object> arr = app.getNearestMetroStationData(28.4743879, 77.5039904);
			System.out.println(arr);
				
		} catch (StationNotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
//		Result result = app.getBestMetroRoute("Rithala", "Sarai");
//
//		ArrayList<ResultNode> stations = result.getResultStations();
//		String finalMetroRoute = "";
//		for (ResultNode resultNode : stations) {
//			if (finalMetroRoute.equals(""))
//				finalMetroRoute = resultNode.getStation().getName();
//			else
//				finalMetroRoute = finalMetroRoute + "-->" + resultNode.getStation().getName();
//		}
//
//		System.out.println("MetroRoute :" + finalMetroRoute);
//		System.out.println("Total stopage :" + result.getStops());
//		System.out.println("Travel Time :" + result.getRunTime());
//		System.out.println("Fare :" + result.getFare());
//		System.out.println("Metro Line Switches :" + result.getSwitches());
		//System.out.println("Distance :" + result.getDistance());
	}
}