package ro.pao.application.csv;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.NotImplementedException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ro.pao.application.utils.Constants.CSV_PATH_READ;

public class CsvReader implements CsvExecutor {

    private static CsvReader INSTANCE;


    private CsvReader() {
    }

    public static CsvReader getInstance() {
        return INSTANCE == null ? new CsvReader() : INSTANCE;
    }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public List<String[]> readLineByLine(Path filePath) throws Exception {
        List<String[]> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    list.add(line);
                }
            }
        }
        return list;
    }

    @Override
    public List<String[]> executeLineByLine() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_READ).toURI());

        return readLineByLine(path);
    }

    @Override
    public List<String[]> executeAllLines() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_READ).toURI());

        return readAllLines(path);
    }

    @Override
    public String executeLineByLine(List<String[]> lines) throws Exception {
        throw new NotImplementedException("Not implemented!");
    }

    @Override
    public String executeAllLines(List<String[]> lines) throws Exception {
        throw new NotImplementedException("Not implemented!");
    }
}
