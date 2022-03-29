package co.edu.udea.gradesapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class InstitutionDto implements Serializable {


    private final Long id;
    @NotNull
    @Schema(example = "Jose Emilio Botero", description = "The name of the institution")
    @Size(min = 2, max = 30, message = "The name must be between 2 and 30 characters")
    private final String name;
    @Schema(example = "Calle 12 #12-12", description = "The address of the institution")
    @Size(max = 40)
    private final String address;
    @Schema(example = "30012345678", description = "The phone number of the institution")
    @Size(max = 25, message = "The phone number must be between 1 and 25 characters")
    @Pattern(regexp = "^[0-9]*$", message = "The phone number must be numeric")
    private final String phone;
    @Schema(example = "institution@mail.com", description = "email of the institution")
    //patern email
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "validation.email.invalid")
    @Size(max = 320, message = "validation.email.max")
    private final String email;
    @Schema(example = "https://www.institution.com", description = "The website of the institution")
    @Size(max = 35, message = "{validation.website.max}")
    private final String web;
    @Schema(example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisi eu porta maximus, nisl nisi " +
            "viverra quam, euismod aliquam eros lectus nec nisl.")
    @Size(max = 250, message = "{validation.description.max}")
    private final String description;
}
