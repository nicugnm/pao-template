package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.CulturalEventType;

import java.util.List;

@SuperBuilder
@Getter
public class CulturalEvent extends Event {

    private String title;

    private String description;

    private CulturalEventType culturalEventType;

    private CulturalLocation culturalLocation;

    public List<Integer> nrTicketsCategories() {
        return switch (culturalLocation.getCulturalEventLocationType()) {
            case CONCERT_HALL -> List.of(5, 10, 35, 50);
            case OPERA_HOUSE -> List.of(10, 15, 30, 45);
            case THEATER-> List.of(10, 15, 35, 40);
            case ARENA -> List.of(15, 30, 30, 25);
            case NONE -> List.of();
        };

    }

}
