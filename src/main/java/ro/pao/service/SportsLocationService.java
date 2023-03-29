package ro.pao.service;

import ro.pao.model.SportsLocation;
import ro.pao.model.enums.SportsLocationType;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface SportsLocationService {

    Optional<SportsLocation> getById(UUID id);

    Optional<SportsLocation> getByType(SportsLocationType sportsLocationType);

    Map<UUID, SportsLocation> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, SportsLocation> sportsLocationMap);

    void addOnlyOne(SportsLocation sportsLocation);

    void removeElementById(UUID id);

    void updateElementById(UUID id, SportsLocation newElement);

}
