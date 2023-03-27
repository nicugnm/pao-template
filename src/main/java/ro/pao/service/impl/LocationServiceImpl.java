package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.model.Location;
import ro.pao.service.LocationService;

import java.util.*;
import java.util.stream.Collectors;

public class LocationServiceImpl implements LocationService {

    private static Map<UUID, Location> locationMap = new HashMap<>();

    @Override
    public Optional<Location> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Location> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public Map<UUID, Location> getAllFromMap() {
        return locationMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, Location> locationMap) {
        LocationServiceImpl.locationMap.putAll(locationMap);
    }

    @Override
    public void addOnlyOne(Location location) {
        locationMap.put(location.getId(), location);
    }

    @Override
    public void removeElementById(UUID id) {
        locationMap = locationMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, Location newLocation) {
        removeElementById(id);
        addOnlyOne(newLocation);
    }

    @Override
    public Map<UUID, Location> sortByName() {

        Map<UUID, Location> locationSortedMap = new LinkedHashMap<>();
        List<Location> locationSortedList = new ArrayList<>();

        for (Map.Entry<UUID, Location> entry : getAllFromMap().entrySet()) {
            locationSortedList.add(entry.getValue());
        }

        Collections.sort(locationSortedList);

        for (Location location : locationSortedList) {
            for (Map.Entry<UUID, Location> entry : getAllFromMap().entrySet()) {
                if (entry.getValue().equals(location)) {
                    locationSortedMap.put(entry.getKey(), location);
                }
            }
        }

        return locationSortedMap;

    }

}
