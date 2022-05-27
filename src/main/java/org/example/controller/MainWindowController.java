package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.Config;
import org.example.model.APIFunctionsModel;
import org.example.model.ActualWeather;

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
    private ImageView setMainActualWeather;
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
    void searchFirstCityAction() {
        String key = new Config().getAPI_KEY();
        APIFunctionsModel.loadweatherForField(firstCityField, imageView1Label,tempCurrentLabel1,
                tempMaxLabel1,tempMinLabel1,leftBackgroundPane,setMainActualWeather,sunriseWindow1Label,
                sunsetWindow1Label,key);
        APIFunctionsModel.loadFiveDaysWeather(firstCityField,day1Window1Day,day2Window1Day,day3Window1Day,day4Window1Day,day5Window1Day,
                day1Window1Max,day2Window1Max,day3Window1Max,day4Window1Max,day5Window1Max,
                day1Window1Min,day2Window1Min,day3Window1Min,day4Window1Min,day5Window1Min,
                day1Window1Pisture,day2Window1Pisture, day3Window1Pisture,day4Window1Pisture,day5Window1Pisture,key);

        APIFunctionsModel.loadHourlyWeather( anchorPaneInScrollPane,scrollPane1,key);
    }

    @FXML
    private TextField secondCityField;

    @FXML
    private Label imageView1Label;

    @FXML
    private AnchorPane rightBackgroundPane;
    @FXML
    private static ImageView actualWeather1Image;

    private APIFunctionsModel apiFunctionsModel;

    @FXML
    void searchSecondCityAction() {

        //APIFunctionsModel.loadweatherForField1(secondCityField.getText());

    }


}
