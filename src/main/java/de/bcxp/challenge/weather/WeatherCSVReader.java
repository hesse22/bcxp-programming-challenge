package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.IFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherCSVReader implements IFileReader<WeatherDataObject> {
    public List<WeatherDataObject> readFile(String fileName){
       List<WeatherDataObject> weatherDOs = new ArrayList<WeatherDataObject>();

       try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
               this.getClass().getResourceAsStream("/" + fileName)))){
            String line;
            // headers can be used if they are needed at another time
            String headers = bufferedReader.readLine();
            // extract data
           while ((line = bufferedReader.readLine()) != null){
               String[] objectData = line.split(",");
               WeatherDataObject weatherDataObject = new WeatherDataObject();
               weatherDataObject.setDay(Integer.parseInt(objectData[0]));
               weatherDataObject.setMaxTemp(Integer.parseInt(objectData[1]));
               weatherDataObject.setMinTemp(Integer.parseInt(objectData[2]));
               weatherDOs.add(weatherDataObject);
           }
       }catch(IOException e){
            e.printStackTrace();
       }

       return weatherDOs;
    }
}
