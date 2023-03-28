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
public abstract class Event {

    private UUID id;

    private LocalDateTime creationDateTime;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private LocalDateTime deleteDateTime;

    public abstract List<Integer> nrTicketsCategories();

}
