package ro.pao.service;

import ro.pao.model.CardInformation;
import ro.pao.model.CulturalEvent;
import ro.pao.model.Location;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CulturalEventService {

    Optional<CulturalEvent> getById(UUID id);

    Optional<CulturalEvent> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    List<CulturalEvent> getAllFromList();

    void addAllFromGivenList(List<CulturalEvent> culturalEventList);

    void addOnlyOne(CulturalEvent culturalEvent);

    void removeElementById(UUID id);

    void updateElementById(UUID id, CulturalEvent newCulturalEvent);

}
