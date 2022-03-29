package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.GradeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDefinitionRepository extends JpaRepository<GradeDefinition, Long> {
    GradeDefinition findBySubjectId(Long subjectId);
}