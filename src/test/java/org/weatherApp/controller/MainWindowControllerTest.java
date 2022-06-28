package org.weatherApp.controller;

import javafx.scene.image.Image;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import org.weatherApp.model.HourlyWeather;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MainWindowControllerTest {
    /*
    private String checkTimeInTable(long timezone, long dt) {
        long milis = (dt + timezone) * 1000;
        Instant instant = Instant.ofEpochMilli(milis);
        String minutes = String.valueOf(instant.atZone(ZoneOffset.UTC).getMinute());
        String hour = String.valueOf(instant.atZone(ZoneOffset.UTC).getHour());
        if (minutes.length() == 1)
            minutes = minutes + "0";
        return hour + ":" + minutes;



     */

    @ParameterizedTest
    @CsvSource({"1653231600,1","10000, 11000","100000,0"})
    void checkIfNameOfDayConsistDay(long timezone, long dt){
        String day = getDay(timezone,dt);
        assertThat(day, endsWith("DAY"));
    }


    @ParameterizedTest
    @ValueSource(strings = {"01d","03d","04n"})
    void checkIfPictureExist(String icon ){
        String link = "src/main/resources/org/weatherApp/images/icons/" + icon + "@2x.png";
        File inputData = new File(link);
            assertTrue(inputData.exists());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Clear","Drizzle","Mist"})
    void checkIfBackgroundFileExist(String icon ){
        String link = "src/main/resources/org/weatherApp/images/" + icon + "_day_theme.jpg";
        File inputData = new File(link);
        assertTrue(inputData.exists());
    }

    private String getDay(long timezone, long dt) {
        long milis = (dt + timezone) * 1000;
        Instant instant = Instant.ofEpochMilli(milis);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String dayName = String.valueOf(ldt.getDayOfWeek());
        return dayName;
    }


}