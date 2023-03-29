package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.CulturalLocationType;
import ro.pao.model.enums.SportsEventType;
import ro.pao.model.enums.SportsLocationType;

import java.util.Arrays;
import java.util.List;

@SuperBuilder
@Getter
public class SportsEvent extends Event {

    private String competition;

    private String stage;

    private SportsEventType sportsEventType;

    private SportsLocation sportsLocation;

    public List<Integer> nrTicketsCategories() {
        Integer capacity = sportsLocation.getCapacity();
        SportsLocationType locationType = sportsLocation.getSportsLocationType();
        return List.of(capacity * locationType.getPercentageVipTickets() / 100, capacity * locationType.getPercentagePremiumTickets() / 100,
                capacity * locationType.getPercentageMediumTickets() / 100, capacity * locationType.getPercentageLowMediumTickets() / 100);
    }

    @Override
    public String toString() {
        return "SportsEvent{" +
                super.toString() +
                "competition='" + competition + '\'' +
                ", stage='" + stage + '\'' +
                ", sportsEventType=" + sportsEventType +
                ", sportsLocation=" + sportsLocation +
                '}';
    }

}
