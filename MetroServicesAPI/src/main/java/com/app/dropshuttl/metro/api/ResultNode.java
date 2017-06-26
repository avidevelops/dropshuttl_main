package com.app.dropshuttl.metro.api;

import java.util.ArrayList;

public class ResultNode
{
  private ArrayList<String> color;
  private Station station;
  
  public ResultNode() {}
  
  public ResultNode(ArrayList<String> paramArrayList, Station paramStation)
  {
    this.color = paramArrayList;
    this.station = paramStation;
  }
  
  public ArrayList<String> getColor()
  {
    return this.color;
  }
  
  public Station getStation()
  {
    return this.station;
  }
  
  public void setColor(String paramString)
  {
    if (this.color == null) {
      this.color = new ArrayList();
    }
    this.color.add(paramString);
  }
  
  public void setResultNode(ArrayList<String> paramArrayList, Station paramStation)
  {
    this.color = paramArrayList;
    this.station = paramStation;
  }
  
  public void setStation(Station paramStation)
  {
    this.station = paramStation;
  }
}
