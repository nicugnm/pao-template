package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CulturalLocationType {

    CONCERT_HALL("concert hall", 5, 10, 35, 50),

    THEATER("theater", 10, 15, 35, 40),

    OPERA_HOUSE("opera house", 10, 15, 30, 45),

    ARENA("arena", 15, 30, 30, 25),

    NONE("none", 0, 0, 0, 0);

    private final String typeString;

    private final Integer percentageVipTickets;

    private final Integer percentagePremiumTickets;

    private final Integer percentageMediumTickets;

    private final Integer percentageLowMediumTickets;

    public static CulturalLocationType getEnumByFieldString(String field) {
        return Arrays.stream(CulturalLocationType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);

    }

}
