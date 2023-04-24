package ro.pao.model;

import ro.pao.model.abstracts.AbstractEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.CourseType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Course extends AbstractEntity {
    private CourseType courseType;
    private String name;
}
