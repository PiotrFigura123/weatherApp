package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class APIFunctionsModelTest {

    @Test
    void checkIfWeatherExist(){
        ActualWeather actualWeather = new ActualWeather();
        assertThat(actualWeather.weather,equalTo(null  ));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void checkIfPathIncludeGoodNames(int pictureName){

        assertThat(pictureName, lessThan(20));


    }
}
