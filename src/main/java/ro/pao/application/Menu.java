package ro.pao.application;

import ro.pao.model.Client;
import ro.pao.model.CulturalEvent;
import ro.pao.model.Location;
import ro.pao.model.SportsEvent;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.LocationType;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ro.pao.model.enums.CulturalEventType.CONCERT;

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


    public void sortings() {

        String sorting = """
                \nSorting example
                """;

        System.out.println(sorting + "\nFirst Approach (using sort() method):");

        locationService.addAllFromGivenMap(Stream.of(
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location ONE")
                        .address("Address, 1st Street, No. 19")
                        .locationType(LocationType.CONCERTHALL)
                        .build(),
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location TWO")
                        .address("Address, 2nd Street, No. 3")
                        .locationType(LocationType.THEATER)
                        .build(),
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location THREE")
                        .address("Address, 3rd Street, No. 10")
                        .locationType(LocationType.THEATER)
                        .build()
        ).collect(Collectors.toMap(Location::getId, Function.identity())));

        locationService.sortByName()
                .forEach((keys, values) -> System.out.println(values));


        System.out.println("\nSecond Approach (using TreeSet), so that elements are inserted directly in sorted order:");

        TreeSet<Location> locationServiceSet = Stream.of(
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location ONE")
                        .address("Address, 1st Street, No. 19")
                        .locationType(LocationType.CONCERTHALL)
                        .build(),
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location TWO")
                        .address("Address, 2nd Street, No. 3")
                        .locationType(LocationType.THEATER)
                        .build(),
                Location.builder()
                        .id(UUID.randomUUID())
                        .name("Location THREE")
                        .address("Address, 3rd Street, No. 10")
                        .locationType(LocationType.THEATER)
                        .build()
        ).distinct().collect(Collectors.toCollection(TreeSet::new));

        System.out.println(locationServiceSet);

    }


    public void upAndDownCasting() {
        String casting = """
                \nUp- and Down-casting example
                """;

        System.out.println(casting);

        Map<UUID, Event> eventServiceMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 28, 21, 17))
                        .startDateTime(LocalDateTime.of(2023, 03, 31, 17, 0))
                        .endDateTime(LocalDateTime.of(2023, 03, 31, 18, 0))
                        .build(),
                SportsEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 25, 11, 30))
                        .build()
        ).collect(Collectors.toMap(Event::getId, Function.identity()));



    }

}
