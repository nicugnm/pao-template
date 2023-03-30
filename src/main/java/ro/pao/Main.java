package ro.pao;

import ro.pao.application.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.crudCulturalEvent();

            menu.crudLocations();

            menu.sortingClients();

            menu.sortingLocations();

            menu.sortingEvents();

            menu.ticketsCategoriesForEvent();

            menu.availableTickets();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }
    }
}
