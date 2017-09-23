package com.app.dropshuttle.googleapis;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.app.dropshuttl.controller.UserController;


public class AddressLatitudeLongitude {

	final static Logger logger = Logger.getLogger(UserController.class);
	public String getLatAndLong(String address) throws ParseException{

		String requestUrl="https://maps.googleapis.com/maps/api/geocode/json?address=";
		String api_key="&key=AIzaSyDFuiFYl3dg1bm4xofhWp7sVE3y0dXTgag";
		//String address="Mayur%20Vihar%20Phase%201%20New%20Delhi";
		//String address="Mayur Vihar Phase 1, Delhi";
		address=address.replaceAll(" ","%20");
		double lat=0.0,lng=0.0;
		try {
			JSONParser parser = new JSONParser();
			requestUrl=requestUrl+address+api_key;
		    System.out.println(requestUrl);
			URL url = new URL(requestUrl);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
            conn.setConnectTimeout(5000);
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			Object obj = parser.parse(new InputStreamReader((conn.getInputStream())));;
			JSONObject jsonObject = (JSONObject) obj;
	        JSONArray res=null;
			if(jsonObject.get("results")!=null)
	         res = (JSONArray) jsonObject.get("results");
			@SuppressWarnings("unchecked")
				Iterator<JSONObject> iterator = res.iterator();
	            while (iterator.hasNext()) {
	            	JSONObject json =iterator.next();
	            	JSONObject json2 = (JSONObject) json.get("geometry");
	            	JSONObject json3 = (JSONObject) json2.get("location");
	            	lat =Double.parseDouble(json3.get("lat").toString());
	            	lng =Double.parseDouble(json3.get("lng").toString());
	            	logger.debug("lat "+lat+" lng "+lng);
	            }
		  conn.disconnect();
          } catch (MalformedURLException e) {
                      e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return  lat+","+lng;

		}

	
}
