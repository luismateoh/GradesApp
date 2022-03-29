package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.model.GradeDefinition;
import co.edu.udea.gradesapi.model.dto.GradeDefinitionDto;
import co.edu.udea.gradesapi.model.mapper.GradeDefinitionMapper;
import co.edu.udea.gradesapi.service.GradeDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static co.edu.udea.gradesapi.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grades-definitions")
public class GradeDefinitionController {

    private final GradeDefinitionService gradeDefinitionService;
    private final GradeDefinitionMapper gradeDefinitionMapper;


    @Operation(security = {
            @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GradeDefinitionDto create(@Valid @RequestBody GradeDefinitionDto gradeDefinitionDto) {
        GradeDefinition gradeDefinition = gradeDefinitionMapper.gradeDefinitionDtoToGradeDefinition(gradeDefinitionDto);
        return gradeDefinitionMapper.gradeDefinitionToGradeDefinitionDto(gradeDefinitionService.create(gradeDefinition));
    }

    @Operation(security = {
            @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)
    })
    @GetMapping
    public List<GradeDefinitionDto> findAll() {
        return gradeDefinitionService.findAll().stream()
                .map(gradeDefinitionMapper::gradeDefinitionToGradeDefinitionDto)
                .collect(Collectors.toList());
    }
}
