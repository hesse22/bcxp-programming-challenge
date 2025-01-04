package de.bcxp.challenge.general;

import java.io.IOException;

public interface ICSVParser<T extends DataObject> {
    T parseLine(String line) throws IOException;
}
