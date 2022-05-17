package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    void searchFirstCityAction() {

        APIFunctionsModel.loadweatherForField(firstCityField, imageView1Label,tempCurrentLabel1,tempMaxLabel1,tempMinLabel1,leftBackgroundPane,displayActualWeatherLabel);

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
