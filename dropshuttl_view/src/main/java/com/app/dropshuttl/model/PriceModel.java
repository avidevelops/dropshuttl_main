package com.app.dropshuttl.model;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.dropshuttl.metro.api.MetroApplication;
import com.app.dropshuttl.metro.api.Result;
import com.app.dropshuttl.metro.exception.StationNotFound;

public class PriceModel {
	
	public static void main(String [] arg){
		
		try {
			double fare = new PriceModel().getMetroFair(28.4743879, 77.5039904, 28.349486, 77.065916);
			System.out.println(fare);
		} catch (NumberFormatException | StationNotFound | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getMetroFair(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) throws NumberFormatException, StationNotFound, SQLException{
		MetroApplication app = new MetroApplication();

		ArrayList<Object> toStationData = app.getNearestMetroStationData(toLatitude, toLongitude);
		ArrayList<Object> fromStationData = app.getNearestMetroStationData(fromLatitude, fromLongitude);
		
		Result result = app.getBestMetroRoute(fromStationData.get(0).toString(), toStationData.get(0).toString());
		int fare =  Integer.parseInt(result.getFare());
		
		int toOnFootDistance = ((BigDecimal)fromStationData.get(1)).setScale(0, BigDecimal.ROUND_CEILING).intValue();
		int fromOnFootDistance = ((BigDecimal)toStationData.get(1)).setScale(0, BigDecimal.ROUND_CEILING).intValue();
		
		int onFootDistance = toOnFootDistance + fromOnFootDistance;
		
		int price = onFootDistance*10 + fare;
		
		return price;
	}
	

}
