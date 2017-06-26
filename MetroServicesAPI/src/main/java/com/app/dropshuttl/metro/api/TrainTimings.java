package com.app.dropshuttl.metro.api;

public class TrainTimings
{
  private String id;
  private String isStartTime;
  private String time;
  private String towards;
  
  public TrainTimings() {}
  
  public TrainTimings(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.towards = paramString2;
    this.time = paramString3;
    this.isStartTime = paramString4;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getIsStartTime()
  {
    return this.isStartTime;
  }
  
  public String getTime()
  {
    return this.time;
  }
  
  public String getTowards()
  {
    return this.towards;
  }
  
  public void setTrainTimings(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.towards = paramString2;
    this.time = paramString3;
    this.isStartTime = paramString4;
  }
  
  public String toString()
  {
    return String.format("TrainTimings ::\n ID : %s\n time : %s\n towards : %s\n isStartTime : %s\n", new Object[] { this.id, this.time, this.towards, this.isStartTime });
  }
}
