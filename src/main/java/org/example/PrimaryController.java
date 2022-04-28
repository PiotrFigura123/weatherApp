package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

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
