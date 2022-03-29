package co.edu.udea.gradesapi.model.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {

    @Schema(example = "username")
    @NotBlank
    private String username;

    @Schema(example = "userpassword")
    @NotBlank
    private String password;

    @Schema(example = "User names")
    @NotBlank
    private String names;

    @Schema(example = "user@mail.com")
    @Email
    private String email;

    private Long identityNumber;
    private String role;
    private String lastNames;
    private String phone;
    private String address;
    private String city;
    private String gender;
    //student
    private String grade;
    //tutor
    private String profession;

}
