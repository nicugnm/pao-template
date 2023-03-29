package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SportsLocationType {

    ARENA("arena", 20, 25, 30, 25),

    POOL("pool", 15, 15,40, 30),

    CYCLING_ROUTE("cycling route", 20, 15, 55, 10),

    NONE("none", 0, 0, 0, 0);

    private final String typeString;

    private final Integer percentageVipTickets;

    private final Integer percentagePremiumTickets;

    private final Integer percentageMediumTickets;

    private final Integer percentageLowMediumTickets;

    public static SportsLocationType getEnumByFieldString(String field) {
        return Arrays.stream(SportsLocationType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);

    }

}
