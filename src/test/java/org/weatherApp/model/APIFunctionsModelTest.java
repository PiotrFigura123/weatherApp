package org.weatherApp.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.weatherApp.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class APIFunctionsModelTest {

    @ParameterizedTest
    @ValueSource(ints ={5,10,15,18})
    void mealPrice(int price){
        assertThat(price,lessThan(20));
    }

    @Test
    void checkIfURLIsCorrect() throws IOException{
        assertThat(connectToURL(), equalTo(200));
    }

    @Test
    void checkURlConnectionTimeOut() {

        assertTimeout(Duration.ofMillis(1000), () -> {
            connectToURL();
        });
    }

    private int connectToURL() throws IOException{
        String key = new Config().getAPI_KEY();
        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=Bari&appid=" + key);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        return conn.getResponseCode();
    }
}
