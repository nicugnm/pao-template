package ro.pao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.CulturalEventType;
import ro.pao.model.enums.CulturalLocationType;
import ro.pao.model.enums.SportsEventType;
import ro.pao.model.enums.SportsLocationType;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Getter
@Setter
public class SportsEvent extends Event {

    private String competition;

    private String stage;

    private SportsEventType sportsEventType;

    private SportsLocation sportsLocation;

    public SportsEvent(UUID id, LocalDateTime creationDateTime, LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime deleteDateTime,
                       String competition, String stage, SportsEventType sportsEventType, SportsLocation sportsLocation) {
        super(id, creationDateTime, startDateTime, endDateTime, deleteDateTime);
        this.competition = competition;
        this.stage = stage;
        this.sportsEventType = sportsEventType;
        this.sportsLocation = sportsLocation;
        this.setNrAvailableTickets(sportsLocation != null ? sportsLocation.getCapacity() : 0);
    }

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
