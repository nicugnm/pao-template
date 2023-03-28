package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Location {

    private UUID id;

    private String name;

    private String address;

    private Integer capacity;

}
