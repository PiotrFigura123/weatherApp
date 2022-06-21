package org.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import org.weatherApp.model.APIFunctionsModel;
import org.weatherApp.model.ActualWeather;
import org.weatherApp.model.FiveDaysWeather;
import org.weatherApp.model.HourlyWeather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class MainWindowController {

    private static final String checkout1HighTime = "13:00";
    private static final String checkout2HighTime = "14:00";
    private static final String checkout3HighTime = "15:00";
    private static final String checkout1LowTime = "1:00";
    private static final String checkout2LowTime = "2:00";
    private static final String checkout3LowTime = "3:00";
    private static final int numberOfHourToDisplay = 12;
    private static final int numberOfThreeHourPeriodToDisplayInDailyWeather = 40;
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
    private ImageView setMainActualWeather1;
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
    private Label windSpeedLabel1;

    @FXML
    void searchFirstCityAction() {

        ActualWeather actualWeather1 = APIFunctionsModel.loadweatherForField(firstCityField);
        FiveDaysWeather fiveDaysWeather1 = APIFunctionsModel.loadFiveDaysWeather(firstCityField);
        HourlyWeather hourlyWeather1 = APIFunctionsModel.loadHourlyWeather(actualWeather1);
        displayWeatherForWindow(actualWeather1, setMainActualWeather1, tempCurrentLabel1, tempMaxLabel1, tempMinLabel1, leftBackgroundPane, sunriseWindow1Label, sunsetWindow1Label, windSpeedLabel1);
        displayTempAtAfterNoon(fiveDaysWeather1, day1Window1Day, day2Window1Day, day3Window1Day, day4Window1Day, day5Window1Day,
                day1Window1Max, day2Window1Max, day3Window1Max, day4Window1Max, day5Window1Max,
                day1Window1Min, day2Window1Min, day3Window1Min, day4Window1Min, day5Window1Min,
                day1Window1Pisture, day2Window1Pisture, day3Window1Pisture, day4Window1Pisture, day5Window1Pisture);
        displayHourlyWeather(hourlyWeather1, anchorPaneInScrollPane, scrollPane1);

    }

    @FXML
    private Label day1Window1Max2;

    @FXML
    private Label tempCurrentLabel2;
    @FXML
    private Label day1Window1Min2;

    @FXML
    private ImageView day1Window1Pisture2;

    @FXML
    private Label day2Window1Max2;

    @FXML
    private Label day2Window1Min2;

    @FXML
    private ImageView day2Window1Pisture2;

    @FXML
    private Label day3Window1Max2;

    @FXML
    private Label day3Window1Min2;

    @FXML
    private ImageView day3Window1Pisture2;

    @FXML
    private Label day4Window1Max2;

    @FXML
    private Label day4Window1Min2;
    @FXML
    private Label day1Window1Day2;
    @FXML
    private Label day2Window1Day2;
    @FXML
    private Label day3Window1Day2;
    @FXML
    private Label day4Window1Day2;
    @FXML
    private Label day5Window1Day2;

    @FXML
    private ImageView day4Window1Pisture2;

    @FXML
    private Label day5Window1Max2;

    @FXML
    private Label day5Window1Min2;

    @FXML
    private ImageView day5Window1Pisture2;

    @FXML
    private Label windSpeedLabel2;

    @FXML
    private AnchorPane rightBackgroundPane;

    @FXML
    private AnchorPane scrolePane2;

    @FXML
    private TextField secondCityField;

    @FXML
    private ImageView setMainActualWeather2;

    @FXML
    private Label tempMaxLabel2;

    @FXML
    private Label tempMinLabel2;

    @FXML
    private Label sunriseWindow2Label;
    @FXML
    private Label sunsetWindow2Label;
    @FXML
    private ScrollPane anchorPaneInScrollPane2;
    @FXML
    private AnchorPane scrollPane2;

    @FXML
    void searchSecondCityAction() {
        ActualWeather actualWeather2;
        FiveDaysWeather fiveDaysWeather2;
        HourlyWeather hourlyWeather2;

        actualWeather2 = APIFunctionsModel.loadweatherForField(secondCityField);
        fiveDaysWeather2 = APIFunctionsModel.loadFiveDaysWeather(secondCityField);
        hourlyWeather2 = APIFunctionsModel.loadHourlyWeather(actualWeather2);

        displayWeatherForWindow(actualWeather2, setMainActualWeather2, tempCurrentLabel2, tempMaxLabel2, tempMinLabel2, rightBackgroundPane, sunriseWindow2Label, sunsetWindow2Label, windSpeedLabel2);
        displayTempAtAfterNoon(fiveDaysWeather2, day1Window1Day2, day2Window1Day2, day3Window1Day2, day4Window1Day2, day5Window1Day2,
                day1Window1Max2, day2Window1Max2, day3Window1Max2, day4Window1Max2, day5Window1Max2,
                day1Window1Min2, day2Window1Min2, day3Window1Min2, day4Window1Min2, day5Window1Min2,
                day1Window1Pisture2, day2Window1Pisture2, day3Window1Pisture2, day4Window1Pisture2, day5Window1Pisture2);
        displayHourlyWeather(hourlyWeather2, anchorPaneInScrollPane2, scrollPane2);

    }

    private FlowPane setHourlyWeatherPictures(HourlyWeather hourlyWeather, ScrollPane anchorPaneInScrollPane, AnchorPane scrollPane1){
        Font fontHour = Font.font("Arial", FontWeight.LIGHT, 13);
        Font fontTemperature = Font.font("Arial", FontWeight.BOLD, 15);
        FlowPane flowPane = new FlowPane();
        for (int i = 1; i <= numberOfHourToDisplay; i++) {
            VBox vbox = new VBox();
            long hourInt = hourlyWeather.getHourly().get(i).getDt();
            long timeZone = hourlyWeather.getTimezone_offset();
            Label hourLabel = new Label(checkTimeInTable(timeZone, hourInt));
            Label tempActual = new Label(hourlyWeather.getHourly().get(i).getTemp());

            String link = getPathToPicture(hourlyWeather, i);
            ImageView label1Wiew = new ImageView(new Image(link));

            hourLabel.setFont(fontHour);
            hourLabel.setTextFill(Color.BLACK);
            hourLabel.setTextAlignment(TextAlignment.CENTER);

            tempActual.setLayoutX(10);
            tempActual.setFont(fontTemperature);
            tempActual.setTextFill(Color.DARKBLUE);

            label1Wiew.setFitWidth(50);
            label1Wiew.setPreserveRatio(true);
            vbox.getChildren().addAll(hourLabel, tempActual, label1Wiew);
            vbox.setPadding(new Insets(10));

            flowPane.getChildren().add(vbox);
        }
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setMaxWidth(315);
        flowPane.setHgap(2);
        flowPane.setVgap(2);

        return flowPane;
    }
    private void displayHourlyWeather(HourlyWeather hourlyWeather, ScrollPane anchorPaneInScrollPane, AnchorPane scrollPane1) {
        FlowPane flowPane = new FlowPane();
        flowPane = setHourlyWeatherPictures(hourlyWeather, anchorPaneInScrollPane, scrollPane1);
        anchorPaneInScrollPane.setContent(flowPane);

    }

    private void displayTempAtAfterNoon(FiveDaysWeather fiveDaysWeather1, Label day1Window1Day, Label day2Window1Day, Label day3Window1Day, Label day4Window1Day, Label day5Window1Day,
                                        Label day1Window1Max, Label day2Window1Max, Label day3Window1Max, Label day4Window1Max, Label day5Window1Max,
                                        Label day1Window1Min, Label day2Window1Min, Label day3Window1Min, Label day4Window1Min, Label day5Window1Min,
                                        ImageView day1Window1Pisture, ImageView day2Window1Pisture, ImageView day3Window1Pisture, ImageView day4Window1Pisture, ImageView day5Window1Pisture) {



        int labelNumeration = 1;
        for (int i = 0; i < numberOfThreeHourPeriodToDisplayInDailyWeather; i++) {
            String fiveDaysWeatherCheckoutTime = checkTimeInTable(fiveDaysWeather1.getCity().timezone, fiveDaysWeather1.getFiveDaysWeatherList().get(i).dt);
            if (checkout1HighTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout2HighTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout3HighTime.equals(fiveDaysWeatherCheckoutTime)) {
                switch (labelNumeration) {
                    case 1:
                        setIconDay(fiveDaysWeather1, day1Window1Pisture, i);
                        day1Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1, day1Window1Day, i);
                        break;
                    case 2:
                        setIconDay(fiveDaysWeather1, day2Window1Pisture, i);
                        day2Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1, day2Window1Day, i);
                        break;
                    case 3:
                        setIconDay(fiveDaysWeather1, day3Window1Pisture, i);
                        day3Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1, day3Window1Day, i);
                        break;
                    case 4:
                        setIconDay(fiveDaysWeather1, day4Window1Pisture, i);
                        day4Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1, day4Window1Day, i);
                        break;
                    case 5:
                        setIconDay(fiveDaysWeather1, day5Window1Pisture, i);
                        day5Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1, day5Window1Day, i);
                        break;
                    default:
                        break;
                }
                labelNumeration++;
            } else if (checkout1LowTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout2LowTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout3LowTime.equals(fiveDaysWeatherCheckoutTime)) {
                switch (labelNumeration) {
                    case 1:
                        day1Window1Min.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_min());
                        break;
                    case 2:
                        day2Window1Min.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_min());
                        break;
                    case 3:
                        day3Window1Min.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_min());
                        break;
                    case 4:
                        day4Window1Min.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_min());
                        break;
                    case 5:
                        day5Window1Min.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_min());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void setIconDay(FiveDaysWeather fiveDaysWeather1, ImageView imagePicture, int i) {
        String icon = fiveDaysWeather1.getFiveDaysWeatherList().get(i).getWeatherItems().get(0).getIcon();
        String link = "/org/weatherApp/images/icons/" + icon + "@2x.png";
        Image image = new Image(link);
        imagePicture.setImage(image);
    }

    private String checkTimeInTable(long timezone, long dt) {
        long milis = (dt + timezone) * 1000;
        Instant instant = Instant.ofEpochMilli(milis);
        String minutes = String.valueOf(instant.atZone(ZoneOffset.UTC).getMinute());
        String hour = String.valueOf(instant.atZone(ZoneOffset.UTC).getHour());
        if(minutes.length()==1)
            minutes=minutes+"0";
        return hour+":"+minutes;

    }

    private void setDayOfWeek(FiveDaysWeather fiveDaysWeather1, Label day1Window1Day, int i) {
        String weekDay = getDay(fiveDaysWeather1.getCity().timezone, fiveDaysWeather1.getFiveDaysWeatherList().get(i).dt);
        day1Window1Day.setText(weekDay);
    }

    private String getDay(long timezone, long dt) {
        long milis = (dt + timezone) * 1000;
        Instant instant = Instant.ofEpochMilli(milis);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String dayName = String.valueOf(ldt.getDayOfWeek());
        return dayName.substring(0,3);
    }

    private void displayWeatherForWindow(ActualWeather actualWeather, ImageView setMainActualWeather, Label tempCurrentLabel, Label tempMaxLabel1, Label tempMinLabel1, AnchorPane leftBackgroundPane, Label sunriseWindow1Label, Label sunsetWindow1Label, Label windSpeedLabel1) {
        Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 22);

        tempCurrentLabel.setText(actualWeather.getActualTemperature().getFeels_like());
        tempCurrentLabel.setFont(font);
        tempCurrentLabel.setTextFill(Color.DARKBLUE);
        tempMinLabel1.setText(actualWeather.getActualTemperature().getTemp_min());
        tempMaxLabel1.setText(actualWeather.getActualTemperature().getTemp_max());
        windSpeedLabel1.setText(actualWeather.getActualWind().getSpeed());

        setNewBackgroundTheme(actualWeather.weather.get(0).main, leftBackgroundPane);
        setNewWeatherPicture(actualWeather.weather.get(0).icon, setMainActualWeather);
        sunriseWindow1Label.setText(checkTimeInTable(actualWeather.getActualSys().getSunrise(), actualWeather.timezone));
        sunsetWindow1Label.setText(checkTimeInTable(actualWeather.getActualSys().getSunset(), actualWeather.timezone));
    }

    private void setNewBackgroundTheme(String description, AnchorPane backgroundForPane) {

        String link = "/org/weatherApp/images/" + description + "_day_theme.jpg";
        BackgroundImage actualBackgroundImage = new BackgroundImage(new Image(link, 325, 600, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        backgroundForPane.setBackground(new Background(actualBackgroundImage));

    }

    private void setNewWeatherPicture(String icon, ImageView setMainActualWeather) {
        String link = "/org/weatherApp/images/icons/" + icon + "@2x.png";
        Image image = new Image(link);

        setMainActualWeather.setImage(image);
        setMainActualWeather.setScaleX(2);
        setMainActualWeather.setScaleY(2);
    }

    private static String getPathToPicture(HourlyWeather hourlyWeather, int i) {
        String icon = hourlyWeather.getHourly().get(i).getWeather().get(0).getIcon();
        return "/org/weatherApp/images/icons/" + icon + "@2x.png";
    }
}
