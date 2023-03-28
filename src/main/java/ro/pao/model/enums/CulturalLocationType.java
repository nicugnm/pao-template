package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CulturalLocationType {

    CONCERT_HALL("concert hall"),

    THEATER("theater"),

    OPERA_HOUSE("opera house"),

    ARENA("arena"),

    NONE("none");

    private final String typeString;

    public static CulturalLocationType getEnumByFieldString(String field) {
        return Arrays.stream(CulturalLocationType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);

    }

}
