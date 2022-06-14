package org.weatherApp.model;

import java.util.List;

public class FiveDaysWeather extends ActualWeather {

    List<ActualWeather> list;

    public List<ActualWeather> getFiveDaysWeatherList() {
        return list;
    }
}
