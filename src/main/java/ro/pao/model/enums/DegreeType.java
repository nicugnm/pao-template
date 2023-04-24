package ro.pao.model.enums;

public enum DegreeType {
    BACHELOR("Bachelor"),
    MASTER("Master"),
    PHD("PhD");

    String type;

    DegreeType(String type) {
        this.type = type;
    }

    public static DegreeType getByType(String type) {
        for (DegreeType degreeType : DegreeType.values()) {
            if (degreeType.type.equals(type)) {
                return degreeType;
            }
        }
        return null;
    }
}
