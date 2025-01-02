package de.bcxp.challenge.general;

import java.util.List;

public interface IFileReader<T extends DataObject> {
    List<T> readFile(String fileName);
}
