package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Event implements Comparable<Event> {

    private UUID id;

    private LocalDateTime creationDateTime;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private LocalDateTime deleteDateTime;

    public abstract List<Integer> nrTicketsCategories();

    @Override
    public int compareTo(Event o) {
        return startDateTime.compareTo(o.startDateTime);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", deleteDateTime=" + deleteDateTime +
                '}';
    }

}
