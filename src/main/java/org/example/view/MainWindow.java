package org.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.ActualWeather;

import java.io.IOException;


public class MainWindow {

    public void initializeStage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/primary.fxml"));
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Wakacyjna stacja pogodowa");
        stage.setResizable(false);
        stage.show();
    }
}
