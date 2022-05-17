package org.example;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.model.ActualWeather;
import org.example.view.MainWindow;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws IOException {
        MainWindow mainWindow = new MainWindow();
        mainWindow.initializeStage();




    }




}