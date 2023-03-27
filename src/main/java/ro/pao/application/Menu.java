package ro.pao.application;

import ro.pao.model.CulturalEvent;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Menu {

    private static Menu INSTANCE;

    private final CulturalEventService culturalEventService = new CulturalEventServiceImpl();

    private final SportsEventService sportsEventService = new SportsEventServiceImpl();

    private final LocationService locationService = new LocationServiceImpl();

    private final ClientService clientService = new ClientServiceImpl();

    private final TicketService ticketService = new TicketServiceImpl();

    private final MailService mailService = new MailServiceImpl();

    private final CardService cardService = new CardServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        CulturalEvent culturalEvent = CulturalEvent.builder()
                .id(UUID.randomUUID())
                .creationDateTime(LocalDateTime.now()) // data de azi
                .deleteDateTime(LocalDateTime.now())
                .build();

        culturalEventService.addOnlyOne(culturalEvent);

        List<CulturalEvent> culturalEventServiceList = List.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 0))
                        .build(),
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 30))
                        .build()
        );

        culturalEventService.addAllFromGivenList(culturalEventServiceList);

        System.out.println("Before removal: ");
        culturalEventService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("After setting start and end date-time: ");
        culturalEvent.setStartDateTime(LocalDateTime.of(2023, 4, 2, 18,0));
        culturalEvent.setEndDateTime(LocalDateTime.of(2023, 4, 2, 20, 30));
        culturalEventService.updateElementById(culturalEvent.getId(), culturalEvent);
        culturalEventService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("After removal: ");
        culturalEventService.removeElementById(culturalEvent.getId());
        culturalEventService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
