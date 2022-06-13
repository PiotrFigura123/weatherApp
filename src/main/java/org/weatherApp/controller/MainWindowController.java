package org.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.weatherApp.model.APIFunctionsModel;
import org.weatherApp.model.ActualWeather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainWindowController {

    @FXML
    private TextField firstCityField;
    @FXML
    private Label tempCurrentLabel1;
    @FXML
    private Label tempMaxLabel1;
    @FXML
    private Label tempMinLabel1;
    @FXML
    private AnchorPane leftBackgroundPane;
    @FXML
    private ImageView setMainActualWeather1;
    @FXML
    private Label sunriseWindow1Label;
    @FXML
    private Label sunsetWindow1Label;
    @FXML
    private Label day1Window1Day;
    @FXML
    private Label day1Window1Max;
    @FXML
    private Label day1Window1Min;
    @FXML
    private ImageView day1Window1Pisture;
    @FXML
    private Label day2Window1Day;
    @FXML
    private Label day2Window1Max;
    @FXML
    private Label day2Window1Min;
    @FXML
    private ImageView day2Window1Pisture;
    @FXML
    private Label day3Window1Day;
    @FXML
    private Label day3Window1Max;
    @FXML
    private Label day3Window1Min;
    @FXML
    private ImageView day3Window1Pisture;
    @FXML
    private Label day4Window1Day;
    @FXML
    private Label day4Window1Max;
    @FXML
    private Label day4Window1Min;
    @FXML
    private ImageView day4Window1Pisture;
    @FXML
    private Label day5Window1Day;
    @FXML
    private Label day5Window1Max;
    @FXML
    private Label day5Window1Min;
    @FXML
    private ImageView day5Window1Pisture;
    @FXML
    private ScrollPane anchorPaneInScrollPane;
    @FXML
    private AnchorPane scrollPane1;
    @FXML
    private Label windSpeedLabel1;




    @FXML
    void searchFirstCityAction() {
        ActualWeather actualWeather1;
        actualWeather1 = APIFunctionsModel.loadweatherForField(firstCityField);
        displayWeatherForWindow(actualWeather1, setMainActualWeather1, tempCurrentLabel1, tempMaxLabel1, tempMinLabel1, leftBackgroundPane, sunriseWindow1Label, sunsetWindow1Label, windSpeedLabel1);


       // APIFunctionsModel.loadFiveDaysWeather(firstCityField,day1Window1Day,day2Window1Day,day3Window1Day,day4Window1Day,day5Window1Day,
       //         day1Window1Max,day2Window1Max,day3Window1Max,day4Window1Max,day5Window1Max,
       //         day1Window1Min,day2Window1Min,day3Window1Min,day4Window1Min,day5Window1Min,
      //          day1Window1Pisture,day2Window1Pisture, day3Window1Pisture,day4Window1Pisture,day5Window1Pisture,key);

      //  APIFunctionsModel.loadHourlyWeather( anchorPaneInScrollPane,scrollPane1,key);
    }

    private void displayWeatherForWindow(ActualWeather actualWeather, ImageView setMainActualWeather, Label tempCurrentLabel, Label tempMaxLabel1, Label tempMinLabel1, AnchorPane leftBackgroundPane, Label sunriseWindow1Label, Label sunsetWindow1Label, Label windSpeedLabel1) {
       tempCurrentLabel.setText(actualWeather.getActualTemperature().getFeels_like());
        tempMinLabel1.setText(actualWeather.getActualTemperature().getTemp_min());
        tempMaxLabel1.setText(actualWeather.getActualTemperature().getTemp_max());
        windSpeedLabel1.setText(actualWeather.getActualWind().getSpeed());

        setNewBackgroundTheme(actualWeather.weather.get(0).main, leftBackgroundPane);
        setNewWeatherPicture(actualWeather.weather.get(0).icon, setMainActualWeather);
        displaySunriseSunset(actualWeather.getActualSys().getSunrise(), actualWeather.timezone, sunriseWindow1Label);
        displaySunriseSunset(actualWeather.getActualSys().getSunset(), actualWeather.timezone, sunsetWindow1Label);

    }
    private void displaySunriseSunset(long eventTime, long timezone, Label label1ToDisplay) {
        long milis = (eventTime + timezone) * 1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm,a", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedTime = sdf.format(date);
        label1ToDisplay.setText(formattedTime);
    }
    private void setNewBackgroundTheme(String description, AnchorPane backgroundForPane) {

        String link = "/org/weatherApp/images/" + description + "_day_theme.jpg";
        BackgroundImage actualBackgroundImage = new BackgroundImage(new Image(link, 300, 600, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        backgroundForPane.setBackground(new Background(actualBackgroundImage));

    }
    private void setNewWeatherPicture(String icon, ImageView setMainActualWeather) {
        String link = "/org/weatherApp/images/icons/" + icon + "@2x.png";
        Image image = new Image(link);

        setMainActualWeather.setImage(image);
        setMainActualWeather.setScaleX(2);
        setMainActualWeather.setScaleY(2);
    }

    @FXML
    private Label day1Window1Max2;

    @FXML
    private Label tempCurrentLabel2;
    @FXML
    private Label day1Window1Min2;

    @FXML
    private ImageView day1Window1Pisture2;

    @FXML
    private Label day2Window1Max2;

    @FXML
    private Label day2Window1Min2;

    @FXML
    private ImageView day2Window1Pisture2;

    @FXML
    private Label day3Window1Max2;

    @FXML
    private Label day3Window1Min2;

    @FXML
    private ImageView day3Window1Pisture2;

    @FXML
    private Label day4Window1Max2;

    @FXML
    private Label day4Window1Min2;

    @FXML
    private ImageView day4Window1Pisture2;

    @FXML
    private Label day5Window1Max2;

    @FXML
    private Label day5Window1Min2;

    @FXML
    private ImageView day5Window1Pisture2;

    @FXML
    private Label windSpeedLabel2;

    @FXML
    private AnchorPane rightBackgroundPane;

    @FXML
    private AnchorPane scrolePane2;

    @FXML
    private TextField secondCityField;

    @FXML
    private ImageView setMainActualWeather2;

    @FXML
    private Label tempMaxLabel2;

    @FXML
    private Label tempMinLabel2;

    @FXML
    private Label sunriseWindow2Label;
    @FXML
    private Label sunsetWindow2Label;
    @FXML
    private ScrollPane anchorPaneInScrollPane2;
    @FXML
    private AnchorPane scrollPane2;
    @FXML
    void searchSecondCityAction() {
       /* APIFunctionsModel.loadweatherForField(secondCityField, windSpeedLabel2,tempCurrentLabel2,
                tempMaxLabel2,tempMinLabel2,rightBackgroundPane,setMainActualWeather2,sunriseWindow2Label,
                sunsetWindow2Label,key);
        APIFunctionsModel.loadHourlyWeather( anchorPaneInScrollPane2,scrollPane2,key);
*/
    }
}



