package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.SportsEventType;

import java.util.UUID;

@SuperBuilder
@Getter
public class SportsEvent extends Event {

    private String competition;

    private String stage;

    private SportsEventType sportsEventType;

}
