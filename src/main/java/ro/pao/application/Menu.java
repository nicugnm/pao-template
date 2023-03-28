package ro.pao.application;

import ro.pao.model.*;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.CulturalLocationType;
import ro.pao.model.enums.CulturalEventType;
import ro.pao.model.enums.SportsLocationType;
import ro.pao.model.enums.SportsEventType;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    private static Menu INSTANCE;

    private final CulturalEventService culturalEventService = new CulturalEventServiceImpl();

    private final SportsEventService sportsEventService = new SportsEventServiceImpl();

    private final CulturalLocationService culturalLocationService = new CulturalLocationServiceImpl();

    private final SportsLocationService sportsLocationService = new SportsLocationServiceImpl();

    private final ClientService clientService = new ClientServiceImpl();

    private final TicketService ticketService = new TicketServiceImpl();

    private final MailService mailService = new MailServiceImpl();

    private final CardService cardService = new CardServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void crud() {

        String crud = """
                CRUD example
                """;

        System.out.println(crud);

        CulturalEvent culturalEvent = CulturalEvent.builder()
                .id(UUID.randomUUID())
                .creationDateTime(LocalDateTime.now())
                .deleteDateTime(LocalDateTime.now())
                .build();

        culturalEventService.addOnlyOne(culturalEvent);

        Map<UUID, CulturalEvent> culturalEventServiceMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 0))
                        .build(),
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 30))
                        .build()
        ).collect(Collectors.toMap(CulturalEvent::getId, Function.identity()));

        culturalEventService.addAllFromGivenMap(culturalEventServiceMap);

        System.out.println("Initial: ");
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter setting start and end date-time: ");
        culturalEvent.setStartDateTime(LocalDateTime.of(2023, 4, 2, 18,0));
        culturalEvent.setEndDateTime(LocalDateTime.of(2023, 4, 2, 20, 30));
        culturalEventService.updateElementById(culturalEvent.getId(), culturalEvent);
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter removal: ");
        culturalEventService.removeElementById(culturalEvent.getId());
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

    }


    public void sortingLocations() {

        String sorting = """
                \nSorting locations example
                """;

        System.out.println(sorting + "\nFirst Approach (with the service implementation using sort method()):");

        culturalLocationService.addAllFromGivenMap(Stream.of(
                CulturalLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location ONE")
                        .address("Address, 1st Street, No. 19")
                        .culturalEventLocationType(CulturalLocationType.CONCERT_HALL)
                        .build(),
                CulturalLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location TWO")
                        .address("Address, 2nd Street, No. 3")
                        .build(),
                CulturalLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location THREE")
                        .address("Address, 3rd Street, No. 10")
                        .culturalEventLocationType(CulturalLocationType.THEATER)
                        .build()
        ).collect(Collectors.toMap(CulturalLocation::getId, Function.identity())));

        culturalLocationService.sortByName()
                .forEach((keys, values) -> System.out.println(values));


        System.out.println("\nSecond Approach (using TreeSet), so that elements are inserted directly in sorted order:");

        TreeSet<SportsLocation> sportsLocationServiceSet = Stream.of(
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location ONE")
                        .address("Address, 1st Street, No. 19")
                        .sportsEventLocationType(SportsLocationType.ARENA)
                        .build(),
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location TWO")
                        .address("Address, 2nd Street, No. 3")
                        .sportsEventLocationType(SportsLocationType.POOL)
                        .build(),
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location THREE")
                        .address("Region Address, No. 10")
                        .sportsEventLocationType(SportsLocationType.CYCLING_ROUTE)
                        .build()
        ).distinct().collect(Collectors.toCollection(TreeSet::new));

        System.out.println(sportsLocationServiceSet);

    }

    public void sortingClients() {

        String sorting = """
                \nSorting clients example
                """;

        System.out.println('\n' + sorting);

        Map<UUID, CulturalEvent> culturalEventServiceMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 0))
                        .build(),
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 30))
                        .build()
        ).collect(Collectors.toMap(CulturalEvent::getId, Function.identity()));

        clientService.addAllFromGivenMap(Stream.of(
                Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Client1")
                        .lastName("Clientescu")
                        .ticketList(List.of(Ticket.builder()
                                        .id(UUID.randomUUID())
                                        .eventId((UUID) culturalEventServiceMap.keySet().toArray()[0])
                                        .build(),
                                            Ticket.builder()
                                            .id(UUID.randomUUID())
                                            .eventId((UUID) culturalEventServiceMap.keySet().toArray()[0])
                                            .build()))
                        .build(),
                Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Client2")
                        .lastName("Clientescu")
                        .ticketList(List.of(Ticket.builder()
                                .id(UUID.randomUUID())
                                .eventId((UUID) culturalEventServiceMap.keySet().toArray()[0])
                                .build()))
                        .build()
        ).collect(Collectors.toMap(Client::getId, Function.identity())));

        clientService.sortByTickets()
                .forEach((keys, values) -> System.out.println(values));

    }


    public void upAndDownCasting() {
        String casting = """
                \nUp- and Down-casting example:
                """;

        System.out.println(casting);

        Map<UUID, Event> eventServiceMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 28, 21, 17))
                        .startDateTime(LocalDateTime.of(2023, 03, 31, 17, 0))
                        .endDateTime(LocalDateTime.of(2023, 03, 31, 18, 0))
                        .culturalEventType(CulturalEventType.BALLET)
                        .culturalLocation(CulturalLocation.builder()
                                .id(UUID.randomUUID())
                                .name("Location ONE")
                                .address("Address, 1st Street, No. 19")
                                .culturalEventLocationType(CulturalLocationType.CONCERT_HALL)
                                .build())
                        .build(),
                SportsEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 25, 11, 30))
                        .sportsEventType(SportsEventType.TENNIS)
                        .sportsLocation(SportsLocation.builder()
                                .id(UUID.randomUUID())
                                .name("Location TWO")
                                .address("Address, 2nd Street, No. 3")
                                .sportsEventLocationType(SportsLocationType.ARENA)
                                .build())
                        .build(),
                SportsEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 29, 15, 15))
                        .sportsEventType(SportsEventType.SWIMMING)
                        .sportsLocation(SportsLocation.builder()
                                .id(UUID.randomUUID())
                                .name("Location TWO")
                                .address("Address, 2nd Street, No. 3")
                                .sportsEventLocationType(SportsLocationType.POOL)
                                .build())
                        .build()
        ).collect(Collectors.toMap(Event::getId, Function.identity()));

        for (Event event : eventServiceMap.values()) {
            if (event instanceof CulturalEvent) {
                System.out.println(((CulturalEvent) event).getCulturalEventType());
                System.out.println(event.nrTicketsCategories());
            }
            else {
                System.out.println(((SportsEvent) event).getSportsEventType());
                System.out.println(event.nrTicketsCategories());
            }
        }

    }

}
