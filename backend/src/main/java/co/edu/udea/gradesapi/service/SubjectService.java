package co.edu.udea.gradesapi.service;


import co.edu.udea.gradesapi.model.Subject;


import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getSubjects();

    List<Subject> getSubjectsByIdTutor(String text);

    List<Subject> getSubjectsByPeriod(String text);

    List<Subject> getSubjectByTutorAndPeriod(String tutor, String period);

    Subject validateAndGetSubject(Long id);

    Subject saveSubject(Subject subject);

    void deleteSubject(Subject subject);

    Optional<Subject> getSubjectById(Long subjectId);

    Subject registerTutor(Long subjectId, Long tutorId);
}
