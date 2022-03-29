package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.Grade;
import co.edu.udea.gradesapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByGradeDefinition_IdAndStudentGrade_Id(Long id, Long id1);

    List<Grade> findByGradeDefinition_Id(Long gradeDefinitionId);
    List<Grade> findByStudentGrade_Id(Long studentGradeId);
}