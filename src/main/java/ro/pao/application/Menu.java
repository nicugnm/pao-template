package ro.pao.application;

import ro.pao.model.*;
import ro.pao.model.abstracts.Event;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.CulturalLocationType;
import ro.pao.model.enums.CulturalEventType;
import ro.pao.model.enums.SportsLocationType;
import ro.pao.model.enums.SportsEventType;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
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

    public void crudCulturalEvent() {

        String crud = """
                CRUD for CulturalEvents - example
                """;

        System.out.println(crud);

        CulturalEvent culturalEvent = CulturalEvent.builder()
                .id(UUID.randomUUID())
                .title("Desteptarea primaverii")
                .build();

        culturalEventService.addOnlyOne(culturalEvent);

        Map<UUID, CulturalEvent> culturalEventMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .title("Raymonda")
                        .culturalEventType(CulturalEventType.BALLET)
                        .build(),
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .title("Nunta lui Figaro")
                        .culturalEventType(CulturalEventType.OPERA)
                        .build()
        ).collect(Collectors.toMap(CulturalEvent::getId, Function.identity()));

        culturalEventService.addAllFromGivenMap(culturalEventMap);

        System.out.println("Initial: ");
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter setting location-type and location: ");
        culturalEvent.setCulturalEventType(CulturalEventType.THEATER);
        culturalEvent.setCulturalLocation(CulturalLocation.builder().id(UUID.randomUUID()).culturalEventLocationType(CulturalLocationType.THEATER).build());
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter update: ");
        CulturalEvent newCulturalEvent = CulturalEvent.builder().id(UUID.randomUUID()).title("Marea simfonie, op. 8").culturalEventType(CulturalEventType.CONCERT).build();
        culturalEventService.updateElementById(culturalEvent.getId(), newCulturalEvent);
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter removal: ");
        culturalEventService.removeElementById(newCulturalEvent.getId());
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nSelect events from category 'OPERA': ");
        if(culturalEventService.getByType(CulturalEventType.OPERA).isPresent())
            System.out.println(culturalEventService.getByType(CulturalEventType.OPERA).get());

    }

    public void crudLocations() {

        String crud = """
                \nCRUD for SportsLocations - example
                """;

        System.out.println(crud);

        SportsLocation sportsLocation = SportsLocation.builder()
                .id(UUID.randomUUID())
                .name("Baza sportiva 1")
                .build();

        sportsLocationService.addOnlyOne(sportsLocation);

        Map<UUID, SportsLocation> sportsLocationMap = Stream.of(
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Patinoarul central")
                        .sportsLocationType(SportsLocationType.ARENA)
                        .build(),
                sportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Bazinul olimpic")
                        .sportsLocationType(SportsLocationType.POOL)
                        .build()
        ).collect(Collectors.toMap(SportsLocation::getId, Function.identity()));

        sportsLocationService.addAllFromGivenMap(sportsLocationMap);

        System.out.println("Initial: ");
        sportsLocationService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter setting location-type: ");
        sportsLocation.setSportsLocationType(SportsLocationType.ARENA);
        sportsLocationService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter update: ");
        SportsLocation newSportsLocation = SportsLocation.builder().id(UUID.randomUUID()).name("Baza sportiva renovata").build();
        sportsLocationService.updateElementById(sportsLocation.getId(), newSportsLocation);
        sportsLocationService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nAfter removal: ");
        sportsLocationService.removeElementById(newSportsLocation.getId());
        sportsLocationService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("\nSelect locations from category 'ARENA': ");
        if(sportsLocationService.getByType(SportsLocationType.ARENA).isPresent())
            System.out.println(sportsLocationService.getByType(SportsLocationType.ARENA).get());

    }

    public Map<UUID, CulturalLocation> sortByLocationName(Map<UUID, CulturalLocation> culturalLocationMap) {

        Map<UUID, CulturalLocation> culturalLocationSortedMap = new LinkedHashMap<>();
        List<CulturalLocation> culturalLocationSortedList = new ArrayList<>();

        for (Map.Entry<UUID, CulturalLocation> entry : culturalLocationMap.entrySet()) {
            culturalLocationSortedList.add(entry.getValue());
        }

        Collections.sort(culturalLocationSortedList);

        for (CulturalLocation culturalLocation : culturalLocationSortedList) {
            for (Map.Entry<UUID, CulturalLocation> entry : culturalLocationMap.entrySet()) {
                if (entry.getValue().equals(culturalLocation)) {
                    culturalLocationSortedMap.put(entry.getKey(), culturalLocation);
                }
            }
        }

        return culturalLocationSortedMap;

    }

    public void sortingLocations() {

        String sorting = """
                \nSorting locations example
                """;

        System.out.println(sorting + "\nFirst Approach (with the service implementation using sort method()):");

        Map<UUID, CulturalLocation> culturalLocationMap = (Stream.of(
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

        sortByLocationName(culturalLocationMap).forEach((keys, values) -> System.out.println(values));

        System.out.println("\nSecond Approach (using TreeSet), so that elements are inserted directly in sorted order:");

        TreeSet<SportsLocation> sportsLocationServiceSet = Stream.of(
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location ONE")
                        .address("Address, 1st Street, No. 19")
                        .sportsLocationType(SportsLocationType.ARENA)
                        .build(),
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location TWO")
                        .address("Address, 2nd Street, No. 3")
                        .sportsLocationType(SportsLocationType.POOL)
                        .build(),
                SportsLocation.builder()
                        .id(UUID.randomUUID())
                        .name("Location THREE")
                        .address("Region Address, No. 10")
                        .sportsLocationType(SportsLocationType.CYCLING_ROUTE)
                        .build()
        ).distinct().collect(Collectors.toCollection(TreeSet::new));

        System.out.println(sportsLocationServiceSet);

    }

    public Map<UUID, Client> sortClientsByTickets(Map<UUID, Client> clientMap) {

        Map<UUID, Client> clientSortedMap = new LinkedHashMap<>();
        List<Client> clientSortedList = new ArrayList<>();

        for (Map.Entry<UUID, Client> entry : clientMap.entrySet()) {
            clientSortedList.add(entry.getValue());
        }

        Collections.sort(clientSortedList);

        for (Client client : clientSortedList) {
            for (Map.Entry<UUID, Client> entry : clientMap.entrySet()) {
                if (entry.getValue().equals(client)) {
                    clientSortedMap.put(entry.getKey(), client);
                }
            }
        }

        return clientSortedMap;

    }

    public void sortingClients() {

        String sorting = """
                \nSorting clients example
                """;

        System.out.println('\n' + sorting);

        Map<UUID, Client> clientMap = new HashMap<>();

        clientMap = Stream.of(
                Client.builder()
                        .id(UUID.randomUUID())
                        .build(),
                Client.builder()
                        .id(UUID.randomUUID())
                        .build()
        ).collect(Collectors.toMap(Client::getId, Function.identity()));

        clientMap = (Stream.of(
                Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Client1")
                        .lastName("Clientescu")
                        .ticketList(List.of(Ticket.builder()
                                        .id(UUID.randomUUID())
                                        .eventId((UUID) clientMap.keySet().toArray()[0])
                                        .build(),
                                            Ticket.builder()
                                            .id(UUID.randomUUID())
                                            .eventId((UUID) clientMap.keySet().toArray()[0])
                                            .build()))
                        .build(),
                Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Client2")
                        .lastName("Clientescu")
                        .ticketList(List.of(Ticket.builder()
                                .id(UUID.randomUUID())
                                .eventId((UUID) clientMap.keySet().toArray()[0])
                                .build()))
                        .build()
        ).collect(Collectors.toMap(Client::getId, Function.identity())));

        sortClientsByTickets(clientMap).forEach((keys, values) -> System.out.println(values));

    }

    public Map<UUID, Event> sortEventsByDate(Map<UUID, Event> eventMap) {

        Map<UUID, Event> eventSortedMap = new LinkedHashMap<>();
        List<Event> eventSortedList = new ArrayList<>();

        for (Map.Entry<UUID, Event> entry : eventMap.entrySet()) {
            eventSortedList.add(entry.getValue());
        }

        Collections.sort(eventSortedList);

        for (Event event : eventSortedList) {
            for (Map.Entry<UUID, Event> entry : eventMap.entrySet()) {
                if (entry.getValue().equals(event)) {
                    eventSortedMap.put(entry.getKey(), event);
                }
            }
        }

        return eventSortedMap;

    }

    public void sortingEvents() {

        String sorting = """
                \nSorting events example
                """;

        System.out.println('\n' + sorting);

        Map<UUID, Event> eventMap = new HashMap<>();

        eventMap = Stream.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .startDateTime(LocalDateTime.of(2023, 04, 2, 12, 0))
                        .build(), SportsEvent.builder()
                        .id(UUID.randomUUID())
                        .startDateTime(LocalDateTime.of(2023, 04, 2, 17, 0))
                        .build()
        ).collect(Collectors.toMap(Event::getId, Function.identity()));

        sortEventsByDate(eventMap).forEach((keys, values) -> System.out.println(values));

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
                                .culturalEventLocationType(CulturalLocationType.OPERA_HOUSE)
                                .capacity(200)
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
                                .sportsLocationType(SportsLocationType.ARENA)
                                .capacity(200)
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
                                .sportsLocationType(SportsLocationType.POOL)
                                .capacity(300)
                                .build())
                        .build()
        ).collect(Collectors.toMap(Event::getId, Function.identity()));

        for (Event event : eventServiceMap.values()) {
            Integer capacity;
            if (event instanceof CulturalEvent) {
                System.out.println("Type of the event: " + ((CulturalEvent) event).getCulturalEventType());
                capacity = ((CulturalEvent) event).getCulturalLocation().getCapacity();
            }
            else {
                System.out.println("Type of the event: " + ((SportsEvent) event).getSportsEventType());
                capacity = ((SportsEvent) event).getSportsLocation().getCapacity();
            }
            System.out.println("Total number of tickets available for this event:" + capacity);
            System.out.println("Number of VIP tickets: " + event.nrTicketsCategories().get(0) +
                               "\nNumber of Premium tickets: " + event.nrTicketsCategories().get(1) +
                               "\nNumber of Medium tickets: " + event.nrTicketsCategories().get(2) +
                               "\nNumber of Low-Medium tickets: " + event.nrTicketsCategories().get(3) + '\n');
        }

    }

}
