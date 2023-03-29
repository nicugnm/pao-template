package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.SportsLocation;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Location implements Comparable<Location> {

    private UUID id;

    private String name;

    private String address;

    private Integer capacity;

    @Override
    public int compareTo(Location o) {
        return CharSequence.compare(getName(), o.getName());
    }

}
