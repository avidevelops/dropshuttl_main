package com.app.dropshuttl.metro.api;

public class MetroLines
{
  private String distance;
  private String diversionOf;
  private String[] diversions;
  private String ePoint;
  private String fare;
  private String id;
  private String name;
  private String npTime;
  private String pTime;
  private String sPoint;
  private String stops;
  
  public MetroLines() {}
  
  public MetroLines(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String[] paramArrayOfString)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.stops = paramString3;
    this.pTime = paramString4;
    this.npTime = paramString5;
    this.sPoint = paramString6;
    this.ePoint = paramString7;
    this.fare = paramString8;
    this.diversionOf = paramString9;
    this.diversions = paramArrayOfString;
    setDistance(paramString10);
  }
  
  public String getDistance()
  {
    return this.distance;
  }
  
  public String getDiversionOf()
  {
    return this.diversionOf;
  }
  
  public String[] getDiversions()
  {
    return this.diversions;
  }
  
  public String getFare()
  {
    return this.fare;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNpTime()
  {
    return this.npTime;
  }
  
  public String getStops()
  {
    return this.stops;
  }
  
  public String getePoint()
  {
    return this.ePoint;
  }
  
  public String getpTime()
  {
    return this.pTime;
  }
  
  public String getsPoint()
  {
    return this.sPoint;
  }
  
  public void setDistance(String paramString)
  {
    this.distance = paramString;
  }
  
  public void setDiversionOf(String paramString)
  {
    this.diversionOf = paramString;
  }
  
  public void setDiversions(String[] paramArrayOfString)
  {
    this.diversions = paramArrayOfString;
  }
  
  public void setFare(String paramString)
  {
    this.fare = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMetroLines(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.stops = paramString3;
    this.pTime = paramString4;
    this.npTime = paramString5;
    this.sPoint = paramString6;
    this.ePoint = paramString7;
    this.fare = paramString8;
    this.diversionOf = paramString9;
    setDistance(paramString10);
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNpTime(String paramString)
  {
    this.npTime = paramString;
  }
  
  public void setStops(String paramString)
  {
    this.stops = paramString;
  }
  
  public void setePoint(String paramString)
  {
    this.ePoint = paramString;
  }
  
  public void setpTime(String paramString)
  {
    this.pTime = paramString;
  }
  
  public void setsPoint(String paramString)
  {
    this.sPoint = paramString;
  }
}
