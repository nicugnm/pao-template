package ro.pao.application;

import ro.pao.service.ExampleService;
import ro.pao.service.impl.ExampleServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private void studentMenu() {

    }

    private void professorMenu() {

    }


    public void intro() {
        Scanner scanner = new Scanner(System.in);
        String intro = """
                
                ----------MINI CLASS REGISTER
                
                """;

        System.out.println(intro);

        while (true) {
            String request = "Choose type of user(1-Student, 2-Professor): ";
            System.out.println(request);
            if ("1".equals(scanner.next())) {
                studentMenu();
                break;
            } else if ("2".equals(scanner.next())) {
                professorMenu();
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

    }
}
