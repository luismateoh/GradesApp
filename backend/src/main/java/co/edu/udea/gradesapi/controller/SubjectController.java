package co.edu.udea.gradesapi.controller;


import co.edu.udea.gradesapi.model.Subject;
import co.edu.udea.gradesapi.model.dto.SubjectDto;
import co.edu.udea.gradesapi.model.mapper.SubjectMapper;
import co.edu.udea.gradesapi.service.SubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SubjectDto createSubject(@Valid @RequestBody SubjectDto subjectDto){
        Subject subject = subjectMapper.subjectDtoToSubject(subjectDto);
        return subjectMapper.subjectToSubjectDto(subjectService.saveSubject(subject));
    }


    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<SubjectDto> getAllSubjects(@Valid @RequestParam(value = "tutor", required = false) String tutor,
                                           @RequestParam(value = "period",required = false) String period ) {
        List<Subject> subjects;
        if(tutor==null&&period==null){
            subjects=subjectService.getSubjects();
        }else if(tutor!=null&&period==null ){
            subjects=subjectService.getSubjectsByIdTutor(tutor);
        }else if(tutor==null&&period!=null ){
            subjects=subjectService.getSubjectsByPeriod(period);
        }else{
            subjects=subjectService.getSubjectByTutorAndPeriod(tutor,period);
        }
        return subjects.stream()
                .map(subjectMapper::subjectToSubjectDto)
                .collect(Collectors.toList());
    }

}
