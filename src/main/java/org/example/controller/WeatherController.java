package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WeatherController {

    @FXML
    private TextField firstCityField;

    @FXML
    private TextField secondCityField;

    @FXML
    void searchFirstCityAction() {
        System.out.println("clicked");
    }

    @FXML
    void searchSecondCityAction() {

    }
}
