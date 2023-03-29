package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.model.SportsEvent;
import ro.pao.model.SportsLocation;
import ro.pao.service.SportsEventService;

import java.util.*;
import java.util.stream.Collectors;

public class SportsEventServiceImpl implements SportsEventService {

    private static Map<UUID, SportsEvent> sportsEventMap = new HashMap<>();

    @Override
    public Optional<SportsEvent> getById(UUID id) {
        return sportsEventMap.values().stream()
                .filter(element -> id.equals(element.getId()))
                .findAny();
    }

    @Override
    public Optional<SportsEvent> getByLocation(SportsLocation sportsLocation) {
        return sportsEventMap.values().stream()
                .filter(element -> sportsLocation.equals(element.getSportsLocation()))
                .findAny();
    }

    @Override
    public Map<UUID, SportsEvent> getAllFromMap() {
        return sportsEventMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, SportsEvent> sportsEventMap) {
        SportsEventServiceImpl.sportsEventMap.putAll(sportsEventMap);
    }

    @Override
    public void addOnlyOne(SportsEvent sportsEvent) {
        sportsEventMap.put(sportsEvent.getId(), sportsEvent);
    }

    @Override
    public void removeElementById(UUID id) {
        sportsEventMap = sportsEventMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, SportsEvent newSportsEvent) {
        removeElementById(id);
        addOnlyOne(newSportsEvent);
    }

}
