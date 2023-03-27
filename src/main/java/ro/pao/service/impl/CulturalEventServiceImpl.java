package ro.pao.service.impl;

import ro.pao.model.CulturalEvent;
import ro.pao.service.CulturalEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class CulturalEventServiceImpl implements CulturalEventService {

    private static List<CulturalEvent> culturalEventList = new ArrayList<>();

    @Override
    public Optional<CulturalEvent> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<CulturalEvent> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<CulturalEvent> getAllFromList() {
        return culturalEventList;
    }

    @Override
    public void addAllFromGivenList(List<CulturalEvent> culturalEventList) {
        CulturalEventServiceImpl.culturalEventList.addAll(culturalEventList);
    }

    @Override
    public void addOnlyOne(CulturalEvent culturalEvent) {
        culturalEventList.add(culturalEvent);
    }

    @Override
    public void removeElementById(UUID id) {
        culturalEventList = culturalEventList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, CulturalEvent newCulturalEvent) {
        removeElementById(id);
        addOnlyOne(newCulturalEvent);
    }

}
