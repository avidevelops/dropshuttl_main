package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.util.StringUtils;

import com.app.dropshuttl.metro.exception.StationNotFound;

public class StationHelper
{
	private static StationHelper mInstance;
	private ExecutorService executor;
	/* private Context mContext;
  private OnDataQueryListener mListener;*/
	private HashMap<String, MetroLines> metroLines;
	private ArrayList<Station> stationList;

	public StationHelper()
	{
		this.stationList = new ArrayList();
		this.metroLines = new HashMap();
	}

	private void getConnections(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("connection"));
					String str3 = paramCursor.getString(paramCursor.findColumn("distance"));
					String str4 = paramCursor.getString(paramCursor.findColumn("connection_color"));
					String str5 = paramCursor.getString(paramCursor.findColumn("towards"));
					getStationById(str1).getConnections().add(new Connections(str1, str2, str3, str4, str5));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void getGatesInfo(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("gate"));
					String str3 = paramCursor.getString(paramCursor.findColumn("towards"));
					Station stationById = this.getStationById(str1);
					ArrayList<GatesInfo> gatesInfo = stationById.getGatesInfo();
					if (gatesInfo == null) {
						gatesInfo = new ArrayList<GatesInfo>();
					}
					gatesInfo.add(new GatesInfo(str1, str2, str3));
					stationById.setGatesInfo(gatesInfo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static StationHelper getInstance()
	{
		if (StationHelper.mInstance == null) {
			StationHelper.mInstance = new StationHelper();
		}
		return StationHelper.mInstance;
	}

	private void getMetroLines(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("NAME"));
					String str3 = paramCursor.getString(paramCursor.findColumn("DISTANCE"));
					String str4 = paramCursor.getString(paramCursor.findColumn("STOPS"));
					String str5 = paramCursor.getString(paramCursor.findColumn("PTIME"));
					String str6 = paramCursor.getString(paramCursor.findColumn("NPTIME"));
					String str7 = paramCursor.getString(paramCursor.findColumn("SPOINT"));
					String str8 = paramCursor.getString(paramCursor.findColumn("EPOINT"));
					String str9 = paramCursor.getString(paramCursor.findColumn("FARE"));
					String str10 = paramCursor.getString(paramCursor.findColumn("DIVERSION_OF"));
					String str11 = paramCursor.getString(paramCursor.findColumn("diversions"));
					String[] split = null;
					if (!StringUtils.isEmpty((CharSequence)str11)) {
						split = str11.split(",");
					}
					this.metroLines.put(str1, new MetroLines(str1, str2, str4, str5, str6, str7, str8, str9, str10, str3, split));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getPlatforms(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("platformId"));
					String str3 = paramCursor.getString(paramCursor.findColumn("towards1"));
					Station stationById = getStationById(str1);
					ArrayList<PlatformInfo> platformInfo;
					if ((platformInfo = stationById.getPlatformInfo()) == null) {
						platformInfo = new ArrayList<PlatformInfo>();
					}
					platformInfo.add(new PlatformInfo(str1, str2, str3));
					stationById.setPlatformInfo(platformInfo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getStationLines(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("id_line"));
					/*if (str1.equals("301")) {
						System.out.println("null caught");
					}*/
					final Station stationById = this.getStationById(str1);
					ArrayList<StationsLines> stationLines;
					
					if ((stationLines = stationById.getStationLines()) == null) {
						stationLines = new ArrayList<StationsLines>();
					}
					stationLines.add(new StationsLines(str1, str2));
					stationById.setStationLines(stationLines);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getTrainTimings(ResultSet paramCursor)
	{
		try {
			if (paramCursor.isBeforeFirst()) {
				while (paramCursor.next())
				{
					String str1 = paramCursor.getString(paramCursor.findColumn("StationId"));
					String str2 = paramCursor.getString(paramCursor.findColumn("towards"));
					String str3 = paramCursor.getString(paramCursor.findColumn("time"));
					String str4 = paramCursor.getString(paramCursor.findColumn("isStartTime"));
					final Station stationById = getStationById(str1);
					ArrayList<TrainTimings> trainTimings;
					if ((trainTimings = stationById.getTrainTimings()) == null) {
						trainTimings = new ArrayList<TrainTimings>();
					}
					trainTimings.add(new TrainTimings(str1, str2, str3, str4));
					stationById.setTrainTimings(trainTimings);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelFilling()
	{
		if (this.executor != null) {
			this.executor.shutdownNow();
		}
	}

	public void fillData()
	{
		try{  
			MetroDbHelper.getInstance().openDataBase();
			ResultSet localObject1 = new MasterTableAPI().getAllStationsData(MetroDbHelper.getInstance());

			while (localObject1.next())
			{
				Object localObject2 = localObject1.getString(((ResultSet)localObject1).findColumn("StationId")).trim();
				String str1 = localObject1.getString(((ResultSet)localObject1).findColumn("STATION"));
				String str2 = localObject1.getString(((ResultSet)localObject1).findColumn("isBus"));
				String str3 = localObject1.getString(((ResultSet)localObject1).findColumn("LandlineNo"));
				String str4 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("MobileNumber"));
				String str5 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("Latitude"));
				String str6 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("Longitude"));
				String str7 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("isFeeder"));
				String str8 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("isParking"));
				String str9 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("Code"));
				String str10 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("isJunction"));
				int i = 0;
				int k = 0;

				int j = Integer.parseInt(((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("xCord")));
				i = j;
				int m = Integer.parseInt(((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("yCord")));
				k = m;
				i = j;

				String str11 = ((ResultSet)localObject1).getString(((ResultSet)localObject1).findColumn("isUnderGround"));
				Station station = new Station(((String)localObject2).trim(), str2, str3, str4, str7, str8, str1, str9, str5, str6, i, k, str11, str10);
				this.stationList.add(station);
			} ;
			((ResultSet)localObject1).close();

			localObject1 = new StationsLinesAPI().getAllStationLines(MetroDbHelper.getInstance());
			getStationLines((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			localObject1 = new ConnectionsAPI().getAllConnections(MetroDbHelper.getInstance());
			getConnections((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			localObject1 = new PlatformInfoAPI().getAllPlatformInfo(MetroDbHelper.getInstance());
			getPlatforms((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			localObject1 = new TrainTimingsAPI().getAllTrainTimings(MetroDbHelper.getInstance());
			getTrainTimings((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			localObject1 = new MetroLinesAPI().getAllMetroLines(MetroDbHelper.getInstance());
			getMetroLines((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			localObject1 = new GatesInfoAPI().getAllGatesInfo(MetroDbHelper.getInstance());
			getGatesInfo((ResultSet)localObject1);
			((ResultSet)localObject1).close();
			MetroDbHelper.getInstance().close();
			return;
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void fillDataAsync()
	{
		executor = Executors.newFixedThreadPool(10);
		Runnable asyncFill = new FillDataTask();
		executor.execute(asyncFill);
	}

	public MetroLines getMetroLineByID(String paramString)
	{
		return (MetroLines)this.metroLines.get(paramString);
	}

	public HashMap<String, MetroLines> getMetroLines()
	{
		return this.metroLines;
	}

	public Station getStationById(String paramString)
	{
		for (int i = 0; i < this.stationList.size(); ++i) {
			if (paramString.trim().contentEquals(this.stationList.get(i).getStationID())) {
				return this.stationList.get(i);
			}
		}
		return null;
	}

	public ArrayList<Station> getStationsList()
	{
		return this.stationList;
	}

	public String ifStationExists(String paramString)
	{
		for (int i = 0; i < this.stationList.size(); ++i) {
			if (paramString.contentEquals(this.stationList.get(i).getName())) {
				return this.stationList.get(i).getStationID();
			}
		}
		return null;
	}

	public boolean isChildLine(String paramString1, String paramString2)
	{
		return paramString1.equals(((MetroLines)this.metroLines.get(paramString2)).getDiversionOf());
	}

	public boolean isDiversionOfSameLine(String paramString1, String paramString2)
	{
		return ((MetroLines)this.metroLines.get(paramString1)).getDiversionOf().equals(((MetroLines)this.metroLines.get(paramString2)).getDiversionOf());
	}

	private class FillDataTask implements Runnable
	{
		private FillDataTask() {}

		public void run() {
			StationHelper.this.fillData();
		}
	}
}

