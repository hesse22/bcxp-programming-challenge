package de.bcxp.challenge.countries;

import java.util.List;

/**
 * Toolbox to perform operations on CountryData
 */
public class CountryUtil {
    /**
     * Determines the CountryDataObject with the maximum population density
     *
     * @param countryDataObjectList List of CountryDataObjects to analyze
     * @return CountryDataObject with the maximum population density
     */
    public static CountryDataObject getMaximumPopulationDensity(List<CountryDataObject> countryDataObjectList) throws Exception{
        if(countryDataObjectList.isEmpty()){
            throw new Exception("List cannot be empty");
        }

        CountryDataObject countryDOmaxDensity = countryDataObjectList.get(0);
        for(CountryDataObject currentDataObject : countryDataObjectList){
            if (currentDataObject.getPopulationDensity() > countryDOmaxDensity.getPopulationDensity()){
                countryDOmaxDensity = currentDataObject;
            }
        }
        return countryDOmaxDensity;
    }
}
