package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.GradeDefinition;
import co.edu.udea.gradesapi.repository.GradeDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradeDefinitionServiceImpl implements GradeDefinitionService {

    private final GradeDefinitionRepository gradeDefinitionRepository;

    @Override
    public GradeDefinition create(GradeDefinition gradeDefinition) {
        //create grade definition
        return gradeDefinitionRepository.save(gradeDefinition);
    }

    @Override
    public GradeDefinition update(GradeDefinition gradeDefinition) {
        return null;
    }

    @Override
    public GradeDefinition findById(Long id) {
        return gradeDefinitionRepository.findById(id).orElse(null);
    }

    @Override
    public GradeDefinition findBySubject(Long subjectId) {
        return gradeDefinitionRepository.findBySubjectId(subjectId);
    }

    @Override
    public void delete(GradeDefinition gradeDefinition) {
        gradeDefinitionRepository.delete(gradeDefinition);
    }

    @Override
    public List<GradeDefinition> findAll() {
        return gradeDefinitionRepository.findAll();
    }
}
