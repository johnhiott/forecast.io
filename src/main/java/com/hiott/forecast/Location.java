package com.hiott.forecast;

public class Location{
  private float lat;
  private float lon;

  Location(String lat, String lon){
    this.lon = Float.parseFloat(lon);
    this.lat = Float.parseFloat(lat);
  }

  public float getLat(){
    return lat;
  }
  public float getLon(){
    return lon;
  }
}