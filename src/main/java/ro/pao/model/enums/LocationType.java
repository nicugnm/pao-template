package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum LocationType {
    CONCERTHALL("concert hall"),
    THEATER("theater"),
    OPERAHOUSE("opera house"),
    ARENA("arena"),
    POOL("pool"),
    CYCLINGROUTE("cycling route"),
    NONE("none");

    private final String typeString;

    public static LocationType getEnumByFieldString(String field) {
        return Arrays.stream(LocationType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
