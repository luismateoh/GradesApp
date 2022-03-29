package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.SubjectRegistration;
import co.edu.udea.gradesapi.model.dto.SubjectRegistrationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubjectRegistrationMapper {

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "subjectId", target = "subject.id")
    SubjectRegistration subjectRegistrationDtoToSubjectRegistration(SubjectRegistrationDto subjectRegistrationDto);

    @InheritInverseConfiguration(name = "subjectRegistrationDtoToSubjectRegistration")
    SubjectRegistrationDto subjectRegistrationToSubjectRegistrationDto(SubjectRegistration subjectRegistration);

    @InheritConfiguration(name = "subjectRegistrationDtoToSubjectRegistration")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubjectRegistrationFromSubjectRegistrationDto(SubjectRegistrationDto subjectRegistrationDto, @MappingTarget SubjectRegistration subjectRegistration);
}
