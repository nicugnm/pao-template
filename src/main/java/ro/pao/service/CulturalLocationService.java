package ro.pao.service;

import ro.pao.model.CulturalLocation;
import ro.pao.model.enums.CulturalLocationType;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface CulturalLocationService {

    Optional<CulturalLocation> getById(UUID id);

    Optional<CulturalLocation> getByType(CulturalLocationType culturalLocationType);

    Map<UUID, CulturalLocation> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, CulturalLocation> culturalLocationMap);

    void addOnlyOne(CulturalLocation culturalLocation);

    void removeElementById(UUID id);

    void updateElementById(UUID id, CulturalLocation newElement);

}
