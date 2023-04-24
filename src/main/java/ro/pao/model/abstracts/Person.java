package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.PersonType;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Person extends AbstractEntity{
    private String firstName;
    private String lastName;
    private PersonType personType;
}
