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
public class Person extends AbstractEntity{
    private String firstName;
    private String lastName;
}
