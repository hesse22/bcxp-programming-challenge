package de.bcxp.challenge;

import de.bcxp.challenge.general.IFileReader;
import de.bcxp.challenge.weather.WeatherCSVReader;
import de.bcxp.challenge.weather.WeatherDataObject;
import de.bcxp.challenge.weather.WeatherUtil;

import java.io.IOException;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        // Weather program
        String weatherDataPath = "/de/bcxp/challenge/weather.csv";
        IFileReader<WeatherDataObject> fileReader = new WeatherCSVReader();
        try{
            // try to extrude a list of data objects from the csv
            List<WeatherDataObject> weatherDataObjectList = fileReader.readFile(weatherDataPath);
            WeatherDataObject weatherDoMinTempSpread = WeatherUtil.getMinimumTemparatureSpread(weatherDataObjectList);

            // Print out information of this day
            System.out.println("Day with minimal temperature span: " + weatherDoMinTempSpread.getDay());
            System.out.println("Min temperature on this day: " + weatherDoMinTempSpread.getMinTemp());
            System.out.println("Max temperature on this day: " + weatherDoMinTempSpread.getMaxTemp());
        }catch(IOException e){
            System.out.println("Error while reading the provided file:");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("An error occured while processing the function");
            e.printStackTrace();
        }



        // String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        // System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        // String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        // System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
