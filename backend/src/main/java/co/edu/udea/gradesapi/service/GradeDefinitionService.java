package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.GradeDefinition;

import java.util.List;

public interface GradeDefinitionService {

    GradeDefinition create(GradeDefinition gradeDefinition);

    GradeDefinition update(GradeDefinition gradeDefinition);

    GradeDefinition findById(Long id);

    GradeDefinition findBySubject(Long subjectId);

    void delete(GradeDefinition gradeDefinition);

    List<GradeDefinition> findAll();
}
