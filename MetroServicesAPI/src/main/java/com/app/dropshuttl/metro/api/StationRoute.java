package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class StationRoute
{
    private static final int SORT_BY_FARE = 1;
    private static final int SORT_BY_STOPS = 3;
    private static final int SORT_BY_SWITCHES = 2;
    private static final int SORT_BY_TIME = 0;
    private ArrayList<String> airportEnd;
    private String airportLine;
    private ArrayList<String> airportStart;
    private String end;
    //private AsyncTask<Void, Void, Void> fillDataAsync;
    private boolean isAirportLine;
    //private Context mContext;
    private StationHelper mHelper;
    private OnFillDataListener mListener;
    private ArrayList<Result> resultList;
    private int runTime;
    private int seconds;
    private String start;
    
    public StationRoute(final String start, final String end) {
        this.airportLine = "14";
        // = mContext;
        this.start = start;
        this.end = end;
        this.airportStart = new ArrayList<String>();
        this.airportEnd = new ArrayList<String>();
        this.mHelper = StationHelper.getInstance();
    }
    
    private String calcualteTime(final String s, final String s2, final Station station, final Station station2, String s3, final String s4) throws SQLException {
        MetroDbHelper.getInstance().openDataBase();
        final ResultSet record = new RunTimeAPI().getRecord(MetroDbHelper.getInstance(), s, s2);
        ResultSet cursor;
        String s5 = "0";
        if (record != null && record.isBeforeFirst()) {
        	record.next();
            s5 = record.getString(1);
            record.close();
		}else{
			cursor = new AirportRunTimeAPI().getRecord(MetroDbHelper.getInstance(), s, s2);
            cursor.next();
            s5 = cursor.getString(1);
            cursor.close();
		}

        MetroDbHelper.getInstance().close();
        return this.isTime(s5);
    }
    
//  ResultSet cursor;
//  String s5;
//  if (record != null && !record.isBeforeFirst()) {
//      cursor = record;
//      s5 = s3;
//     // if (record.getCount() == 0) {
//      record.close();
//      final ResultSet cursor2 = cursor = new AirportRunTimeAPI().getRecord(MetroDbHelper.getInstance(), s, s2);
//      s5 = s3;
//      if (cursor2 != null) {
//          cursor = cursor2;
//          s5 = s3;
//          if (cursor2.isBeforeFirst()) {
//          	cursor2.next();
//              s5 = cursor2.getString(1);
//              cursor = cursor2;
//          }
//      }
//      //}
//  }
//  else {
//      cursor = record;
//      s5 = s3;
//      if (record != null) {
//          cursor = record;
//          s5 = s3;
//          if (record.isBeforeFirst()) {
//          	record.next();
//              if (record.getString(1).equals(s2)) {
//                  record.close();
//                  cursor = new AirportRunTimeAPI().getRecord(MetroDbHelper.getInstance(), s, s2);
//                  cursor.next();
//                  s5 = cursor.getString(1);
//              }
//              else {
//                  s5 = new StringBuilder(String.valueOf(2)).toString();
//                  cursor = record;
//              }
//          }
//      }
//  }
  //cursor.close();
    
    private String calculateValue(final ParentAPI parentAPI, final String s, final String s2) throws SQLException {
        final ResultSet record = parentAPI.getRecord(MetroDbHelper.getInstance(), s, s2);
        String string = "";
        if (record.isBeforeFirst()) {
        	record.next();
            string = record.getString(1);
        }
        record.close();
        return this.isTime(string);
    }
    
    private void calculateFareDistanceTime(final String s, final String s2, final Result result) throws SQLException {
        MetroDbHelper.getInstance().openDataBase();
        result.setFare(new StringBuilder(String.valueOf(this.calculateFareTime(s, s2, result, new FareAPI(), new AirportFareAPI()))).toString());
        MetroDbHelper.getInstance().close();
    }
    
    private int calculateFareTime(final String s, final String s2, final Result result, final ParentAPI parentAPI, final ParentAPI parentAPI2) throws NumberFormatException, SQLException {
        int n = 0;
        if (this.isAirportLine) {
            if (!this.start.contentEquals(this.airportStart.get(0))) {
                n = 0 + Integer.parseInt(this.calculateValue(parentAPI, s, this.airportStart.get(0)));
            }
            for (int i = 0; i < this.airportStart.size(); ++i) {
                int n2 = n;
                if (i == 1) {
                    n2 = n + Integer.parseInt(this.calculateValue(parentAPI, this.airportEnd.get(0), this.airportStart.get(i)));
                }
                n = n2 + Integer.parseInt(this.calculateValue(parentAPI2, this.airportStart.get(i), this.airportEnd.get(i)));
            }
            int n3 = n;
            if (!this.airportEnd.get(this.airportEnd.size() - 1).contentEquals(this.end)) {
                n3 = n + Integer.parseInt(this.calculateValue(parentAPI, this.airportEnd.get(this.airportEnd.size() - 1), this.end));
            }
            return n3;
        }
        return Integer.parseInt(this.calculateValue(parentAPI, s, s2));
    }
    
    private String isTime(final String s) {
        if (s.indexOf(":") == -1) {
            return s;
        }
        final String[] split = s.split(":");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        this.seconds += Integer.parseInt(split[2]);
        return new StringBuilder(String.valueOf(int1 * 60 + int2)).toString();
    }
    
    private void traverseStations(final LinkedList<String> list, final String s) {
        final ArrayList<Connections> connections = this.mHelper.getStationById(list.getLast()).getConnections();
        for (int i = 0; i < connections.size(); ++i) {
            if (!list.contains(connections.get(i).getConnection()) && connections.get(i).getConnection().contentEquals(s)) {
                list.add(connections.get(i).getConnection());
                final Result result = new Result();
                final ArrayList<ResultNode> resultStations = new ArrayList<ResultNode>();
                for (int j = 0; j < list.size(); ++j) {
                    final ResultNode resultNode = new ResultNode();
                    resultNode.setStation(this.mHelper.getStationById(list.get(j)));
                    resultStations.add(resultNode);
                }
                result.setResultStations(resultStations);
                if (resultStations.size() <= 50) {
                    this.resultList.add(result);
                }
                list.removeLast();
                break;
            }
        }
        for (int k = 0; k < connections.size(); ++k) {
            if (!list.contains(connections.get(k).getConnection()) && !connections.get(k).getConnection().contentEquals(s)) {
                list.addLast(connections.get(k).getConnection());
                this.traverseStations(list, s);
                list.removeLast();
            }
        }
    }
    
    public void calculateRoute() {
        final LinkedList<String> list = new LinkedList<String>();
        if (this.resultList == null) {
            this.resultList = new ArrayList<Result>();
        }
        else {
            this.resultList.clear();
        }
        list.add(this.start);
        this.traverseStations(list, this.end);
    }
    
   /* public void cancelAsync() {
        if (this.fillDataAsync != null) {
            this.fillDataAsync.cancel(false);
        }
    }*/
    
    public void fillData() throws NumberFormatException, SQLException {
        String name = this.resultList.get(0).getResultStations().get(0).getStation().getName();
        for (int i = 0; i < this.resultList.size(); ++i) {
            this.runTime = 0;
            this.seconds = 0;
            if (!this.airportStart.isEmpty()) {
                this.airportStart.clear();
            }
            if (!this.airportEnd.isEmpty()) {
                this.airportEnd.clear();
            }
            this.isAirportLine = false;
            final Result result = this.resultList.get(i);
            final ArrayList<ResultNode> resultStations = result.getResultStations();
            String s = "";
            for (int j = 0; j < resultStations.size() - 1; ++j) {
                final ResultNode resultNode = resultStations.get(j);
                final Station station = resultNode.getStation();
                final Station station2 = resultStations.get(j + 1).getStation();
                final ArrayList<Connections> connections = station.getConnections();
                String s2;
                String s3;
                for (int k = 0; k < connections.size(); ++k, s = s2, name = s3) {
                    final Connections connections2 = connections.get(k);
                    s2 = s;
                    s3 = name;
                    if (connections2.getConnection().contentEquals(station2.getStationID())) {
                        final String connectionColor = connections2.getConnectionColor();
                        String s4 = null;
                        Label_0292: {
                            if (j != 0) {
                                s4 = s;
                                if (j != resultStations.size() - 1) {
                                    break Label_0292;
                                }
                            }
                            s4 = connectionColor;
                        }
                        this.runTime += Integer.parseInt(this.calcualteTime(station.getStationID(), station2.getStationID(), station, station2, connectionColor, s4));
                        s3 = name;
                        Label_0578: {
                            if (!station.getIsJunction().equals("0")) {
                                final String diversion = this.mHelper.getMetroLines().get(connectionColor).getDiversionOf();
                                s3 = name;
                                if (j != 0) {
                                    s3 = name;
                                    if (!s.equals(connectionColor)) {
                                        final String diversion2 = this.mHelper.getMetroLines().get(s).getDiversionOf();
                                        String name2 = name;
                                        if (!s.equals(diversion)) {
                                            name2 = name;
                                            if (!connectionColor.equals(diversion2)) {
                                                resultNode.setColor(s);
                                                name2 = station.getName();
                                                result.setSwitches(result.getSwitches() + 1);
                                            }
                                        }
                                        if (!s.equals(diversion) && (diversion2.equals("-1") || diversion.equals("-1") || !diversion2.equals(diversion))) {
                                            s3 = name2;
                                            if (!s.equals("")) {
                                                break Label_0578;
                                            }
                                            s3 = name2;
                                            if (!station.getIsJunction().equals("2")) {
                                                break Label_0578;
                                            }
                                        }
                                        final DiversionStation diversionStation = new DiversionStation();
                                        diversionStation.setName(name2);
                                        diversionStation.setSourceColor(s);
                                        diversionStation.setDestColor(connectionColor);
                                        result.addDiversions(diversionStation);
                                        s3 = name2;
                                    }
                                }
                            }
                        }
                        if (connectionColor.contentEquals(this.airportLine)) {
                            this.isAirportLine = true;
                            if (!s.contentEquals(this.airportLine)) {
                                this.airportStart.add(connections2.getId());
                            }
                            if (connections2.getId().equals(this.end) || connections2.getConnection().equals(this.end)) {
                                this.airportEnd.add(this.end);
                            }
                        }
                        else if (s.contentEquals(this.airportLine)) {
                            this.airportEnd.add(connections2.getId());
                        }
                        resultNode.setColor(connectionColor);
                        if (j == resultStations.size() - 2) {
                            resultStations.get(j + 1).setColor(connectionColor);
                        }
                        s2 = connectionColor;
                    }
                }
            }
            if (result.getSwitches() > 4) {
                this.resultList.remove(i);
                --i;
                this.runTime = 0;
                this.seconds = 0;
            }
            else {
                this.runTime += this.seconds / 60 + result.getSwitches() * 3;
                if (this.runTime >= 120) {
                    this.resultList.remove(i);
                    --i;
                    this.runTime = 0;
                    this.seconds = 0;
                }
                else {
                    result.setRunTime(new StringBuilder(String.valueOf(this.runTime)).toString());
                    result.setStops(new StringBuilder(String.valueOf(resultStations.size() - 1)).toString());
                    this.calculateFareDistanceTime(this.start, this.end, result);
                }
            }
        }
    }
    
   /* public void fillDataAsync(final OnFillDataListener mListener) {
        this.mListener = mListener;
        this.fillDataAsync = (AsyncTask<Void, Void, Void>)new FillDataTask((FillDataTask)null).execute((Object[])new Void[0]);
    }*/
    
    public ArrayList<Result> getResultList() {
        return this.resultList;
    }
    
    /*private class FillDataTask extends AsyncTask<Void, Void, Void>
    {
        private void filterRoute() {
            final Result result = StationRoute.this.resultList.get(0);
            int n;
            for (int i = 1; i < StationRoute.this.resultList.size(); i = n + 1) {
                final Result result2 = StationRoute.this.resultList.get(i);
                n = i;
                if (Integer.parseInt(result2.getRunTime()) - Integer.parseInt(result.getRunTime()) > 10) {
                    n = i;
                    if (Integer.parseInt(result2.getFare()) >= Integer.parseInt(result.getFare())) {
                        StationRoute.this.resultList.remove(i);
                        n = i - 1;
                    }
                }
            }
            if (StationRoute.this.start.charAt(0) == '4' || StationRoute.this.end.charAt(0) == '4') {
                Collections.sort((List<Object>)StationRoute.this.resultList, (Comparator<? super Object>)new ResultComparator(3));
            }
            else {
                Collections.sort((List<Object>)StationRoute.this.resultList, (Comparator<? super Object>)new ResultComparator(2));
            }
            if (StationRoute.this.resultList.size() > 2) {
                if (StationRoute.this.resultList.get(0).getFare().equals(StationRoute.this.resultList.get(1).getFare()) && StationRoute.this.resultList.get(0).getRunTime().equals(StationRoute.this.resultList.get(1).getRunTime()) && StationRoute.this.resultList.get(0).getSwitches() == StationRoute.this.resultList.get(1).getSwitches()) {
                    Collections.sort((List<Object>)StationRoute.this.resultList, (Comparator<? super Object>)new ResultComparator(3));
                }
                for (int j = 2; j < StationRoute.this.resultList.size(); ++j) {
                    StationRoute.this.resultList.remove(j);
                }
            }
        }*/
        
        protected Void doInBackground(final Void... array) throws NumberFormatException, SQLException {
            StationRoute.this.calculateRoute();
            StationRoute.this.fillData();
            return null;
        }
        
        /*protected void onPostExecute(final Void void1) {
            super.onPostExecute((Object)void1);
            Collections.sort((List<Object>)StationRoute.this.resultList, (Comparator<? super Object>)new ResultComparator(0));
            this.filterRoute();
            if (StationRoute.this.mListener != null) {
                StationRoute.this.mListener.onComplete(StationRoute.this.resultList);
            }
        }
	}*/    
    
    public class ResultComparator implements Comparator<Result>
    {
        private int sortType;
        
        public ResultComparator(final int sortType) {
            this.sortType = sortType;
        }
        
        public int compare(final Result result, final Result result2) {
            int n = 0;
            int n2 = 0;
            switch (this.sortType) {
                default: {
                    n = Integer.parseInt(result.getRunTime());
                    n2 = Integer.parseInt(result2.getRunTime());
                    break;
                }
                case 0: {
                    n = Integer.parseInt(result.getRunTime());
                    n2 = Integer.parseInt(result2.getRunTime());
                    break;
                }
                case 1: {
                    n = Integer.parseInt(result.getFare());
                    n2 = Integer.parseInt(result2.getFare());
                    break;
                }
                case 2: {
                    n = result.getSwitches();
                    n2 = result2.getSwitches();
                    break;
                }
                case 3: {
                    n = Integer.parseInt(result.getStops());
                    n2 = Integer.parseInt(result2.getStops());
                    break;
                }
            }
            if (n < n2) {
                return -1;
            }
            if (n > n2) {
                return 1;
            }
            return 0;
        }
    }
}
