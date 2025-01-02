package de.bcxp.challenge.weather;

import java.util.List;

public class WeatherUtil {
    public static WeatherDataObject getMinimumTemparatureSpread(List<WeatherDataObject> weatherDataObjectList){
        WeatherDataObject weatherDOminTempSpread = weatherDataObjectList.get(0);
        for(WeatherDataObject currentDataObject : weatherDataObjectList){
            if (currentDataObject.getTempSpan() < weatherDOminTempSpread.getTempSpan()){
                weatherDOminTempSpread = currentDataObject;
            }
        }
        return weatherDOminTempSpread;
    }
}
