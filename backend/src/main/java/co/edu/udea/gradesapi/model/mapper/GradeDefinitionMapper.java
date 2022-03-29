package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.GradeDefinition;
import co.edu.udea.gradesapi.model.dto.GradeDefinitionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GradeDefinitionMapper {
    @Mapping(source = "subjectId", target = "subject.id")
    GradeDefinition gradeDefinitionDtoToGradeDefinition(GradeDefinitionDto gradeDefinitionDto);

    @Mapping(source = "subject.id", target = "subjectId")
    GradeDefinitionDto gradeDefinitionToGradeDefinitionDto(GradeDefinition gradeDefinition);

    @Mapping(source = "subjectId", target = "subject.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGradeDefinitionFromGradeDefinitionDto(GradeDefinitionDto gradeDefinitionDto, @MappingTarget GradeDefinition gradeDefinition);
}
