package ro.pao.model;

import jdk.jfr.Frequency;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.DegreeType;
import ro.pao.model.enums.FrequencyType;

import java.util.List;
import java.util.UUID;

public class Student extends Person {
    List<UUID> courses;
    DegreeType degree;
    FrequencyType frequency;
}
