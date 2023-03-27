package ro.pao.service;

import org.junit.jupiter.api.Test;
import ro.pao.application.Menu;
import ro.pao.model.CulturalEvent;
import ro.pao.service.impl.CulturalEventServiceImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CulturalEventServiceTest {

    private final Menu menu = Menu.getInstance();
    private final CulturalEventService culturalEventService = new CulturalEventServiceImpl();

    @Test
    void whenGivenCulturalEventClass_thenElementIsAdd() {

        CulturalEvent culturalEvent = CulturalEvent.builder()
                .id(UUID.randomUUID())
                .build();

        culturalEventService.addOnlyOne(culturalEvent);

        assertEquals(1, culturalEventService.getAllFromList().size());

    }
}
