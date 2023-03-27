package ro.pao.application;

import ro.pao.model.CulturalEvent;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("Before removal: ");
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));


        System.out.println("After setting start and end date-time: ");
        culturalEvent.setStartDateTime(LocalDateTime.of(2023, 4, 2, 18,0));
        culturalEvent.setEndDateTime(LocalDateTime.of(2023, 4, 2, 20, 30));
        culturalEventService.updateElementById(culturalEvent.getId(), culturalEvent);
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));

        System.out.println("After removal: ");
        culturalEventService.removeElementById(culturalEvent.getId());
        culturalEventService.getAllFromMap()
                .forEach((keys, values) -> System.out.println(values));
    }
}
