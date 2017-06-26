package com.app.dropshuttl.metro.api;

public class StationsLines
{
  private String _id;
  private String id_lines;
  
  public StationsLines(String paramString1, String paramString2)
  {
    this._id = paramString1;
    this.id_lines = paramString2;
  }
  
  public String getId_lines()
  {
    return this.id_lines;
  }
  
  public String get_id()
  {
    return this._id;
  }
  
  public void setStaionsLines(String paramString1, String paramString2)
  {
    this._id = paramString1;
    this.id_lines = paramString2;
  }
  
  public String toString()
  {
    return String.format("StationLines ::\n ID : %s\n IdLine : %s\n", new Object[] { this._id, this.id_lines });
  }
}

