package de.bcxp.challenge.general;

import de.bcxp.challenge.general.CSVReader;
import de.bcxp.challenge.general.IFileReader;
import de.bcxp.challenge.weather.WeatherCSVParser;
import de.bcxp.challenge.weather.WeatherDataObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    @Test
    void testReadFile_PositiveCase() throws IOException {
        // prepare TestData
        String filePath = "/de/bcxp/challenge/weather.csv";
        IFileReader<WeatherDataObject> fileReader = new CSVReader<>(new WeatherCSVParser());

        // act
        List<WeatherDataObject> resultList = fileReader.readFile(filePath);

        // assert
        assertEquals(3, resultList.size());
    }

    @Test
    void testReadFile_EmptyFile() throws IOException{
        // Prepare test data
        String filePath = "/de/bcxp/challenge/weather_empty.csv";
        IFileReader<WeatherDataObject> fileReader = new CSVReader<>(new WeatherCSVParser());

        // check for exception
        IOException exception = assertThrows(IOException.class, () -> {
            fileReader.readFile(filePath);
        });

        String exceptionMessage = exception.getMessage();
        assertEquals("File did not include any data", exceptionMessage);
    }

    @Test
    void testReadFile_WrongFormat() throws IOException{
        // Prepare test data
        String filePath = "/de/bcxp/challenge/weather_wrong_format.csv";
        IFileReader<WeatherDataObject> fileReader = new CSVReader<>(new WeatherCSVParser());

        // check for exception
        IOException exception = assertThrows(IOException.class, () -> {
            fileReader.readFile(filePath);
        });

        String exceptionMessage = exception.getMessage();
        assertEquals("Error in line 3 of the provided csv-File", exceptionMessage);
    }


}