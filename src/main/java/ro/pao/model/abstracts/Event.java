package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.CulturalEvent;
import ro.pao.model.SportsEvent;

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

    private Integer nrAvailableTickets;

    public abstract List<Integer> nrTicketsCategories();

    public Event(UUID id, LocalDateTime creationDateTime, LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime deleteDateTime) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.deleteDateTime = deleteDateTime;
    }

    public void sellTickets(Integer nrRequestedTickets) {

        if (nrAvailableTickets != null && nrAvailableTickets > 0 && nrRequestedTickets <= nrAvailableTickets) {

            System.out.println("Hurry up! There are only " + nrAvailableTickets + " tickets available for this event!");

            for (Integer i = 0; i < nrRequestedTickets; i++) {
                if (this instanceof CulturalEvent) {
                    ((CulturalEvent) this).setNrAvailableTickets(nrAvailableTickets - 1);
                } else {
                    ((SportsEvent) this).setNrAvailableTickets(nrAvailableTickets - 1);
                }
            }

            System.out.println("You've just bought " + nrRequestedTickets + " tickets for this event.");

        }

        else if (nrAvailableTickets == 0) {
            System.out.println("There are no more tickets available for this event.");
        }

        else {
            System.out.println("Sorry, there are only " + nrAvailableTickets + " tickets still available for this event. Please reconsider your purchase!");
        }

    }

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
