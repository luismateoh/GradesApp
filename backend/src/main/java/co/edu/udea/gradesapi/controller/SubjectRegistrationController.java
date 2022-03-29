package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.model.dto.SubjectRegistrationDto;
import co.edu.udea.gradesapi.model.mapper.SubjectRegistrationMapper;
import co.edu.udea.gradesapi.service.SubjectRegistrationService;
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
@RequestMapping("/subjects-registration")
public class SubjectRegistrationController {

    private final SubjectRegistrationService subjectRegistrationService;
    private final SubjectRegistrationMapper subjectRegistrationMapper;


}
