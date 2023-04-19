package ro.pao.application;

import com.opencsv.CSVWriter;
import ro.pao.application.csv.CsvExecutor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

public class CsvHelperFactory {


    private CsvHelperFactory() {
    }

    public static CsvExecutor getInstance(CsvType csvType) {
        return switch (csvType) {
            case READER -> CsvReader.getInstance();
            case WRITER -> CsvWriter.getInstance();
            default -> throw new IllegalArgumentException("Ops, this type does not exist!");
        };
    }

    public enum CsvType {
        READER,
        WRITER
    }
}
