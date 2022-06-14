package org.weatherApp.model;

import com.google.gson.Gson;
import javafx.scene.control.TextField;
import org.weatherApp.Config;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class APIFunctionsModel {

    private static String key = new Config().getAPI_KEY();

    //wydzielic wspolny kod dla metod
    public static ActualWeather loadweatherForField(TextField firstCityField) {


        String actualWeatherString = "";
        ActualWeather actualWeather;
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + firstCityField.getText() + "&appid=" + key);
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

                actualWeatherString = actualWeatherJson.toString();
                actualWeather = new Gson().fromJson(actualWeatherString, ActualWeather.class);
                System.out.println("actual weather API : " + actualWeatherString);

                return actualWeather;

            }
        } catch (Exception er) {
            er.printStackTrace();
            System.out.println("errr messafe");
            //w tym  momentcie powinna byc wygenerowana odpowiedz do kontrolera
            //tak zeby uzytkownik wiedzial gdzie jest blad.
        }
        System.out.println("wywlilo mnie z systemu");
        return null;
    }

    public static FiveDaysWeather loadFiveDaysWeather(TextField firstCityField) {

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + firstCityField.getText() + "&appid=" + key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpsResponce code " + responseCode);
            } else {
                StringBuilder fiveDaysWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    fiveDaysWeatherJson.append(scanner.nextLine());
                }
                scanner.close();

                System.out.println("fiveDaysWeatherJson " + fiveDaysWeatherJson);
                String fiveDaysWeatherString = fiveDaysWeatherJson.toString();

                Gson gson = new Gson();
                FiveDaysWeather fiveDaysWeather = new Gson().fromJson(fiveDaysWeatherString, FiveDaysWeather.class);
                return fiveDaysWeather;
            }
        } catch (Exception er) {
            er.printStackTrace();
            System.out.println("errr messafe");
        }
        System.out.println("wywlilo mnie z systemu");
        return null;

    }

    public static HourlyWeather loadHourlyWeather(ActualWeather actualWeather) {


        float lat = actualWeather.getCoordClass().getLat();
        float lon = actualWeather.getCoordClass().getLon();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=current,minutely,alerts,%20daily&appid=" + key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpsResponce code " + responseCode);
            } else {
                StringBuilder hourlyWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    hourlyWeatherJson.append(scanner.nextLine());
                }
                scanner.close();
                String hourlyWeatherJsonString = hourlyWeatherJson.toString();
                HourlyWeather hourlyWeather = new Gson().fromJson(hourlyWeatherJsonString, HourlyWeather.class);

                return hourlyWeather;


            }
        } catch (Exception er) {
            er.printStackTrace();
            System.out.println("errr messafe");
        }
        System.out.println("wywlilo mnie z systemu");
        return null;

    }
}


