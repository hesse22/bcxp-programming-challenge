package de.bcxp.challenge.weather;

import de.bcxp.challenge.general.CSVReader;
import de.bcxp.challenge.general.ICSVParser;
import de.bcxp.challenge.general.IFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCSVParserTest {
    @Test
    void testReadFile_PositiveCase() throws IOException {
        // prepare TestData
        String line = "1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5";
        ICSVParser<WeatherDataObject> parser = new WeatherCSVParser();
        WeatherDataObject expectedDO = new WeatherDataObject();
        expectedDO.setDay(1);
        expectedDO.setMinTemp(59);
        expectedDO.setMaxTemp(88);

        // act
        WeatherDataObject resultElement = parser.parseLine(line);

        assertEquals(expectedDO.getDay(), resultElement.getDay());
        assertEquals(expectedDO.getMinTemp(), resultElement.getMinTemp());
        assertEquals(expectedDO.getMaxTemp(), resultElement.getMaxTemp());

    }

    @Test
    void testParseLine_WrongFormat() throws IOException {
        // Prepare test data
        String line = "2,79";
        ICSVParser<WeatherDataObject> parser = new WeatherCSVParser();

        // check for exception
        IOException exception = assertThrows(IOException.class, () -> {
            parser.parseLine(line);
        });

        String exceptionMessage = exception.getMessage();
        assertEquals("Object does not contain all the necessary data", exceptionMessage);
    }

}