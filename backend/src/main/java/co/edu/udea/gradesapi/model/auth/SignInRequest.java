package co.edu.udea.gradesapi.model.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInRequest {

    @Schema(example = "username")
    @NotBlank
    private String username;

    @Schema(example = "userpassword")
    @NotBlank
    private String password;
}
