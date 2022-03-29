package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.Subject;
import co.edu.udea.gradesapi.model.dto.SubjectDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubjectMapper {
    Subject subjectDtoToSubject(SubjectDto subjectDto);

    SubjectDto subjectToSubjectDto(Subject subject);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubjectFromSubjectDto(SubjectDto subjectDto, @MappingTarget Subject subject);

}
