package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.model.Location;
import ro.pao.service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class LocationServiceImpl implements LocationService {

    private static List<Location> locationList = new ArrayList<>();

    @Override
    public Optional<Location> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Location> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<Location> getAllFromList() {
        return locationList;
    }

    @Override
    public void addAllFromGivenList(List<Location> locationList) {
        LocationServiceImpl.locationList.addAll(locationList);
    }

    @Override
    public void addOnlyOne(Location location) {
        locationList.add(location);
    }

    @Override
    public void removeElementById(UUID id) {
        locationList = locationList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, Location newLocation) {
        removeElementById(id);
        addOnlyOne(newLocation);
    }

}
