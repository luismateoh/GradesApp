package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.Period;
import co.edu.udea.gradesapi.model.dto.PeriodDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PeriodMapper {

    Period periodDtoToPeriod(PeriodDto periodDto);

    PeriodDto periodToPeriodDto(Period period);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePeriodFromPeriodDto(PeriodDto periodDto, @MappingTarget Period period);

}
