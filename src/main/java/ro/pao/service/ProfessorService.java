package ro.pao.service;

import ro.pao.model.Professor;

import java.util.List;
import java.util.UUID;

public interface ProfessorService {
    void addProfessor(Professor professor);
    void addProfessors(List<Professor> professors);
    void addCourseToProfessor(Professor professor, UUID courseId);
    List<Professor> getProfessors();
}
