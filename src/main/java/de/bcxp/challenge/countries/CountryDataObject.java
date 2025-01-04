package de.bcxp.challenge.countries;

import de.bcxp.challenge.general.DataObject;

/**
 * Bean to store country data
 * Reduced to the attributes relevant to solve the task
 */
public class CountryDataObject extends DataObject {
    String name;
    int area;
    int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getPopulationDensity(){
        return (double) this.population / (double) this.area;
    }
}
