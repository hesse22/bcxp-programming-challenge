package de.bcxp.challenge;

import de.bcxp.challenge.general.IFileReader;
import de.bcxp.challenge.weather.WeatherCSVReader;
import de.bcxp.challenge.weather.WeatherDataObject;
import de.bcxp.challenge.weather.WeatherUtil;

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

        // Your preparation code …
        String weatherDataPath = "de/bcxp/challenge/weather.csv";
        IFileReader<WeatherDataObject> fileReader = new WeatherCSVReader();
        List<WeatherDataObject> weatherDataObjectList = fileReader.readFile(weatherDataPath);

        WeatherDataObject weatherDOminTempSpread = WeatherUtil.getMinimumTemparatureSpread(weatherDataObjectList);

        System.out.println("Day with minimal temperature span: " + weatherDOminTempSpread.getDay());
        System.out.println("Min temperature on this day: " + weatherDOminTempSpread.getMinTemp());
        System.out.println("Max temperature on this day: " + weatherDOminTempSpread.getMaxTemp());

        // String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        // System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        // String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        // System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
