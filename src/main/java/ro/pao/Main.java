package ro.pao;

import ro.pao.application.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.crudMailInformation();

            menu.crudCulturalEvent();

            menu.crudLocations();

            menu.sortingClients();

            menu.sortingEvents();

            menu.sortingLocations();

            menu.filterSportsEventByLocationType();

            menu.setDeleteTimeForOldEvents();

            menu.ticketsCategoriesForEvent();

            menu.buySellTickets();

            if ("exit".equals(scanner.next())) {
                break;
            }

        }

    }

}
