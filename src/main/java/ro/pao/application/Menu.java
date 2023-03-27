package ro.pao.application;

import ro.pao.model.CulturalEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    private final ExampleService exampleService = new ExampleServiceImpl();

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
                .updateDateTime(LocalDateTime.now())
                .deleteDateTime(LocalDateTime.now())
                .build();

        exampleService.addOnlyOne(culturalEvent);

        List<CulturalEvent> exampleServiceList = List.of(
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 0))
                        .updateDateTime(LocalDateTime.now())
                        .build(),
                CulturalEvent.builder()
                        .id(UUID.randomUUID())
                        .creationDateTime(LocalDateTime.of(2023, 03, 22, 22, 30))
                        .updateDateTime(LocalDateTime.now())
                        .build()
        );

        exampleService.addAllFromGivenList(exampleServiceList);

        System.out.println("Inainte de stergere: ");
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("Dupa modificare: ");
        culturalEvent.setUpdateDateTime(LocalDateTime.of(2, 2, 2, 14, 15));
        exampleService.modificaElementById(culturalEvent.getId(), culturalEvent);
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("Dupa stergere: ");
        exampleService.removeElementById(culturalEvent.getId());
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
