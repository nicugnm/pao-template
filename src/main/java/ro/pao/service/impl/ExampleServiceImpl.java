package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.ExampleClass;
import ro.pao.service.ExampleService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class ExampleServiceImpl implements ExampleService {

    /**
     * Atentie sa fie static. Daca nu o sa fie static, fiecare instanta va avea propria ei lista si astfel vor aparea probleme la apelarea metodelor.
     * Se poate inlocui si cu un Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();
     * Si astfel veti avea o performanta la operatii.
     *
     * Puteti folosi diverse structuri de date in functie de nevoi, tinand cont de complexitate.
     */
    private static List<ExampleClass> eggList = new ArrayList<>();
    // private static Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();

    @Override
    public Optional<ExampleClass> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExampleClass> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<ExampleClass> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<ExampleClass> exampleClassList) {
        eggList.addAll(exampleClassList);
    }

    @Override
    public void addOnlyOne(ExampleClass exampleClass) {
        eggList.add(exampleClass);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getId())) // filtrez elementele astfel incat elementul cautat sa nu fie id-ul dat
                // astfel, o sa avem o lista care nu contine elementul dat
                .collect(Collectors.toList()); // daca folosim .toList() se va crea o lista imutabila.
                // .collect(Collectors.toList()) face o lista mutabila
    }

    @Override
    public void modificaElementById(UUID id, ExampleClass newElement) {
        // sterg elementul dat si adaug altul
        removeElementById(id);
        addOnlyOne(newElement);
    }

    /** Method example that reads employees from csv */
    /*
    This code will print the contents of the CSV file to the console in two different formats:
    allLines: a list of arrays, where each array represents a row in the CSV file.
    lineByLine: a list of arrays, where each array represents a single line in the CSV file.

    The output will look something like this:

    [id, first_name, last_name, email, gender, age]
    [1, John, Doe, john.doe@example.com, Male, 35]
    [2, Jane, Doe, jane.doe@example.com, Female, 30]
    [3, Bob, Smith, bob.smith@example.com, Male, 45]

    [1, John, Doe, john.doe@example.com, Male, 35]
    [2, Jane, Doe, jane.doe@example.com, Female, 30]
    [3, Bob, Smith, bob.smith@example.com, Male, 45]
    This is just a simple example, but I hope it helps you understand how you can use this CsvReader implementation in your own projects.
     */
    private void readFromCsv(List<ExampleClass> exampleClassList) throws Exception {
        try {
            CsvReader csvReader = CsvReader.getInstance();

            // Read all lines at once
            List<String[]> allLines = csvReader.executeAllLines();
            for (String[] line : allLines) {
                System.out.println(Arrays.toString(line));
            }

            // Read line by line
            List<String[]> lineByLine = csvReader.executeLineByLine();
            for (String[] line : lineByLine) {
                System.out.println(Arrays.toString(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Method example that writes employees to csv */
    private void writeToCsv(List<ExampleClass> exampleClassList) throws Exception {
        // Suppose you have a list of String[] arrays representing rows in a CSV file, like this:
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[] {"id", "name", "age"});
        lines.add(new String[] {"1", "John Doe", "35"});
        lines.add(new String[] {"2", "Jane Doe", "30"});
        lines.add(new String[] {"3", "Bob Smith", "45"});

        // To write this data to a CSV file using CsvWriter, you can write the following code:

        try {
            CsvWriter csvWriter = CsvWriter.getInstance();

            // Write line by line
            Path lineByLinePath = Paths.get("line_by_line.csv");
            String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
            System.out.println("Contents of line_by_line.csv:");
            System.out.println(lineByLineContents);

            // Write all lines at once
            Path allLinesPath = Paths.get("all_lines.csv");
            String allLinesContents = csvWriter.writeAllLines(lines, allLinesPath);
            System.out.println("Contents of all_lines.csv:");
            System.out.println(allLinesContents);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        This code will write the contents of the lines list to two different CSV files: "line_by_line.csv" and "all_lines.csv". It will then read the contents of both files and print them to the console.
        The output will look something like this:

        Contents of line_by_line.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45

    Contents of all_lines.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45
         */
    }
}
