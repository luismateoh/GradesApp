package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.Grade;
import co.edu.udea.gradesapi.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final UserService userService;

    @Override
    public List<Grade> getGradesByStudent(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getGradesBySubject(Long subjectId) {
        return null;
    }

    @Override
    public List<Grade> getGradesByStudentAndSubject(Long studentId, Long subjectId) {
        return null;
    }

    @Override
    public List<Grade> getGradesByStudentAndSubjectAndPeriod(Long studentId, Long subjectId, Long periodId) {
        return null;
    }

    @Override
    public Grade getGrade(Long gradeId) {
        return gradeRepository.findById(gradeId).orElse(null);
    }

    @Override
    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }

    @Override
    public List<Grade> getGradesByGradeDefinitionId(Long gradeDefinitionId) {
        return gradeRepository.findByGradeDefinition_Id(gradeDefinitionId);
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentGrade_Id(studentId);
    }

    @Override
    public List<Grade> getGradesByGradeDefinitionIdAndStudentId(Long gradeDefinitionId, Long studentId) {
        return gradeRepository.findByGradeDefinition_IdAndStudentGrade_Id(gradeDefinitionId, studentId);
    }
}
