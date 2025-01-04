package de.bcxp.challenge.general;

import java.io.IOException;
import java.util.List;

/**
 * Interface to import data from a file
 * @param <T> derived class from {@link DataObject}
 */
public interface IFileReader<T extends DataObject> {

    /**
     * Imports a file and converts its content into a list of DataObjects
     *
     * @param filePath
     * @return list of the extracted data objects
     * @throws IOException
     */
    List<T> readFile(String filePath) throws IOException;
}
