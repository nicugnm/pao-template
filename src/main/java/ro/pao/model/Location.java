package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.LocationType;

import java.util.Objects;
import java.util.UUID;

@SuperBuilder
@Getter
public class Location implements Comparable<Location> {

    private UUID id;

    private String name;

    private String address;

    private LocationType locationType;

    @Override
    public int compareTo(Location o) {
        return CharSequence.compare(this.name, o.name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(name, location.name) && Objects.equals(address, location.address) && locationType == location.locationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, locationType);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", locationType=" + locationType +
                '}';
    }

}
