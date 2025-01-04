package de.bcxp.challenge.countries;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryUtilTest {
    @Test
    void testGetMaximumPopulationDensity_PositiveCase() throws Exception{
        // Prepare test data
        CountryDataObject expectedResult = new CountryDataObject();
        expectedResult.setName("Malta");
        expectedResult.setPopulation(1000);
        expectedResult.setArea(100);

        CountryDataObject secondItem = new CountryDataObject();
        secondItem.setName("Neverland");
        secondItem.setPopulation(999);
        secondItem.setArea(100);

        CountryDataObject thirdItem = new CountryDataObject();
        thirdItem.setName("Legoland");
        thirdItem.setPopulation(1000);
        thirdItem.setArea(101);

        // add data to list
        List<CountryDataObject> testObjects = new ArrayList<>();
        testObjects.add(secondItem);
        testObjects.add(expectedResult);
        testObjects.add(thirdItem);

        // call test function
        CountryDataObject result = CountryUtil.getMaximumPopulationDensity(testObjects);

        // assert
        assertEquals(expectedResult.getName(), result.getName());
    }

    @Test
    void testGetMaximumPopulationDensity_EmptyList() throws Exception{
        // Prepare test data
        List<CountryDataObject> testObjects = new ArrayList<>();

        // check for exception
        assertThrows(Exception.class, () -> {
            CountryUtil.getMaximumPopulationDensity(testObjects);
        });
    }
}