package ro.pao.model.enums;

public enum DegreeType {
    BACHELOR("Bachelor"),
    MASTER("Master"),
    PHD("PhD");

    String type;

    DegreeType(String type) {
        this.type = type;
    }
}
