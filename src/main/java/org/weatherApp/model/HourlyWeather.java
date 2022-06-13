package org.weatherApp.model;

import java.util.List;

import static java.lang.Float.parseFloat;

public class HourlyWeather {
    private long timezone_offset;
    List<HourlyList> hourly;

    public class HourlyList{
        private long dt;
        private String temp;

        List<WeatherElements> weather;

        public long getDt() {
            return dt;
        }
        public String getTemp() {
            return conversionFromKelvin(temp);
        }
        public class WeatherElements{
            private String icon;
            public String getIcon() {
                return icon;
            }
        }
        public List<WeatherElements> getWeather() {
            return weather;
        }
        private String conversionFromKelvin(String temp) {

            return String.valueOf((int)parseFloat(temp)-273);
        }
    }


    public long getTimezone_offset() {
        return timezone_offset;
    }

    public List<HourlyList> getHourly() {
        return hourly;
    }


}
