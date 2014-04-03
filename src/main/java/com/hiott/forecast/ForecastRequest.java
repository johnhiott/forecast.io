package com.hiott.forecast;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
    mUrl = mUrl + mApiKey + "/";
  }

  /**
   * @param  lat  the latitude of the location
   * @param  lon the longitude of the location
   * @return WeatherResult object
   * @see WeatherResult
   */
  public WeatherResult getCurrentWeather (String lat, String lon){

    int status;
    JSONObject jsonWeatherData = null;
    String responseData = "";

    try{
      URL url = new URL(mUrl + lat + "," + lon);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.connect();
      status = connection.getResponseCode();

      if (status == HttpURLConnection.HTTP_OK){
        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);
        char[] charArray = new char[connection.getContentLength()];
        reader.read(charArray);
        responseData = new String(charArray);

        jsonWeatherData = new JSONObject(responseData);

      }else{
      }
    }catch(MalformedURLException e){
    }catch(IOException e){
    }catch (Exception e){
    }

    WeatherResult result = new WeatherResult(jsonWeatherData);

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

    return new WeatherResult(new JSONObject());  //REMOVE
  }
}