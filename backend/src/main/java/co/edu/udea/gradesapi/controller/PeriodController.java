package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.model.Period;
import co.edu.udea.gradesapi.model.dto.PeriodDto;
import co.edu.udea.gradesapi.model.mapper.PeriodMapper;
import co.edu.udea.gradesapi.service.PeriodService;
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
@RequestMapping("/periods")
public class PeriodController {

    private final PeriodService periodService;
    private final PeriodMapper periodMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<PeriodDto> getPeriods(@RequestParam(value = "year", required = false) Integer text) {
        List<Period> periods = (text == null) ? periodService.getPeriods() : periodService.getPeriodsContainingText(text);
        return periods.stream()
                .map(periodMapper::periodToPeriodDto)
                .collect(Collectors.toList());
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PeriodDto createPeriod(@Valid @RequestBody PeriodDto periodDto) {
        Period period = periodMapper.periodDtoToPeriod(periodDto);
        return periodMapper.periodToPeriodDto(periodService.savePeriod(period));
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public PeriodDto deletePeriod(@PathVariable Long id) {
        Period period = periodService.validateAndGetPeriod(id);
        periodService.deletePeriod(period);
        return periodMapper.periodToPeriodDto(period);
    }
}
