package org.example.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.example.Config;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class APIFunctionsModel {
    static String key = new Config().getAPI_KEY();

    public static void loadweather(String city) {

        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key);
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode !=200 ){
                throw new RuntimeException("HttpsResponce code " + responseCode);
            }else{
                StringBuilder actualWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while  (scanner.hasNext()){
                    actualWeatherJson.append(scanner.nextLine());
                }
                scanner.close();

                String actualWeatherString = actualWeatherJson.toString();
                System.out.println(actualWeatherString);
                Gson gson = new Gson();
                ActualWeather actualWeather = new Gson().fromJson(actualWeatherString,ActualWeather.class);

            }
        }catch(Exception er){
        er.printStackTrace();
        return;
        }

    }
}
