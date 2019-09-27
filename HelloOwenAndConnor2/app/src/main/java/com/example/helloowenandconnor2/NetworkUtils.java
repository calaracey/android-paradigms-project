package com.example.helloowenandconnor2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import com.example.helloowenandconnor2.Weather;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class NetworkUtils {
    public static String readAll(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            } // end of while
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }    // end of method


    public static Weather readDataFromJson(String jsonText) {
        JSONObject json = null;
        System.out.println("into read data");
        try {
            System.out.println(jsonText);
            //Object obj = new JSONParser().parse(jsonText);
            json = new JSONObject(jsonText);
            JSONObject main = (JSONObject) json.get("main");
            double temp = (double) main.get("temp");
            int pressure = (int) main.get("pressure");
            int humidity = (int) main.get("humidity");
            int visibility = (int) json.get("visibility");
            JSONObject wind = (JSONObject) json.get("wind");
            double windSpeed = (double) wind.get("speed");
            JSONObject sys = (JSONObject) json.get("sys");
            int sunrise = (int) sys.get("sunrise");
            int sunset = (int) sys.get("sunset");
            JSONArray weatherJSON = (JSONArray) json.get("weather");
            JSONObject weather1 = (JSONObject) weatherJSON.get(0);
            String cloudDescription = (String) weather1.get("description");
            Weather weather = new Weather(temp, cloudDescription, humidity, pressure, visibility, windSpeed, sunrise,sunset);
            System.out.println(weather.toString());
            return weather;
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
    }    // end of method

    public static String getResponseFromHttpUrl(URL url) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            if (scanner.hasNext()) return scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }   // end of method
} // end of class

