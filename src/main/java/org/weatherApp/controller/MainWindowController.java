package org.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.weatherApp.Config;
import org.weatherApp.model.APIFunctionsModel;

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
    private Label displayActualWeatherLabel;
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


    private String key = new Config().getAPI_KEY();
    @FXML
    void searchFirstCityAction() {

        APIFunctionsModel.loadweatherForField(firstCityField, windSpeedLabel1,tempCurrentLabel1,
                tempMaxLabel1,tempMinLabel1,leftBackgroundPane,setMainActualWeather1,sunriseWindow1Label,
                sunsetWindow1Label,key);
        APIFunctionsModel.loadFiveDaysWeather(firstCityField,day1Window1Day,day2Window1Day,day3Window1Day,day4Window1Day,day5Window1Day,
                day1Window1Max,day2Window1Max,day3Window1Max,day4Window1Max,day5Window1Max,
                day1Window1Min,day2Window1Min,day3Window1Min,day4Window1Min,day5Window1Min,
                day1Window1Pisture,day2Window1Pisture, day3Window1Pisture,day4Window1Pisture,day5Window1Pisture,key);

        APIFunctionsModel.loadHourlyWeather( anchorPaneInScrollPane,scrollPane1,key);
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
        APIFunctionsModel.loadweatherForField(secondCityField, windSpeedLabel2,tempCurrentLabel2,
                tempMaxLabel2,tempMinLabel2,rightBackgroundPane,setMainActualWeather2,sunriseWindow2Label,
                sunsetWindow2Label,key);
        APIFunctionsModel.loadHourlyWeather( anchorPaneInScrollPane2,scrollPane2,key);

    }


}
