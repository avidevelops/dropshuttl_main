package com.app.dropshuttl.metro.api;

import java.util.ArrayList;

public class Station
{
  private String code;
  private ArrayList<Connections> connections;
  private float currentDistance;
  private ArrayList<GatesInfo> gatesInfo;
  private String isBus;
  private String isFeeder;
  private String isJunction;
  private String isParking;
  private String isUnderground;
  private String landlineNo;
  private String lat;
  private String longt;
  private String mobileNo;
  private String name;
  private ArrayList<PlatformInfo> platformInfo;
  private String stationAVM;
  private String stationID;
  private ArrayList<StationsLines> stationLines;
  private ArrayList<TrainTimings> trainTimings;
  private int xCord;
  private int yCord;
  
  public Station() {}
  
  public Station(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2, String paramString11, String paramString12)
  {
    this.stationID = paramString1;
    this.isBus = paramString2;
    this.landlineNo = paramString3;
    this.mobileNo = paramString4;
    this.isFeeder = paramString5;
    this.isParking = paramString6;
    this.name = paramString7;
    this.code = paramString8;
    this.lat = paramString9;
    this.longt = paramString10;
    this.xCord = paramInt1;
    this.yCord = paramInt2;
    this.isUnderground = paramString11;
    this.isJunction = paramString12;
  }
  
  public Station(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2, String paramString11, String paramString12, ArrayList<StationsLines> paramArrayList, ArrayList<Connections> paramArrayList1, ArrayList<PlatformInfo> paramArrayList2, ArrayList<TrainTimings> paramArrayList4, ArrayList<GatesInfo> paramArrayList5)
  {
    this.stationID = paramString1;
    this.isBus = paramString2;
    this.landlineNo = paramString3;
    this.mobileNo = paramString4;
    this.isFeeder = paramString5;
    this.isParking = paramString6;
    this.name = paramString7;
    this.code = paramString8;
    this.lat = paramString9;
    this.longt = paramString10;
    this.xCord = paramInt1;
    this.yCord = paramInt2;
    this.isUnderground = paramString11;
    this.isJunction = paramString12;
    this.stationLines = paramArrayList;
    this.connections = paramArrayList1;
    this.platformInfo = paramArrayList2;
    this.trainTimings = paramArrayList4;
    this.gatesInfo = paramArrayList5;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public ArrayList<Connections> getConnections()
  {
    if (this.connections == null) {
      this.connections = new ArrayList();
    }
    return this.connections;
  }
  
  public float getCurrentDistance()
  {
    return this.currentDistance;
  }
  
  public ArrayList<GatesInfo> getGatesInfo()
  {
    return this.gatesInfo;
  }
  
  public String getIsBus()
  {
    return this.isBus;
  }
  
  public String getIsFeeder()
  {
    return this.isFeeder;
  }
  
  public String getIsJunction()
  {
    return this.isJunction;
  }
  
  public String getIsParking()
  {
    return this.isParking;
  }
  
  public String getIsUnderground()
  {
    return this.isUnderground;
  }
  
  public String getLandlineNo()
  {
    return this.landlineNo;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLongt()
  {
    return this.longt;
  }
  
  public String getMobileNo()
  {
    return this.mobileNo;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public ArrayList<PlatformInfo> getPlatformInfo()
  {
    return this.platformInfo;
  }
  
  public String getStationAVM()
  {
    return this.stationAVM;
  }
  
  public String getStationID()
  {
    return this.stationID;
  }
  
  public ArrayList<StationsLines> getStationLines()
  {
    return this.stationLines;
  }
  
  public ArrayList<TrainTimings> getTrainTimings()
  {
    return this.trainTimings;
  }
  
  public int getxCord()
  {
    return this.xCord;
  }
  
  public int getyCord()
  {
    return this.yCord;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setConnections(ArrayList<Connections> paramArrayList)
  {
    this.connections = paramArrayList;
  }
  
  public void setCurrentDistance(float paramFloat)
  {
    this.currentDistance = paramFloat;
  }
  
  public void setGatesInfo(ArrayList<GatesInfo> paramArrayList)
  {
    this.gatesInfo = paramArrayList;
  }
  
  public void setIsBus(String paramString)
  {
    this.isBus = paramString;
  }
  
  public void setIsFeeder(String paramString)
  {
    this.isFeeder = paramString;
  }
  
  public void setIsJunction(String paramString)
  {
    this.isJunction = paramString;
  }
  
  public void setIsParking(String paramString)
  {
    this.isParking = paramString;
  }
  
  public void setIsUnderground(String paramString)
  {
    this.isUnderground = paramString;
  }
  
  public void setLandlineNo(String paramString)
  {
    this.landlineNo = paramString;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLongt(String paramString)
  {
    this.longt = paramString;
  }
  
  public void setMobileNo(String paramString)
  {
    this.mobileNo = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPlatformInfo(ArrayList<PlatformInfo> paramArrayList)
  {
    this.platformInfo = paramArrayList;
  }
  
  public void setStation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2, String paramString11, String paramString12, ArrayList<StationsLines> paramArrayList, ArrayList<Connections> paramArrayList1, ArrayList<PlatformInfo> paramArrayList2, ArrayList<TrainTimings> paramArrayList4, ArrayList<GatesInfo> paramArrayList5)
  {
    this.stationID = paramString1;
    this.isBus = paramString2;
    this.landlineNo = paramString3;
    this.mobileNo = paramString4;
    this.isFeeder = paramString5;
    this.isParking = paramString6;
    this.name = paramString7;
    this.code = paramString8;
    this.lat = paramString9;
    this.longt = paramString10;
    this.xCord = paramInt1;
    this.yCord = paramInt2;
    this.isUnderground = paramString11;
    this.isJunction = paramString12;
    this.stationLines = paramArrayList;
    this.connections = paramArrayList1;
    this.platformInfo = paramArrayList2;
    this.trainTimings = paramArrayList4;
    this.gatesInfo = paramArrayList5;
  }
  
  public void setStationAVM(String paramString)
  {
    this.stationAVM = paramString;
  }
  
  public void setStationID(String paramString)
  {
    this.stationID = paramString;
  }
  
  public void setStationLines(ArrayList<StationsLines> paramArrayList)
  {
    this.stationLines = paramArrayList;
  }
  
  public void setTrainTimings(ArrayList<TrainTimings> paramArrayList)
  {
    this.trainTimings = paramArrayList;
  }
  
  public void setxCord(int paramInt)
  {
    this.xCord = paramInt;
  }
  
  public void setyCord(int paramInt)
  {
    this.yCord = paramInt;
  }
  
  public String toString()
  {
    return this.name;
  }
}
