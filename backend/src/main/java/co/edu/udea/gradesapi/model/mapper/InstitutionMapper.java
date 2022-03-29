package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.Institution;
import co.edu.udea.gradesapi.model.dto.InstitutionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InstitutionMapper {
    Institution institutionDtoToInstitution(InstitutionDto institutionDto);

    InstitutionDto institutionToInstitutionDto(Institution institution);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInstitutionFromInstitutionDto(InstitutionDto institutionDto, @MappingTarget Institution institution);
}
