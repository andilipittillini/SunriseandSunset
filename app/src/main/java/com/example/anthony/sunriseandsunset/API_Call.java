package com.example.anthony.sunriseandsunset;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class API_Call {
    public static void main(String[] args) {
        try {
            API_Call.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {
        String url = "https://api.sunrise-sunset.org/json?lat=70&lng=90&date=2017-01-01";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        String myResponse = response.toString();
        in.close();
        //print in String
        System.out.println(myResponse);
        myResponse = myResponse.substring(11);
        myResponse = myResponse.substring(0, myResponse.length() - 15);
        System.out.println(myResponse);
        Map jsonJavaRootObject1 = new Gson().fromJson(myResponse, Map.class);
        String sunrise = "Sun Rise At " + jsonJavaRootObject1.get("sunrise").toString();
        String sunset = "Sun Set At " + jsonJavaRootObject1.get("sunset").toString();
        String solarnoon = "Solar Noon is At " + jsonJavaRootObject1.get("solar_noon").toString();
        String daylength = "Daylength is " + jsonJavaRootObject1.get("day_length").toString() + " (Hour, Min)";
        String civiltwilightbegin = "Civil Twilight Begins At " + jsonJavaRootObject1.get("civil_twilight_begin").toString();
        String civiltwilightend = "Civil Twilight Ends At " + jsonJavaRootObject1.get("civil_twilight_end").toString();
        String nauticaltwilightbegin = "Nautical Twilight Begins At " + jsonJavaRootObject1.get("nautical_twilight_begin").toString();
        String nauticaltwilightend = "Nautical Twilight Ends At " + jsonJavaRootObject1.get("nautical_twilight_end").toString();
        String astronomicaltwilightbegin = "Astronomical Twilight Begins At " + jsonJavaRootObject1.get("astronomical_twilight_begin").toString();
        String astronomicaltwilightend = "Astronomical Twilight Ends At " + jsonJavaRootObject1.get("astronomical_twilight_end").toString();


        System.out.println(sunrise);
        System.out.println(sunset);
        System.out.println(solarnoon);
        System.out.println(daylength);
        System.out.println(civiltwilightbegin);
        System.out.println(civiltwilightend);
        System.out.println(nauticaltwilightbegin);
        System.out.println(nauticaltwilightend);
        System.out.println(astronomicaltwilightbegin);
        System.out.println(astronomicaltwilightend);

    }
}

