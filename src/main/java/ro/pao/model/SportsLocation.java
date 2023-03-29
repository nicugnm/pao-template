package ro.pao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.SportsLocationType;

import java.util.Objects;

@SuperBuilder
@Getter
@Setter
public class SportsLocation extends Location {

    private SportsLocationType sportsLocationType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportsLocation that = (SportsLocation) o;
        return sportsLocationType == that.sportsLocationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sportsLocationType);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", locationType=" + sportsLocationType +
                '}';
    }

}
