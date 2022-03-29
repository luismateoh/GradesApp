package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.Grade;
import co.edu.udea.gradesapi.model.dto.GradeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GradeMapper {


    @Mapping(source = "studentGradeId", target = "studentGrade.id")
    Grade gradeDtoToGrade(GradeDto gradeDto);

    @Mapping(source = "studentGrade.id", target = "studentGradeId")
    GradeDto gradeToGradeDto(Grade grade);

    @Mapping(source = "studentGradeId", target = "studentGrade.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGradeFromGradeDto(GradeDto gradeDto, @MappingTarget Grade grade);
}
