package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TicketType {
    VIP("vip"),
    PREMIUM("premium"),
    MEDIUM("medium"),
    LOW_MEDIUM("low-medium"),
    NONE("none");

    private final String typeString;

    public static TicketType getEnumByFieldString(String field) {

        return Arrays.stream(TicketType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);

    }

}
