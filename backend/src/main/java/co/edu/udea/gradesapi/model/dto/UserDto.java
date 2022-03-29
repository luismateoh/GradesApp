package co.edu.udea.gradesapi.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static co.edu.udea.gradesapi.utils.ValidatorConstants.*;

@Data
public class UserDto implements Serializable {
    private final Long id;
    @NotNull
    @Schema(example = "8025457")
    @Max(value=MAX_SIZE_ID)
    @Pattern(regexp=ID_NUMBER, message="")
    private final Long identityNumber;

    @NotBlank
    @Schema(example = "pepito25")
    @Size(min= MIN_SIZE_ID, max=MAX_SIZE_ID)
    private final String username;

    @NotBlank
    @Schema(example="$%3578794DAWwwr")
    @Size(min= MIN_SIZE_PASSWORD, max=MAX_SIZE_PASSWORD)
    private final String password;

    @Schema(example = "joseperez@mail.com", description = "email from user")
    @Pattern(regexp = REGEX_EMAIL, message = "{validation.email.invalid}")
    @Size(min = MIN_SIZE_EMAIL, max = MAX_SIZE_EMAIL)
    private final String email;

    @NotBlank
    @Schema(example = "8025457")
    @Size(min= MIN_SIZE_ID, max=MAX_SIZE_ID)
    private final String role;

    @NotBlank
    @Schema(example = "Juana")
    @Size(min= MIN_SIZE_NAME, max=MAX_SIZE_NAME)
    private final String names;

    @NotBlank
    @Schema(example = "Perez")
    @Size(min= MIN_SIZE_LASTNAME, max=MAX_SIZE_LASTNAME)
    private final String lastNames;

    @NotBlank
    @Schema(example = "Perez")
    @Size(min= MIN_SIZE_LASTNAME, max=MAX_SIZE_LASTNAME)
    private final String phone;

    @NotBlank
    @Schema(example = "Cll 50 # 30-20")
    @Size(min= MIN_SIZE_ADDRESS, max=MAX_SIZE_ADDRESS)
    private final String address;

    @NotBlank
    @Schema(example = "Medellin")
    @Size(min= MIN_SIZE_NAME, max=MAX_SIZE_NAME)
    private final String city;

    @Schema(example = "Female")
    @Size(min= MIN_SIZE_NAME, max=MAX_SIZE_NAME)
    private final String gender;

    @NotBlank
    @Schema(example = "7")
    @Pattern(regexp = ID_NUMBER)
    @Min(value = 0)
    @Max(value = 11)
    private final String gradeStage;


    private final Long subjectTutorId;
    private final Set<SubjectRegistrationDto> registrations;
    private final List<GradeDto> grades;
}
