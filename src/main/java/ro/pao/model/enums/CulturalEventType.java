package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CulturalEventType {
    CONCERT("concert"),
    THEATER("theater"),
    BALLET("ballet"),
    OPERA("opera"),
    NONE("none");

    private final String typeString;

    public static CulturalEventType getEnumByFieldString(String field) {
        return Arrays.stream(CulturalEventType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
