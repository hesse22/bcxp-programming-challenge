package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.IFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCSVReaderTest {
    @Test
    void testReadFile_PositiveCase() throws IOException {
        // prepare TestData
        String filePath = "/de/bcxp/challenge/weather.csv";
        IFileReader<WeatherDataObject> fileReader = new WeatherCSVReader();
        // initialize expected list
        List<WeatherDataObject> expectedList = new ArrayList<>();
        // add objects
        WeatherDataObject firstDo = new WeatherDataObject();
        firstDo.setDay(1);
        firstDo.setMinTemp(59);
        firstDo.setMaxTemp(88);
        expectedList.add(firstDo);
        WeatherDataObject secondDo = new WeatherDataObject();
        secondDo.setDay(2);
        secondDo.setMinTemp(63);
        secondDo.setMaxTemp(79);
        expectedList.add(secondDo);
        WeatherDataObject thirdDo = new WeatherDataObject();
        thirdDo.setDay(3);
        thirdDo.setMinTemp(55);
        thirdDo.setMaxTemp(77);
        expectedList.add(thirdDo);

        // act
        List<WeatherDataObject> resultList = fileReader.readFile(filePath);

        // assert
        assertEquals(3, resultList.size());
        for(int i = 0; i < resultList.size(); i++){
            WeatherDataObject resultElement = resultList.get(i);
            WeatherDataObject expectedElement = expectedList.get(i);
            assertEquals(expectedElement.getDay(), resultElement.getDay());
            assertEquals(expectedElement.getMinTemp(), resultElement.getMinTemp());
            assertEquals(expectedElement.getMaxTemp(), resultElement.getMaxTemp());
        }
    }

    @Test
    void testReadFile_EmptyFile() throws IOException{
        // Prepare test data
        String filePath = "/de/bcxp/challenge/weather_empty.csv";
        IFileReader<WeatherDataObject> fileReader = new WeatherCSVReader();

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
        IFileReader<WeatherDataObject> fileReader = new WeatherCSVReader();

        // check for exception
        IOException exception = assertThrows(IOException.class, () -> {
            fileReader.readFile(filePath);
        });

        String exceptionMessage = exception.getMessage();
        assertEquals("Error in line 3. Object does not contain all the necessary data", exceptionMessage);
    }

}