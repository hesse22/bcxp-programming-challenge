package de.bcxp.challenge.general;

import de.bcxp.challenge.weather.WeatherDataObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation for a reader of csv-weather-data
 */
public class CSVReader<T extends DataObject> implements IFileReader<T> {
    ICSVParser<T> parser;

    public CSVReader(ICSVParser<T> parser){
        this.parser = parser;
    }

    /**
     * Imports csv-data from a file into a list of {@link WeatherDataObject}
     * @param filePath relative to the resources directory
     * @return List of Weather Data Objects
     * @throws IOException
     */
    @Override
    public List<T> readFile(String filePath) throws IOException{
       // initialize list
       List<T> dataObjects = new ArrayList<>();
       // import file and initialize variable for the current line
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
       String line;
       // skip the column-headers
       bufferedReader.readLine();
       // initialize counter for the current line, starts with 2 because the header is in line 1
       int currentLine = 2;
       // extract data from file
       while ((line = bufferedReader.readLine()) != null){
           try {
               T parsedObject = parser.parseLine(line);
               dataObjects.add(parsedObject);
               currentLine++;
           }catch(Exception e){
               throw new IOException("Error in line " + currentLine + " of the provided csv-File. " + e.getMessage());
           }
        }

       // throw exception if the list of DataObjects is empty
       if (dataObjects.isEmpty()){
           throw new IOException("File did not include any data");
       }

       return dataObjects;
    }
}
