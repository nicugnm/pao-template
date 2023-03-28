package ro.pao.model;

import ro.pao.model.abstracts.Person;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class Professor extends Person {
    List<UUID> courses;
    private Integer birthYear;
    private LocalTime birthTime;
    private String birthPlace;
    private String email;
}