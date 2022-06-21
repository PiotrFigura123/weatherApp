package org.weatherApp.model;

import com.google.gson.Gson;
import javafx.scene.control.TextField;
import org.weatherApp.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class APIFunctionsModel {

    private static String key = new Config().getAPI_KEY();
    private static String actualWeatherString;
    private static ActualWeather actualWeather;


    public static ActualWeather loadweatherForField(TextField firstCityField) {
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + firstCityField.getText() + "&appid=" + key);
            actualWeatherString = connectToAPI(url);
            return new Gson().fromJson(actualWeatherString, ActualWeather.class);

        } catch (Exception er) {
            System.out.println("zwrot altualnj pogody");
            return null;
        }
    }



    public static FiveDaysWeather loadFiveDaysWeather(TextField firstCityField) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + firstCityField.getText() + "&appid=" + key);
            String fiveDaysWeatherString = connectToAPI(url);
            return new Gson().fromJson(fiveDaysWeatherString, FiveDaysWeather.class);

        } catch (Exception er) {
            System.out.println("catch 5-godzinna prognoza");
            return null;
        }
    }

    public static HourlyWeather loadHourlyWeather(ActualWeather actualWeather) {
        float lat = actualWeather.getCoordClass().getLat();
        float lon = actualWeather.getCoordClass().getLon();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=current,minutely,alerts,%20daily&appid=" + key);
            String hourlyWeatherJsonString = connectToAPI(url);
            return new Gson().fromJson(hourlyWeatherJsonString, HourlyWeather.class);

        } catch (Exception er) {
            System.out.println("catch godzinnna prognoza");
            return null;
        }
    }
    private static String connectToAPI(URL url) throws IOException {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
               throw new RuntimeException("HttpsResponce code " + responseCode);
            } else {
                StringBuilder actualWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    actualWeatherJson.append(scanner.nextLine());
                }
                scanner.close();
                return actualWeatherJson.toString();
            }
        }

}


