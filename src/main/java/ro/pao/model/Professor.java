package ro.pao.model;

import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.PersonType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Professor extends Person {
    private List<UUID> courses;
    private LocalDateTime birthDate;
    private String birthPlace;
    private String email;
}