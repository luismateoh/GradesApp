package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> getGradesByStudent(Long studentId);

    List<Grade> getGradesBySubject(Long subjectId);

    List<Grade> getGradesByStudentAndSubject(Long studentId, Long subjectId);

    List<Grade> getGradesByStudentAndSubjectAndPeriod(Long studentId, Long subjectId, Long periodId);

    Grade getGrade(Long gradeId);

    Grade createGrade(Grade grade);

    Grade updateGrade(Grade grade);

    void deleteGrade(Long gradeId);

    List<Grade> getAllGrades();

    List<Grade> getGradesByGradeDefinitionId(Long gradeDefinitionId);

    List<Grade> getGradesByStudentId(Long studentId);

    List<Grade> getGradesByGradeDefinitionIdAndStudentId(Long gradeDefinitionId, Long studentId);
}
