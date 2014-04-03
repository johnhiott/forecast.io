package com.hiott.forecast.library;

import org.json.JSONObject;

public class ForecastRequest {

  public static final String BASE_URL = "https://api.forecast.io/forecast/";
  private String mApiKey;
  private String mUrl;  //base url + api key
  private String mUnits;

  /**
   * @param key Your Forecast.io APIKEY
   */
  ForecastRequest (String key){
    //Default values
    mUnits = "us";
    mApiKey = key;
    mUrl = mUrl + mApiKey + "/";
  }

  /**
   * @param  lat  the latitude of the location
   * @param  lon the longitude of the location
   * @return WeatherResult object
   * @see WeatherResult
   */
  public WeatherResult getCurrentWeather (String lat, String lon){
    WeatherResult result = new WeatherResult();

    return result;
  }

  /**
   *
   * @param lat the latitude of the location
   * @param lon the longitude of the location
   * @param time get weather from a given time. see: https://developer.forecast.io/docs/v2#time_call
   * @return JSONObject
   * @see JSONObject
   */
  public WeatherResult getTimeStampedWeather(String lat, String lon, String time){

    return new WeatherResult();  //REMOVE
  }
}