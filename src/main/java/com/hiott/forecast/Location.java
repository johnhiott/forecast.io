package com.hiott.forecast;

public class Location{
  private float lat;
  private float lon;

  Location(float lat, float lon){
    this.lon = lon;
    this.lat = lat;
  }

  public float getLat(){
    return lat;
  }
  public float getLon(){
    return lon;
  }
  public void setLat(float lat){
    this.lat = lat;
  }
  public void setLon(float lon){
    this.lon = lon;
  }
}