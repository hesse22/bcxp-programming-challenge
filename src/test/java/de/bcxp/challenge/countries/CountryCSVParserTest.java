package de.bcxp.challenge.countries;

import de.bcxp.challenge.general.ICSVParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CountryCSVParserTest {

    @Test
    void testParseLine_PositiveCase() throws IOException {
        // prepare TestData
        String line = "Austria;Vienna;1995;8926000;83855;447718;0.922;19";
        ICSVParser<CountryDataObject> parser = new CountryCSVParser();
        CountryDataObject expectedDO = new CountryDataObject();
        expectedDO.setName("Austria");
        expectedDO.setArea(83855);
        expectedDO.setPopulation(8926000);

        // act
        CountryDataObject resultElement = parser.parseLine(line);

        // assert
        assertEquals(expectedDO.getName(), resultElement.getName());
        assertEquals(expectedDO.getPopulation(), resultElement.getPopulation());
        assertEquals(expectedDO.getArea(), resultElement.getArea());
    }

    @Test
    void testParseLine_WrongFormat() throws IOException {
        // Prepare test data
        String line = "Germany; Berlin; 1902; 82600000";
        ICSVParser<CountryDataObject> parser = new CountryCSVParser();

        // act and assert
        IOException exception = assertThrows(IOException.class, () -> {
            parser.parseLine(line);
        });
        String exceptionMessage = exception.getMessage();
        assertEquals("Object does not contain all the necessary data", exceptionMessage);
    }
}