package org.weatherApp.model;

import java.util.List;

public class FiveDaysWeather extends ActualWeather {

    /**
     * fiveDaysWeather sklada sie z takich samych pol jak ActualWeather,
     * z tym ze API dostarcza dane ActualWeather w wersji tablicy na kazdy dzien
     */
    List<ActualWeather> list;

    public List<ActualWeather> getFiveDaysWeatherList() {
        return list;
    }
}
