package ro.pao.service.impl;

import ro.pao.model.CulturalLocation;
import ro.pao.model.SportsLocation;
import ro.pao.service.CulturalEventService;
import ro.pao.service.CulturalLocationService;

import java.util.*;
import java.util.stream.Collectors;

public class CulturalLocationServiceImpl implements CulturalLocationService {

    private static Map<UUID, CulturalLocation> culturalLocationMap = new HashMap<>();

    @Override
    public Optional<CulturalLocation> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<CulturalLocation> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public Map<UUID, CulturalLocation> getAllFromMap() {
        return culturalLocationMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, CulturalLocation> locationMap) {
        CulturalLocationServiceImpl.culturalLocationMap.putAll(locationMap);
    }

    @Override
    public void addOnlyOne(CulturalLocation culturalLocation) {
        culturalLocationMap.put(culturalLocation.getId(), culturalLocation);
    }

    @Override
    public void removeElementById(UUID id) {
        culturalLocationMap = culturalLocationMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, CulturalLocation newCulturalLocation) {
        removeElementById(id);
        addOnlyOne(newCulturalLocation);
    }

}
