package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.ICSVParser;

import java.io.IOException;

public class WeatherCSVParser implements ICSVParser<WeatherDataObject> {
    public WeatherDataObject parseLine(String line) throws IOException{
        WeatherDataObject weatherDataObject = new WeatherDataObject();
        String[] objectData = line.split(",");
        // check if the array includes all the necessary data
        if(objectData.length < 3){
            throw new IOException("Object does not contain all the necessary data");
        }
        // store data in corresponding attributes
        weatherDataObject.setDay(Integer.parseInt(objectData[0]));
        weatherDataObject.setMaxTemp(Integer.parseInt(objectData[1]));
        weatherDataObject.setMinTemp(Integer.parseInt(objectData[2]));
        // add object to list
        return weatherDataObject;
    }
}
