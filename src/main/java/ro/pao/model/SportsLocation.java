package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Location;
import ro.pao.model.enums.SportsLocationType;

import java.util.Objects;

@SuperBuilder
@Getter
public class SportsLocation extends Location implements Comparable<SportsLocation> {

    private SportsLocationType sportsEventLocationType;

    @Override
    public int compareTo(SportsLocation o) {
        return CharSequence.compare(getName(), o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportsLocation that = (SportsLocation) o;
        return sportsEventLocationType == that.sportsEventLocationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sportsEventLocationType);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", locationType=" + sportsEventLocationType +
                '}';
    }

}
