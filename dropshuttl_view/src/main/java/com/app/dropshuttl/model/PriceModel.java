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
			//double fare = new PriceModel().getMetroFair(28.6081393,77.29474669999999,43.1564609,-77.5938791);
			double fare = new PriceModel().getMetroFair(43.1564609,-77.5938791,28.6081393,77.29474669999999);
			System.out.println(fare);
		} catch (NumberFormatException | StationNotFound | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getMetroFair(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) throws NumberFormatException, StationNotFound, SQLException{
		MetroApplication app = new MetroApplication();
		int price;
		ArrayList<Object> toStationData = app.getNearestMetroStationData(toLatitude, toLongitude);
		ArrayList<Object> fromStationData = app.getNearestMetroStationData(fromLatitude, fromLongitude);
		if (fromStationData.get(0).toString().equals(toStationData.get(0).toString())) {
			price = 30;
			return price;
		}
		Result result = app.getBestMetroRoute(fromStationData.get(0).toString(), toStationData.get(0).toString());
		int fare =  Integer.parseInt(result.getFare());
		
		int toOnFootDistance = ((BigDecimal)fromStationData.get(1)).setScale(0, BigDecimal.ROUND_CEILING).intValue();
		int fromOnFootDistance = ((BigDecimal)toStationData.get(1)).setScale(0, BigDecimal.ROUND_CEILING).intValue();
		
		int onFootDistance = toOnFootDistance + fromOnFootDistance;
		
		price = onFootDistance*10 + fare;
		if (price<30) {
			price = 30;
		}
		
		
		return price;
	}
	

}
