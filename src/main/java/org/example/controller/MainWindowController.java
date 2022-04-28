package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.model.APIFunctionsModel;

public class MainWindowController {
    private String firstCity;
    private String secondCity;
    @FXML
    private TextField firstCityField;

    @FXML
    private TextField secondCityField;

    private APIFunctionsModel apiFunctionsModel;
    @FXML
    void searchFirstCityAction() {

        String firstCity = firstCityField.getText();
        //System.out.println(firstCity);
        APIFunctionsModel.loadweather(firstCity);
    }

    @FXML
    void searchSecondCityAction() {
        String secondCity = secondCityField.getText();
        System.out.println(secondCity);


    }
}
