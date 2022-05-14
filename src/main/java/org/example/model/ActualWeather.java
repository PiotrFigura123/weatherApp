package org.example.model;

public class ActualWeather {

    private String visibility;
    //ActualWeatherSubclass weather;
    ActualTemperature main;
    ActualWind wind;
    ActualSys sys;


    private class ActualWeatherSubclass{
        String main;
        String description;
        String icon;
    }
    private class ActualTemperature{
        String temp;
        String feels_like;
        String temp_min;
        String temp_max;
        String pressure;
        String humidity;
    }
    private class ActualWind{
        String speed;
        String deg;
    }
    private class ActualSys{
        String sunrire;
        String suntet;
    }
}

