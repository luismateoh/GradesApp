package co.edu.udea.gradesapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

import static co.edu.udea.gradesapi.utils.ValidatorConstants.*;

@Data
public class SubjectDto implements Serializable {
    private final Long id;
    @NotBlank
    @Schema(example = "Matematicas")
    @Size(max = 100)
    private final String name;
    @NotNull
    @Schema(example = "8")
    @Pattern(regexp = ID_NUMBER)
    @Min(value = 0)
    @Max(value = 11)
    private final int gradeStage;
    @NotNull
    private final Long tutorId;
    @NotNull
    private final Long periodId;
    private final Set<GradeDefinition> gradeDefinitions;
    private final Set<SubjectRegistration> registrations;

    @Data
    public static class GradeDefinition implements Serializable {
        private final Long id;
        @NotBlank
        @Schema(example = "Examen 1")
        @Size(max = 40)
        private final String name;
        @Schema(example= "Examen sobre casos de factorización")
        @Size(max = 100)
        private final String description;
        @NotNull
        @Schema(example = "20.0")
        @DecimalMax(value="100.0")
        @DecimalMin(value="0.0")
        private final Double percentage;
    }


    @Data
    public static class SubjectRegistration implements Serializable {
        private final Long id;
        private final Long studentId;
    }

}
