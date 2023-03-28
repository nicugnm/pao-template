package ro.pao.service;

import ro.pao.model.CulturalEvent;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface CulturalEventService {

    Optional<CulturalEvent> getById(UUID id);

    Optional<CulturalEvent> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    Map<UUID, CulturalEvent> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, CulturalEvent> culturalEventMap);

    void addOnlyOne(CulturalEvent culturalEvent);

    void removeElementById(UUID id);

    void updateElementById(UUID id, CulturalEvent newCulturalEvent);

}
