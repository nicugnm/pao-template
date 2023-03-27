package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.model.SportsEvent;
import ro.pao.service.SportsEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class SportsEventServiceImpl implements SportsEventService {

    private static List<SportsEvent> sportsEventList = new ArrayList<>();

    @Override
    public Optional<SportsEvent> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<SportsEvent> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<SportsEvent> getAllFromList() {
        return sportsEventList;
    }

    @Override
    public void addAllFromGivenList(List<SportsEvent> sportsEventList) {
        SportsEventServiceImpl.sportsEventList.addAll(sportsEventList);
    }

    @Override
    public void addOnlyOne(SportsEvent sportsEvent) {
        sportsEventList.add(sportsEvent);
    }

    @Override
    public void removeElementById(UUID id) {
        sportsEventList = sportsEventList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, SportsEvent newSportsEvent) {
        removeElementById(id);
        addOnlyOne(newSportsEvent);
    }

}
