package com.app.dropshuttl.metro.api;

public class DiversionStation
{
  private String destColor;
  private String name;
  private String notSelectedColor;
  private String sourceColor;
  
  public DiversionStation() {}
  
  public DiversionStation(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.name = paramString1;
    this.destColor = paramString2;
    this.sourceColor = paramString3;
    this.notSelectedColor = paramString4;
  }
  
  public String getDestColor()
  {
    return this.destColor;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNotSelectedColor()
  {
    return this.notSelectedColor;
  }
  
  public String getSourceColor()
  {
    return this.sourceColor;
  }
  
  public void setDestColor(String paramString)
  {
    this.destColor = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNotSelectedColor(String paramString)
  {
    this.notSelectedColor = paramString;
  }
  
  public void setSourceColor(String paramString)
  {
    this.sourceColor = paramString;
  }
}


/* Location:              D:\delhiMetro\dex2jar\classes-dex2jar.jar!\com\data\metro\dataobjects\DiversionStation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */