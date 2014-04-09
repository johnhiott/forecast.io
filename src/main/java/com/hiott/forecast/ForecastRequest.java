package com.hiott.forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
    mUrl = BASE_URL + mApiKey + "/";
  }

  /**
   * @param  lat  the latitude of the location
   * @param  lon the longitude of the location
   * @return WeatherResult object
   * @see WeatherResult
   */
  public WeatherResult getCurrentWeather (String lat, String lon){

    String url = mUrl + lat + "," + lon;
    WeatherResult result = null;

    try {
      JSONObject jsonWeatherData = new JSONObject(doHttpRequest(url));
      result = new WeatherResult(jsonWeatherData);
    } catch (JSONException e) {
    }
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
    String url = mUrl + "lat" + "," + lon + "," + time;
    WeatherResult result = null;

    try {
      JSONObject jsonWeatherData = new JSONObject(doHttpRequest(url));
      result = new WeatherResult(jsonWeatherData);
    } catch (JSONException e) {
    }
    return result;
  }

  /*
    Perform an HTTP Request as return a string of the response
   */
  private String doHttpRequest(String _url){
    StringBuffer response = new StringBuffer();

    try{
      URL url = new URL(_url);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.connect();

      BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
      String inputLine;

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }

      in.close();

    }catch (MalformedURLException e){

    }catch (IOException e){

    }catch (Exception e){

    }
    return response.toString();
  }
}