package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.PersonType;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Person extends AbstractEntity{
    @Builder.Default
    private List<String> firstName = new ArrayList<>();
    private String lastName;
    private PersonType personType;
}
