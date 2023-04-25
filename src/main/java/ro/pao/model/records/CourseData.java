package ro.pao.model.records;

import ro.pao.model.Student;

import java.util.List;

public record CourseData(List<Student> optionals, List<Student> facultatives, List<Student> mandatories) {
    public CourseData(List<Student> optionals, List<Student> facultatives, List<Student> mandatories) {
        this.optionals = optionals;
        this.facultatives = facultatives;
        this.mandatories = mandatories;
    }
}
