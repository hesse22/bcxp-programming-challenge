package de.bcxp.challenge.countries;

import de.bcxp.challenge.general.ICSVParser;

import java.io.IOException;

/**
 * Class to parse a line from a csv-dataset of countries
 */
public class CountryCSVParser implements ICSVParser<CountryDataObject> {
    /**
     * @param line line to extract information from
     * @return {@link CountryDataObject} containing the given information
     * @throws IOException
     */
    @Override
    public CountryDataObject parseLine(String line) throws IOException {
        CountryDataObject countryDataObject = new CountryDataObject();
        String[] objectData = line.split(";");
        // check if the array includes all the necessary data
        if(objectData.length < 5){
            throw new IOException("Object does not contain all the necessary data");
        }
        // store data in corresponding attributes
        countryDataObject.setName(objectData[0]);
        countryDataObject.setPopulation(Integer.parseInt(objectData[3]));
        countryDataObject.setArea(Integer.parseInt(objectData[4]));
        // add object to list
        return countryDataObject;
    }
}
