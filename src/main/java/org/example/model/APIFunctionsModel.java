package org.example.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.example.Config;
import com.google.gson.JsonParser;
import org.example.controller.MainWindowController;
import org.example.view.MainWindow;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


public class APIFunctionsModel {


    public static void loadweatherForField(TextField firstCityField, Label image, Label tempCurrentLabel1, Label tempMaxLabel1, Label tempMinLabel1, AnchorPane leftBackgroundPane,Label displayActualWeatherLabel) {
        String key = new Config().getAPI_KEY();

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

                displayWeatherForWindow1(actualWeather, image,tempCurrentLabel1,tempMaxLabel1, tempMinLabel1,leftBackgroundPane,displayActualWeatherLabel);

            }
        }catch(Exception er){
        er.printStackTrace();
        return;
        }

    }

    private static void displayWeatherForWindow1(ActualWeather actualWeather, Label image, Label tempCurrentLabel1, Label tempMaxLabel1, Label tempMinLabel1,AnchorPane leftBackgroundPane,Label displayActualWeatherLabel) {

        tempCurrentLabel1.setText(actualWeather.getActualTemperature().getFeels_like());
        tempMinLabel1.setText(actualWeather.getActualTemperature().getTemp_min());
        tempMaxLabel1.setText(actualWeather.getActualTemperature().getTemp_max());
        image.setText(actualWeather.getActualWind().getSpeed());
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/sun.PNG",80,80,false,false), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        displayActualWeatherLabel.setBackground(new Background(backgroundImage));
       // leftBackgroundPane.setBackground(new Background(backgroundImage));

    }

}
