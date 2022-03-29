package co.edu.udea.gradesapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class GradeDto implements Serializable {
    private final Long id;
    @NotNull
    private final Long gradeDefinitionId;

    @NotNull
    private final Long studentGradeId;
    @NotNull
    @Schema(example = "4.8")
    @DecimalMax(value="5.0")
    @DecimalMin(value="0.0")
    private final Double value;
    @NotBlank
    @Schema(example = "Se cumplio con el objetivo planteado de la actividad")
    @Size(max = 200)
    private final String comment;
    @NotBlank
    @Schema(example = "close")
    @Size(max = 10)
    private final String status;

}
