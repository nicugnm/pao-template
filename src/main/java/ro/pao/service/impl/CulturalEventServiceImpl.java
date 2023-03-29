package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.model.enums.CulturalEventType;
import ro.pao.service.CulturalEventService;

import java.util.*;
import java.util.stream.Collectors;

public class CulturalEventServiceImpl implements CulturalEventService {

    private static Map<UUID, CulturalEvent> culturalEventMap = new HashMap<>();

    @Override
    public Optional<CulturalEvent> getById(UUID id) {
        return culturalEventMap.values().stream()
                .filter(element -> id.equals(element.getId()))
                .findAny();
    }

    @Override
    public Optional<CulturalEvent> getByType(CulturalEventType culturalEventType) {
        return culturalEventMap.values().stream()
                .filter(element -> culturalEventType.equals(element.getCulturalEventType()))
                .findAny();
    }

    @Override
    public Map<UUID, CulturalEvent> getAllFromMap() {
        return culturalEventMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, CulturalEvent> culturalEventMap) {
        CulturalEventServiceImpl.culturalEventMap.putAll(culturalEventMap);
    }

    @Override
    public void addOnlyOne(CulturalEvent culturalEvent) {
        culturalEventMap.put(culturalEvent.getId(), culturalEvent);
    }

    @Override
    public void removeElementById(UUID id) {
        culturalEventMap = culturalEventMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, CulturalEvent newCulturalEvent) {
        removeElementById(id);
        addOnlyOne(newCulturalEvent);
    }

}
