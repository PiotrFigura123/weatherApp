module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.controller;
    opens org.example.controller to javafx.fxml;
    opens org.example.model;
    opens org.example.images;
    opens org.example.images.icons;

}