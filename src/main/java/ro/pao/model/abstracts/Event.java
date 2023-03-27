package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.Location;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Event {

    private UUID id;

    private LocalDateTime creationDateTime;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private LocalDateTime deleteDateTime;

    private Location location;
}
