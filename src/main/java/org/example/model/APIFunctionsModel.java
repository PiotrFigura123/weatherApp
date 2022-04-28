package org.example.model;

import org.example.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class APIFunctionsModel {
    Config config = new Config();

    public static void loadweather(String city) {
        //private List<City> citiesList;
        System.out.println(city);
        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+"11"+"&lon="+"11"+"&appid="+"448b701c42f8e23b59da9f63b5194666");
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            System.out.println("jeste w URL");
        }catch(Exception er){
        er.printStackTrace();
        return;
        }

    }
}
