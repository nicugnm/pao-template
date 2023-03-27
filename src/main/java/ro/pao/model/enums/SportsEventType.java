package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SportsEventType {
    TENNIS("tennis"),
    FIGURE_SKATING("figure skating"),
    SWIMMING("swimming"),
    CYCLING("cycling"),
    NONE("none");

    private final String typeString;

    public static SportsEventType getEnumByFieldString(String field) {
        return Arrays.stream(SportsEventType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
