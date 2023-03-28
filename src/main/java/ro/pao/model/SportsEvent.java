package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.SportsEventType;

import java.util.List;

@SuperBuilder
@Getter
public class SportsEvent extends Event {

    private String competition;

    private String stage;

    private SportsEventType sportsEventType;

    private SportsLocation sportsLocation;

    public List<Integer> nrTicketsCategories() {
        return switch (sportsLocation.getSportsEventLocationType()) {
            case ARENA -> List.of(20, 25, 30, 25);
            case POOL -> List.of(15, 15, 40, 30);
            case CYCLING_ROUTE -> List.of(20, 15, 55, 10);
            case NONE -> List.of();
        };

    }

}
