package com.hiott.forecast;

import org.json.JSONObject;

public class WeatherPoint {

  private Integer time;
  private String summary;
  private String icon;
  private float precipIntensity;
  private float precipProbability;
  private String precipType;
  private float temperature;
  private float apparentTemperature;
  private float dewPoint;
  private float humidity;
  private float windSpeed;
  private float windBearing;  // int or float??
  private float visibility;
  private float cloudCover;
  private float pressure;
  private float ozone;

  WeatherPoint(JSONObject weatherPointJson){
    //TODO: set member variables
  }

  public float getOzone() {
    return ozone;
  }

  public float getPressure() {
    return pressure;
  }

  public float getCloudCover() {
    return cloudCover;
  }

  public float getVisibility() {
    return visibility;
  }

  public float getWindBearing() {
    return windBearing;
  }

  public float getWindSpeed() {
    return windSpeed;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getDewPoint() {
    return dewPoint;
  }

  public float getApparentTemperature() {
    return apparentTemperature;
  }

  public float getTemperature() {
    return temperature;
  }

  public String getPrecipType() {
    return precipType;
  }

  public float getPrecipProbability() {
    return precipProbability;
  }

  public float getPrecipIntensity() {
    return precipIntensity;
  }

  public String getIcon() {
    return icon;
  }

  public String getSummary() {
    return summary;
  }

  public Integer getTime() {
    return time;
  }
}