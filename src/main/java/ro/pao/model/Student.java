package ro.pao.model;

import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.DegreeType;
import ro.pao.model.enums.FrequencyType;

import java.util.List;
import java.util.UUID;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Student extends Person {
    private List<UUID> courses;
    private DegreeType degree;
    private FrequencyType frequency;
}
