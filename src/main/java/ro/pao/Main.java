package ro.pao;

import ro.pao.application.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.crud();

            menu.sortingLocations();

            menu.sortingClients();

            menu.upAndDownCasting();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }
    }
}
