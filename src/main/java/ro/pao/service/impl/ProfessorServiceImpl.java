package ro.pao.service.impl;

import ro.pao.model.Professor;
import ro.pao.service.ProfessorService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfessorServiceImpl implements ProfessorService {
    private static List<Professor> professorList = new ArrayList<>();

    @Override
    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }

    @Override
    public void addProfessors(List<Professor> professors) {
        professorList.addAll(professors);
    }

    @Override
    public void addCourseToProfessor(Professor professor, UUID courseId) {
        professor.getCourses().add(courseId);
    }

    @Override
    public List<Professor> getProfessors() {
        return professorList;
    }
}
