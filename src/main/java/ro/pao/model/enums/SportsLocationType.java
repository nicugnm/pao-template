package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SportsLocationType {

    ARENA("arena"),

    POOL("pool"),

    CYCLING_ROUTE("cycling route"),

    NONE("none");

    private final String typeString;

    public static SportsLocationType getEnumByFieldString(String field) {
        return Arrays.stream(SportsLocationType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);

    }

}
