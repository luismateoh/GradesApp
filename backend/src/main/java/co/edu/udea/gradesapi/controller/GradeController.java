package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.model.Grade;
import co.edu.udea.gradesapi.model.dto.GradeDto;
import co.edu.udea.gradesapi.model.mapper.GradeMapper;
import co.edu.udea.gradesapi.service.GradeService;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static co.edu.udea.gradesapi.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;
    private final GradeMapper gradeMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<GradeDto> getAllGrades(@Valid @RequestParam(value = "grade_definition_id", required = false) Long gradeDefinitionId,
                                       @RequestParam(value = "student_id",required = false) Long studentId) {

        List<Grade> grades;
        if (gradeDefinitionId==null && studentId==null) {
            grades = gradeService.getAllGrades();

        }else if (gradeDefinitionId!=null && studentId==null){
            grades = gradeService.getGradesByGradeDefinitionId(gradeDefinitionId);
        }else if (gradeDefinitionId==null && studentId!=null){
            grades = gradeService.getGradesByStudentId(studentId);
        }else{
            grades = gradeService.getGradesByGradeDefinitionIdAndStudentId(gradeDefinitionId,studentId);
        }

        return grades.stream()
                .map(gradeMapper::gradeToGradeDto)
                .collect(Collectors.toList());

    }
}
