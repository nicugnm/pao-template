package ro.pao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.CulturalEventType;
import ro.pao.model.enums.CulturalLocationType;

import java.util.List;

@SuperBuilder
@Getter
@Setter
public class CulturalEvent extends Event {

    private String title;

    private String description;

    private CulturalEventType culturalEventType;

    private CulturalLocation culturalLocation;

    public List<Integer> nrTicketsCategories() {
        Integer capacity = culturalLocation.getCapacity();
        CulturalLocationType locationType = culturalLocation.getCulturalEventLocationType();
        return List.of(capacity * locationType.getPercentageVipTickets() / 100, capacity * locationType.getPercentagePremiumTickets() / 100,
                       capacity * locationType.getPercentageMediumTickets() / 100, capacity * locationType.getPercentageLowMediumTickets() / 100);

    }

    @Override
    public String toString() {
        return "CulturalEvent{" +
                super.toString() +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", culturalEventType=" + culturalEventType +
                ", culturalLocation=" + culturalLocation +
                '}';
    }

}
