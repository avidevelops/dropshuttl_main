package com.app.dropshuttl.metro.api;

import java.sql.ResultSet;

public abstract class ParentAPI
{
  public abstract ResultSet getRecord(MetroDbHelper paramMetroDbHelper, String paramString1, String paramString2);
}

