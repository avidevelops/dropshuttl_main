package com.app.dropshuttl.metro.api;

public class PlatformInfo
{
  private String id;
  private String platformId;
  private String towards;
  
  public PlatformInfo() {}
  
  public PlatformInfo(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.platformId = paramString2;
    this.towards = paramString3;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getPlatformId()
  {
    return this.platformId;
  }
  
  public String getTowards()
  {
    return this.towards;
  }
  
  public void setPlatformInfo(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.platformId = paramString2;
    this.towards = paramString3;
  }
  
  public String toString()
  {
    return String.format("PlatfromInfo ::\n ID : %s\n PlatformId : %s\n Towards : %s\n ", new Object[] { this.id, this.platformId, this.towards });
  }
}
