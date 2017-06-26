package com.app.dropshuttl.metro.api;

public class Connections
{
  private String connection;
  private String connectionColor;
  private String distance;
  private String id;
  private String towards;
  
  public Connections() {}
  
  public Connections(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.connection = paramString2;
    this.distance = paramString3;
    setConnectionColor(paramString4);
  }
  
  public Connections(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.connection = paramString2;
    this.distance = paramString3;
    setTowards(paramString5);
    setConnectionColor(paramString4);
  }
  
  public String getConnection()
  {
    return this.connection;
  }
  
  public String getConnectionColor()
  {
    return this.connectionColor;
  }
  
  public String getDistance()
  {
    return this.distance;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getTowards()
  {
    return this.towards;
  }
  
  public void setConnectionColor(String paramString)
  {
    this.connectionColor = paramString;
  }
  
  public void setConnections(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.connection = paramString2;
    this.distance = paramString3;
    setConnectionColor(paramString4);
  }
  
  public void setTowards(String paramString)
  {
    this.towards = paramString;
  }
  
  public String toString()
  {
    return String.format("Connection ::\n ID : %s\n Connection : %s\n Distance : %s\n", new Object[] { this.id, this.connection, this.distance });
  }
}

