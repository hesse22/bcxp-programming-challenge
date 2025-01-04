package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.IFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation for a reader of csv-weather-data
 */
public class WeatherCSVReader implements IFileReader<WeatherDataObject> {

    /**
     * Imports csv-data from a file into a list of {@link WeatherDataObject}
     * @param filePath relative to the resources directory
     * @return List of Weather Data Objects
     * @throws IOException
     */
    public List<WeatherDataObject> readFile(String filePath) throws IOException{
       // initialize list
       List<WeatherDataObject> weatherDOs = new ArrayList<>();
       // import file and initialize variable for the current line
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
       String line;
       // skip the column-headers
       bufferedReader.readLine();
       // initialize counter for the current line, starts with 2 because the header is in line 1
       int currentLine = 2;
       // extract data from file
       while ((line = bufferedReader.readLine()) != null){
           // split one line into the single values
           String[] objectData = line.split(",");
           WeatherDataObject weatherDataObject = new WeatherDataObject();
           // check if the array includes all the necessary data
           if(objectData.length < 3){
               throw new IOException("Error in line " + currentLine + ". Object does not contain all the necessary data");
           }
           // store data in corresponding attributes
           weatherDataObject.setDay(Integer.parseInt(objectData[0]));
           weatherDataObject.setMaxTemp(Integer.parseInt(objectData[1]));
           weatherDataObject.setMinTemp(Integer.parseInt(objectData[2]));
           // add object to list
           weatherDOs.add(weatherDataObject);
           currentLine++;
        }

       // throw exception if the list of DataObjects is empty
       if (weatherDOs.isEmpty()){
           throw new IOException("File did not include any data");
       }

       return weatherDOs;
    }
}
