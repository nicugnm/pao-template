package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.CulturalLocationType;

import java.util.Objects;

@SuperBuilder
@Getter
public class CulturalLocation extends Location {

    private CulturalLocationType culturalEventLocationType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CulturalLocation that = (CulturalLocation) o;
        return culturalEventLocationType == that.culturalEventLocationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), culturalEventLocationType);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", locationType=" + culturalEventLocationType +
                '}';
    }

}
