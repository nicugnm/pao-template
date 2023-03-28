package ro.pao.service.impl;

import ro.pao.model.CulturalLocation;
import ro.pao.model.SportsLocation;
import ro.pao.service.CulturalEventService;
import ro.pao.service.CulturalLocationService;
import ro.pao.service.SportsLocationService;

import java.util.*;
import java.util.stream.Collectors;

public class SportsLocationServiceImpl implements SportsLocationService {

    private static Map<UUID, SportsLocation> sportsLocationMap = new HashMap<>();

    @Override
    public Optional<SportsLocation> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<SportsLocation> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public Map<UUID, SportsLocation> getAllFromMap() {
        return sportsLocationMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, SportsLocation> locationMap) {
        SportsLocationServiceImpl.sportsLocationMap.putAll(locationMap);
    }

    @Override
    public void addOnlyOne(SportsLocation sportsLocation) {
        sportsLocationMap.put(sportsLocation.getId(), sportsLocation);
    }

    @Override
    public void removeElementById(UUID id) {
        sportsLocationMap = sportsLocationMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, SportsLocation newSportsLocation) {
        removeElementById(id);
        addOnlyOne(newSportsLocation);
    }

    @Override
    public Map<UUID, SportsLocation> sortByName() {

        Map<UUID, SportsLocation> sportsLocationSortedMap = new LinkedHashMap<>();
        List<SportsLocation> sportsLocationSortedList = new ArrayList<>();

        for (Map.Entry<UUID, SportsLocation> entry : getAllFromMap().entrySet()) {
            sportsLocationSortedList.add(entry.getValue());
        }

        Collections.sort(sportsLocationSortedList);

        for (SportsLocation sportsLocation : sportsLocationSortedList) {
            for (Map.Entry<UUID, SportsLocation> entry : getAllFromMap().entrySet()) {
                if (entry.getValue().equals(sportsLocation)) {
                    sportsLocationSortedMap.put(entry.getKey(), sportsLocation);
                }
            }
        }

        return sportsLocationSortedMap;

    }

}
