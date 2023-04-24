package ro.pao.model;

import ro.pao.application.Register;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.PersonType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class Secretary extends Person {
}
