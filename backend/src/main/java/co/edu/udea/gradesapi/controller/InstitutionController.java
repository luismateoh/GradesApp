package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.model.Institution;
import co.edu.udea.gradesapi.model.dto.InstitutionDto;
import co.edu.udea.gradesapi.model.mapper.InstitutionMapper;
import co.edu.udea.gradesapi.service.InstitutionService;
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
@RequestMapping("/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;
    private final InstitutionMapper institutionMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<InstitutionDto> getAllInstitutions(@Valid @RequestParam(value = "text", required = false) String text) {
        List<Institution> institutions = (text == null) ? institutionService.findAll() : institutionService.getInstitutionsContainingText(text);
        return institutions.stream()
                .map(institutionMapper::institutionToInstitutionDto)
                .collect(Collectors.toList());
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/{id}")
    public InstitutionDto getInstitution(@PathVariable Long id) {
        return institutionMapper.institutionToInstitutionDto(institutionService.findById(id));
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public InstitutionDto createInstitution(@Valid @RequestBody InstitutionDto institutionDto) {
        Institution institution = institutionMapper.institutionDtoToInstitution(institutionDto);
        return institutionMapper.institutionToInstitutionDto(institutionService.save(institution));
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public InstitutionDto updateInstitution(@PathVariable Long id,@Valid  @RequestBody  InstitutionDto institutionDto) {
        Institution institution = institutionMapper.institutionDtoToInstitution(institutionDto);
        institution.setId(id);
        return institutionMapper.institutionToInstitutionDto(institutionService.save(institution));
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public InstitutionDto deleteInstitution(@Valid @PathVariable Long id) {
        Institution institution = institutionService.validateAndGetById(id);
        institutionService.delete(institution);
        return institutionMapper.institutionToInstitutionDto(institution);
    }
}

