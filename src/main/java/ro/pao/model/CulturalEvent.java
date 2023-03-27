package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;
import ro.pao.model.enums.CulturalEventType;

import java.util.UUID;

@SuperBuilder
@Getter
public class CulturalEvent extends Event {

    private String title;

    private String description;

    private CulturalEventType culturalEventType;

}
