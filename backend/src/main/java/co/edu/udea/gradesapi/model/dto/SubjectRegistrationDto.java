package co.edu.udea.gradesapi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SubjectRegistrationDto implements Serializable {
    private final Long id;
    @NotNull
    private final Long studentId;
    @NotNull
    private final Long subjectId;
}
