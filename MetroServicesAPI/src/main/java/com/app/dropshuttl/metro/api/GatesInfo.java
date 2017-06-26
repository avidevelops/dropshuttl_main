package com.app.dropshuttl.metro.api;

public class GatesInfo
{
  private String gate;
  private String id;
  private String towards;
  
  public GatesInfo() {}
  
  public GatesInfo(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.gate = paramString2;
    this.towards = paramString3;
  }
  
  public String getGate()
  {
    return this.gate;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getTowards()
  {
    return this.towards;
  }
  
  public void setGate(String paramString)
  {
    this.gate = paramString;
  }
  
  public void setGatesInfo(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.gate = paramString2;
    this.towards = paramString3;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setTowards(String paramString)
  {
    this.towards = paramString;
  }
  
  public String toString()
  {
    return String.format("GatesInfo ::\n ID : %s\n Gate : %s\n Towards : %s\n ", new Object[] { this.id, this.gate, this.towards });
  }
}
