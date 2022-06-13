package org.weatherApp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.weatherApp.view.MainWindow;

/**
 * JavaFX App
 */
public class App extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.initializeStage();
    }
}