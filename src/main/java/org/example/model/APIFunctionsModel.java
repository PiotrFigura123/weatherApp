package org.example.model;

import com.google.gson.Gson;
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

//import java.lang.runtime.SwitchBootstraps;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import static java.lang.Integer.parseInt;


public class APIFunctionsModel {


    private static String actualWeatherString;
    private static ActualWeather actualWeather;
    public static void loadweatherForField(TextField firstCityField, Label image, Label tempCurrentLabel1,
                                           Label tempMaxLabel1, Label tempMinLabel1,
                                           AnchorPane leftBackgroundPane, ImageView setMainActualWeather,
                                           Label sunriseWindow1Label,Label sunsetWindow1Label,String key) {


        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+firstCityField.getText()+"&appid="+key);
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode !=200 ){
                throw new RuntimeException("HttpsResponce code " + responseCode);
            }else{
                StringBuilder actualWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while  (scanner.hasNext()){
                    actualWeatherJson.append(scanner.nextLine());
                }
                scanner.close();

                actualWeatherString = actualWeatherJson.toString();
                actualWeather = new Gson().fromJson(actualWeatherString,ActualWeather.class);
                System.out.println("actual weather API : " + actualWeatherString);

                displayWeatherForWindow(actualWeather, image,tempCurrentLabel1,tempMaxLabel1, tempMinLabel1,leftBackgroundPane,setMainActualWeather,sunriseWindow1Label,sunsetWindow1Label);

            }
        }catch(Exception er){
        er.printStackTrace();
        return;
        }

    }

    private static void displayWeatherForWindow(ActualWeather actualWeather, Label image, Label tempCurrentLabel1, Label tempMaxLabel1, Label tempMinLabel1,AnchorPane leftBackgroundPane,ImageView setMainActualWeather,Label sunriseWindow1Label,Label sunsetWindow1Label) {

        tempCurrentLabel1.setText(actualWeather.getActualTemperature().getFeels_like());
        tempMinLabel1.setText(actualWeather.getActualTemperature().getTemp_min());
        tempMaxLabel1.setText(actualWeather.getActualTemperature().getTemp_max());
        image.setText(actualWeather.getActualWind().getSpeed());

        setNewBackgroundTheme(actualWeather.weather.get(0).main,leftBackgroundPane);
        setNewWeatherPicture(actualWeather.weather.get(0).icon, setMainActualWeather);
        displaySunriseSunset(actualWeather.getActualSys().getSunrise(),actualWeather.timezone, sunriseWindow1Label );
        displaySunriseSunset(actualWeather.getActualSys().getSunset(),actualWeather.timezone,sunsetWindow1Label );

    }

    private static void displaySunriseSunset(long eventTime, long timezone, Label label1ToDisplay) {
        long milis = (eventTime+ timezone)*1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm,a", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedTime = sdf.format(date);
        label1ToDisplay.setText(formattedTime);
    }

    private static void setNewWeatherPicture(String icon, ImageView setMainActualWeather) {
        String link ="/org/example/images/icons/"+icon+"@2x.png";
        Image image = new Image(link);

        setMainActualWeather.setImage(image);
        setMainActualWeather.setScaleX(2);
        setMainActualWeather.setScaleY(2);
    }

    private static void setNewBackgroundTheme(String description,AnchorPane backgroundForPane) {

        String link ="/org/example/images/"+description+"_day_theme.jpg";
        BackgroundImage actualBackgroundImage = new BackgroundImage(new Image(link,300,600,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        backgroundForPane.setBackground(new Background(actualBackgroundImage));

    }

    public static void loadFiveDaysWeather(TextField firstCityField,Label day1Window1Day,Label day2Window1Day,Label day3Window1Day,Label day4Window1Day,Label day5Window1Day,
                                           Label day1Window1Max,Label day2Window1Max,Label day3Window1Max,Label day4Window1Max,Label day5Window1Max,
                                           Label day1Window1Min,Label day2Window1Min,Label day3Window1Min,Label day4Window1Min,Label day5Window1Min,
                                           ImageView day1Window1Pisture,ImageView day2Window1Pisture,ImageView day3Window1Pisture,ImageView day4Window1Pisture,ImageView day5Window1Pisture, String key) {

        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q="+firstCityField.getText()+"&appid="+key);
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode !=200 ){
                throw new RuntimeException("HttpsResponce code " + responseCode);
            }else{
                StringBuilder fiveDaysWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while  (scanner.hasNext()){
                    fiveDaysWeatherJson.append(scanner.nextLine());
                }
                scanner.close();

                System.out.println("fiveDaysWeatherJson " + fiveDaysWeatherJson);
                String fiveDaysWeatherString = fiveDaysWeatherJson.toString();

                Gson gson = new Gson();
                FiveDaysWeather fiveDaysWeather1 = new Gson().fromJson(fiveDaysWeatherString,FiveDaysWeather.class);
                displayTempAt3(fiveDaysWeather1,day1Window1Day,day2Window1Day,day3Window1Day,day4Window1Day,day5Window1Day,
                        day1Window1Max,day2Window1Max,day3Window1Max,day4Window1Max,day5Window1Max,
                        day1Window1Min,day2Window1Min,day3Window1Min,day4Window1Min,day5Window1Min,
                        day1Window1Pisture,day2Window1Pisture, day3Window1Pisture,day4Window1Pisture,day5Window1Pisture);


            }
        }catch(Exception er){
            er.printStackTrace();
            return;
        }

    }

    private static void displayTempAt3(FiveDaysWeather fiveDaysWeather1,Label day1Window1Day,Label day2Window1Day,Label day3Window1Day,Label day4Window1Day,Label day5Window1Day,
                                       Label day1Window1Max,Label day2Window1Max,Label day3Window1Max,Label day4Window1Max,Label day5Window1Max,
                                       Label day1Window1Min,Label day2Window1Min,Label day3Window1Min,Label day4Window1Min,Label day5Window1Min,
                                       ImageView day1Window1Pisture,ImageView day2Window1Pisture,ImageView day3Window1Pisture,ImageView day4Window1Pisture,ImageView day5Window1Pisture) {
        String checkout1HighTime = "1:00,PM";
        String checkout2HighTime = "2:00,PM";
        String checkout3HighTime = "3:00,PM";
        String checkout1LowTime = "1:00,AM";
        String checkout2LowTime = "2:00,AM";
        String checkout3LowTime = "3:00,AM";
       // System.out.println("timezone "+fiveDaysWeather1.getCity().timezone);
        int labelNumeration = 1;
        for(int i=0;i<40;i++){
            String fiveDaysWeatherCheckoutTime = checkTimeInTable(fiveDaysWeather1.getCity().timezone, fiveDaysWeather1.getFiveDaysWeatherList().get(i).dt);
            //System.out.println("czas "+ fiveDaysWeatherCheckoutTime+" ,timezone "+fiveDaysWeather1.getCity().timezone);
            //System.out.println("czas w lokalizacji " + fiveDaysWeather1.getFiveDaysWeatherList().get(i).dt_txt);
            if(checkout1HighTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout2HighTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout3HighTime.equals(fiveDaysWeatherCheckoutTime)){
                switch (labelNumeration){
                    case 1:
                        setIconDay(fiveDaysWeather1,day1Window1Pisture,i);
                        day1Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1,day1Window1Day,i);
                        break;
                    case 2:
                        setIconDay(fiveDaysWeather1,day2Window1Pisture,i);
                        day2Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1,day2Window1Day,i);
                        break;
                    case 3:
                        setIconDay(fiveDaysWeather1,day3Window1Pisture,i);
                        day3Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1,day3Window1Day,i);
                        break;
                    case 4:
                        setIconDay(fiveDaysWeather1,day4Window1Pisture,i);
                        day4Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1,day4Window1Day,i);
                        break;
                    case 5:
                        setIconDay(fiveDaysWeather1,day5Window1Pisture,i);
                        day5Window1Max.setText(fiveDaysWeather1.getFiveDaysWeatherList().get(i).getActualTemperature().getTemp_max());
                        setDayOfWeek(fiveDaysWeather1,day5Window1Day,i);
                        break;
                    default:
                        break;
                }
                labelNumeration++;
            }else if(checkout1LowTime.equals(fiveDaysWeatherCheckoutTime) ||
                    checkout2LowTime.equals(fiveDaysWeatherCheckoutTime)||
                    checkout3LowTime.equals(fiveDaysWeatherCheckoutTime)){
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

    private static void setDayOfWeek(FiveDaysWeather fiveDaysWeather1, Label day1Window1Day, int i) {
        String weekDay = getDay(fiveDaysWeather1.getCity().timezone, fiveDaysWeather1.getFiveDaysWeatherList().get(i).dt);
        day1Window1Day.setText(weekDay);
    }

    private static void setIconDay(FiveDaysWeather fiveDaysWeather1, ImageView imagePicture,int i) {
        String icon = fiveDaysWeather1.getFiveDaysWeatherList().get(i).getWeatherItems().get(0).getIcon();
        String link ="/org/example/images/icons/"+icon+"@2x.png";
        Image image = new Image(link);
        imagePicture.setImage(image);
    }



    private static String checkTimeInTable(long timezone, long dt) {
        //long milis = dt*1000;
        long milis =(dt+ timezone)*1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm,a", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedTime = sdf.format(date);
        return formattedTime;
    }

    private static String getDay(long timezone, long dt) {
        long milis = (dt+ timezone)*1000;
        Date date = new Date(milis);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedTime = sdf.format(date);
        return formattedTime;
    }

    public static void loadHourlyWeather(ScrollPane anchorPaneInScrollPane,AnchorPane scrollPane1, String key) {


        float lat = actualWeather.getCoordClass().getLat();
        float lon = actualWeather.getCoordClass().getLon();
        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude=current,minutely,alerts,%20daily&appid="+key);
            HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode !=200 ){
                throw new RuntimeException("HttpsResponce code " + responseCode);
            }else{
                StringBuilder hourlyWeatherJson = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());
                while  (scanner.hasNext()){
                    hourlyWeatherJson.append(scanner.nextLine());
                }
                scanner.close();
                String hourlyWeatherJsonString = hourlyWeatherJson.toString();
                HourlyWeather hourlyWeather = new Gson().fromJson(hourlyWeatherJsonString,HourlyWeather.class);
                displayHourlyWeather(hourlyWeather, anchorPaneInScrollPane, scrollPane1);

            }
        }catch(Exception er){
            er.printStackTrace();
            return;
        }

    }

    private static void displayHourlyWeather(HourlyWeather hourlyWeather, ScrollPane anchorPaneInScrollPane,AnchorPane scrollPane1) {
        Font font = Font.font("Arial", FontWeight.LIGHT,  10);
        FlowPane flowPane = new FlowPane();
        for(int i=1;i<=9;i++){
            VBox vbox = new VBox();
            long godzinaInt = hourlyWeather.getHourly().get(i).getDt();
            long timeZone = hourlyWeather.getTimezone_offset();
            Label godzina = new Label(checkTimeInTable(timeZone,godzinaInt));
            godzina.setFont(font);
        Label tempActual = new Label(hourlyWeather.getHourly().get(i).getTemp());
            tempActual.setLayoutX(10);
        String link = getPathToPicture(hourlyWeather,i );
        ImageView label1Wiew = new ImageView(new Image(link));
        label1Wiew.setFitWidth(50);

        label1Wiew.setPreserveRatio(true);


            vbox.getChildren().addAll(godzina,tempActual,label1Wiew);
            vbox.setPadding(new Insets(10));
            flowPane.getChildren().add(vbox);
        }
        flowPane.setOrientation(Orientation.HORIZONTAL);

        anchorPaneInScrollPane.setContent(flowPane);
        anchorPaneInScrollPane.setMaxHeight(50);


       // horlyWeatherHbox.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY,Insets.EMPTY)));

    }

    private static String getPathToPicture(HourlyWeather hourlyWeather, int i) {
        String icon = hourlyWeather.getHourly().get(i).getWeather().get(0).getIcon();
        String link ="/org/example/images/icons/"+icon+"@2x.png";
        return link;
    }

}


