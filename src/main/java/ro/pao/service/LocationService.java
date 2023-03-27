package ro.pao.service;

import ro.pao.model.Location;
import ro.pao.model.MailInformation;
import ro.pao.service.impl.LocationServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocationService {

    Optional<Location> getById(UUID id);

    Optional<Location> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    List<Location> getAllFromList();

    void addAllFromGivenList(List<Location> locationList);

    void addOnlyOne(Location location);

    void removeElementById(UUID id);

    void updateElementById(UUID id, Location newElement);

}
