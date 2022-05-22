package org.example.model;

import com.google.gson.Gson;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

//import java.lang.runtime.SwitchBootstraps;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class APIFunctionsModel {


    public static void loadweatherForField(TextField firstCityField, Label image, Label tempCurrentLabel1, Label tempMaxLabel1, Label tempMinLabel1, AnchorPane leftBackgroundPane, Label displayActualWeatherLabel, ImageView setMainActualWeather,String key) {


        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+firstCityField.getText()+"&appid="+key);
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


                displayWeatherForWindow(actualWeather, image,tempCurrentLabel1,tempMaxLabel1, tempMinLabel1,leftBackgroundPane,setMainActualWeather);

            }
        }catch(Exception er){
        er.printStackTrace();
        return;
        }

    }

    private static void displayWeatherForWindow(ActualWeather actualWeather, Label image, Label tempCurrentLabel1, Label tempMaxLabel1, Label tempMinLabel1,AnchorPane leftBackgroundPane,ImageView setMainActualWeather) {

        tempCurrentLabel1.setText(actualWeather.getActualTemperature().getFeels_like());
        tempMinLabel1.setText(actualWeather.getActualTemperature().getTemp_min());
        tempMaxLabel1.setText(actualWeather.getActualTemperature().getTemp_max());
        image.setText(actualWeather.getActualWind().getSpeed());

        setNewBackgroundTheme(actualWeather.weather.get(0).main,leftBackgroundPane);
        setNewWeatherPicture(actualWeather.weather.get(0).icon, setMainActualWeather);

    }

    private static void setNewWeatherPicture(String icon, ImageView setMainActualWeather) {
        String link ="/org/example/images/icons/"+icon+"@2x.png";

        System.out.println(link);

        setMainActualWeather.setImage(new Image("/org/example/images/Thunderstorm_day_theme.jpg"));

    }

    private static void setNewBackgroundTheme(String description,AnchorPane backgroundForPane) {

        String link ="";
        switch(description) {
            case "Thunderstorm":
                link = "/org/example/images/Thunderstorm_day_theme.jpg";
                break;
            case "Drizzle":
                link = "/org/example/images/Drizzle_day_theme.jpg";
                break;
            case "Rain":
                link = "/org/example/images/Rainy_day_theme.jpg";
                break;
            case "Snow":
                link = "/org/example/images/Snowy_day_theme.jpg";
                break;
            case "Mist":
                link = "/org/example/images/Mist_day_theme.jpg";
                break;
            case "Clear":
                link = "/org/example/images/Sunny_day_theme.jpg";
                break;
            case "Clouds":
                link = "/org/example/images/Cloudy_day_theme.jpg";
                break;
            default:
                break;
        }
        BackgroundImage actualBackgroundImage = new BackgroundImage(new Image(link,300,600,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        backgroundForPane.setBackground(new Background(actualBackgroundImage));

    }

    public static void loadFiveDaysWeather(TextField firstCityField, String key) {

        try{

            URL url = new URL("api.openweathermap.org/data/2.5/forecast?q="+firstCityField.getText()+"&appid="+key);
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

                //System.out.println(actualWeatherJson);

                //displayWeatherForWindow1(actualWeather, image,tempCurrentLabel1,tempMaxLabel1, tempMinLabel1,leftBackgroundPane,displayActualWeatherLabel);

            }
        }catch(Exception er){
            er.printStackTrace();
            return;
        }

    }
    }

