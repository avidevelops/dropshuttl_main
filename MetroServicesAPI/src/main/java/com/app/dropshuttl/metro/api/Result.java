package com.app.dropshuttl.metro.api;

import java.util.ArrayList;

public class Result
{
  private String distance;
  private ArrayList<DiversionStation> diversions;
  private String fare;
  private ArrayList<ResultNode> resultStations;
  private String runTime;
  private String stops;
  private int switches;
  
  public Result() {}
  
  public Result(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ArrayList<ResultNode> paramArrayList)
  {
    this.fare = paramString1;
    this.distance = paramString2;
    this.runTime = paramString3;
    this.stops = paramString4;
    this.switches = paramInt;
    setResultStations(paramArrayList);
  }
  
  public void addDiversions(DiversionStation paramDiversionStation)
  {
    if (this.diversions == null) {
      this.diversions = new ArrayList();
    }
    this.diversions.add(paramDiversionStation);
  }
  
  public String getDistance()
  {
    return this.distance;
  }
  
  public ArrayList<DiversionStation> getDiversions()
  {
    return this.diversions;
  }
  
  public String getFare()
  {
    return this.fare;
  }
  
  public ArrayList<ResultNode> getResultStations()
  {
    return this.resultStations;
  }
  
  public String getRunTime()
  {
    return this.runTime;
  }
  
  public String getStops()
  {
    return this.stops;
  }
  
  public int getSwitches()
  {
    return this.switches;
  }
  
  public void setDistance(String paramString)
  {
    this.distance = paramString;
  }
  
  public void setFare(String paramString)
  {
    this.fare = paramString;
  }
  
  public void setResult(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ArrayList<ResultNode> paramArrayList)
  {
    this.fare = paramString1;
    this.distance = paramString2;
    this.runTime = paramString3;
    this.stops = paramString4;
    this.switches = paramInt;
    setResultStations(paramArrayList);
  }
  
  public void setResultStations(ArrayList<ResultNode> paramArrayList)
  {
    this.resultStations = paramArrayList;
  }
  
  public void setRunTime(String paramString)
  {
    this.runTime = paramString;
  }
  
  public void setStops(String paramString)
  {
    this.stops = paramString;
  }
  
  public void setSwitches(int paramInt)
  {
    this.switches = paramInt;
  }
}
