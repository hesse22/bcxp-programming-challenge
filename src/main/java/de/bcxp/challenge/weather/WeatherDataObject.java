package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.DataObject;

public class WeatherDataObject extends DataObject {
    // contains all the relevant information about a weather data object
    // in order to complete the challenge
    int day;
    int maxTemp;
    int minTemp;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getTempSpan(){
        return this.maxTemp - this.minTemp;
    }
}
