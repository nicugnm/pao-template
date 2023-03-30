package ro.pao.service;

import ro.pao.model.CulturalEvent;
import ro.pao.model.SportsEvent;
import ro.pao.model.SportsLocation;
import ro.pao.model.enums.SportsLocationType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface SportsEventService {

    Optional<SportsEvent> getById(UUID id);

    Optional<SportsEvent> getByLocation(SportsLocation sportsLocation);

    Map<UUID, SportsEvent> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, SportsEvent> sportsEventMap);

    void addOnlyOne(SportsEvent sportsEvent);

    void removeElementById(UUID id);

    void updateElementById(UUID id, SportsEvent newSportsEvent);

    Map<UUID, SportsEvent> filterByLocationType(SportsLocationType sportsLocationType);

}
