package ro.pao.application.csv;

import java.util.List;

public interface CsvExecutor {

    List<String[]> executeLineByLine() throws Exception;

    List<String[]> executeAllLines() throws Exception;

    String executeLineByLine(List<String[]> lines) throws Exception;

    String executeAllLines(List<String[]> lines) throws Exception;
}
