package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.LocationType;

import java.util.UUID;

@SuperBuilder
@Getter
public class Location {

    private UUID id;

    private String name;

    private String address;

    private LocationType locationType;
}
