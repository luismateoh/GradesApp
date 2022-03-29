package co.edu.udea.gradesapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static co.edu.udea.gradesapi.utils.ValidatorConstants.*;
import static co.edu.udea.gradesapi.utils.ValidatorConstants.MAX_SIZE_ADDRESS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INSTITUTIONS")
public class Institution {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Schema(example = "Institution Juana Hoz")
    @Size(min= MIN_SIZE_NAME, max=MAX_SIZE_NAME)
    @Column
    private String name;

    @Schema(example = "Cll 50 # 30-20")
    @Size(min= MIN_SIZE_ADDRESS, max=MAX_SIZE_ADDRESS)
    @Column
    private String address;


    @Schema(example = "Cll 50 # 30-20")
    @Size(min= MIN_SIZE_ADDRESS, max=MAX_SIZE_ADDRESS)
    @Column
    private String phone;


    @Schema(example = "institution@mail.com", description = "email from Institution")
    @Pattern(regexp = REGEX_EMAIL, message = "validation.email.invalid")
    @Size(min = MIN_SIZE_EMAIL, max = MAX_SIZE_EMAIL)
    @Column
    private String email;

    @NotBlank
    @Schema(example = "institution.com", description = "web from Institution")
    @Size(min = MIN_SIZE_WEB, max = MAX_SIZE_WEB)
    @Column
    private String web;

    @Schema(example = "institution", description = "description from Institution")
    @Size(max = MAX_SIZE_DESCRIPTION)
    @Column
    private String description;

    private Boolean active;

}