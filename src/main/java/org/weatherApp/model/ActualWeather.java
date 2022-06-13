package org.weatherApp.model;

import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Float.valueOf;
import static java.lang.Integer.parseInt;


public class ActualWeather {

    public int visibility;

    public long timezone;
    public long dt;
    public String dt_txt;
    List<WeatherItems> weather;
    ActualTemperature main;
    ActualWind wind;
    ActualSys sys;
    CityInfo city;
    CoordClass coord;
    public class CoordClass{
        private float lon;
        private float lat;

        public float getLon() {
            return lon;
        }

        public float getLat() {
            return lat;
        }
    }
    public CoordClass getCoordClass(){return coord; }

    public class CityInfo{
        public long timezone;
        String name;
    }

    public CityInfo getCity() {
        return city;
    }

    public class WeatherItems{
        public String id;
        public String main;
        public String description;
        public String icon;

        public String getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
    public List<WeatherItems> getWeatherItems(){

        return weather;
    }
    public ActualTemperature getActualTemperature(){

        return main;
    }
    public class ActualTemperature{
        private String temp;
        private String feels_like;
        private String temp_min;
        private String temp_max;
        private String pressure;
        private String humidity;

        public String getTemp() {
            return conversionFromKelvin(temp);
        }

        public String getFeels_like() {
            return conversionFromKelvin(feels_like);
        }

        public String getTemp_min() {
            return conversionFromKelvin(temp_min);
        }

        public String getTemp_max() {

            return conversionFromKelvin(temp_max);
        }

        public String getPressure() {
            return pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        private String conversionFromKelvin(String temp) {

            return String.valueOf((int)parseFloat(temp)-273);
        }
    }

    public class ActualWind{
        private String speed;
        private String deg;

        public String getSpeed() {
            return speed;
        }

        public String getDeg() {
            return deg;
        }
    }
    public ActualWind getActualWind(){
        return wind;
    }

    public class ActualSys{
        private long sunrise;
        private long sunset;
        public long getSunrise() {

            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }
    }
    public ActualSys getActualSys(){ return sys;}

}

