package de.bcxp.challenge.weather;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherUtilTest {
    @Test
    void testGetMinimumTemparatureSpread_PositiveCase() throws Exception{
        // Prepare test data
        WeatherDataObject firstItem = new WeatherDataObject();
        firstItem.setMinTemp(10);
        firstItem.setMaxTemp(20);
        firstItem.setDay(2);

        WeatherDataObject minTempSpread = new WeatherDataObject();
        minTempSpread.setMinTemp(10);
        minTempSpread.setMaxTemp(14);
        minTempSpread.setDay(1);

        WeatherDataObject thirdItem = new WeatherDataObject();
        thirdItem.setMinTemp(8);
        thirdItem.setMaxTemp(14);
        thirdItem.setDay(3);

        // add data to list
        List<WeatherDataObject> testObjects = new ArrayList<>();
        testObjects.add(firstItem);
        testObjects.add(minTempSpread);
        testObjects.add(thirdItem);


        // call test function
        WeatherDataObject result = WeatherUtil.getMinimumTemparatureSpread(testObjects);

        // assert
        assertEquals(minTempSpread.getDay(), result.getDay());
        assertEquals(minTempSpread.getMinTemp(), result.getMinTemp());
        assertEquals(minTempSpread.getMaxTemp(), result.getMaxTemp());
    }

    @Test
    void testGetMinimumTemparatureSpread_EmptyList() throws Exception{
        // Prepare test data
        List<WeatherDataObject> testObjects = new ArrayList<>();

        // check for exception
        assertThrows(Exception.class, () -> {
            WeatherUtil.getMinimumTemparatureSpread(testObjects);
        });
    }

}