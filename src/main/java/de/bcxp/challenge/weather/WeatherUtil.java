package de.bcxp.challenge.weather;

import java.util.List;

/**
 * Toolbox to perform operations on WeatherData
 */
public class WeatherUtil {
    /**
     * Determines the WeatherDataObject with the minimum temperature spread from a given list
     *
     * @param weatherDataObjectList List of WeatherDataObjects to analyze
     * @return WeatherDataObject of the day with the minimum temperature spread
     */
    public static WeatherDataObject getMinimumTemparatureSpread(List<WeatherDataObject> weatherDataObjectList) throws Exception{
        if(weatherDataObjectList.isEmpty()){
            throw new Exception("List cannot be empty");
        }

        // iterate over the list in order to find the minimum value
        WeatherDataObject weatherDOminTempSpread = weatherDataObjectList.get(0);
        for(WeatherDataObject currentDataObject : weatherDataObjectList){
            if (currentDataObject.getTempSpan() < weatherDOminTempSpread.getTempSpan()){
                weatherDOminTempSpread = currentDataObject;
            }
        }
        return weatherDOminTempSpread;
    }
}
