module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens org.weatherApp to javafx.fxml;
    exports org.weatherApp;
    exports org.weatherApp.controller;
    opens org.weatherApp.controller to javafx.fxml;
    opens org.weatherApp.model;
    opens org.weatherApp.images;
    opens org.weatherApp.images.icons;

}