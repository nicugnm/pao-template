package ro.pao;

import ro.pao.application.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.intro();

            System.out.println("Type 'exit' to exit the program, or anything else to continue.");

            if ("exit".equals(scanner.next())) {
                break;
            }
        }
    }
}
