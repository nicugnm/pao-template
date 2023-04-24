package ro.pao.model.enums;

public enum FrequencyType {
    ID("ID"),
    IF("IF");

    String type;

    FrequencyType(String type) {
        this.type = type;
    }

    public static FrequencyType getByType(String type) {
        for (FrequencyType frequencyType : FrequencyType.values()) {
            if (frequencyType.type.equals(type)) {
                return frequencyType;
            }
        }
        return null;
    }
}
