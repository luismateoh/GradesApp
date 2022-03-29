package co.edu.udea.gradesapi.controller;

import co.edu.udea.gradesapi.config.security.WebSecurityConfig;
import co.edu.udea.gradesapi.exception.DuplicatedUserInfoException;
import co.edu.udea.gradesapi.model.User;
import co.edu.udea.gradesapi.model.auth.AuthResponse;
import co.edu.udea.gradesapi.model.auth.SignInRequest;
import co.edu.udea.gradesapi.model.auth.SignUpRequest;
import co.edu.udea.gradesapi.model.dto.UserDto;
import co.edu.udea.gradesapi.model.mapper.UserMapper;
import co.edu.udea.gradesapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static co.edu.udea.gradesapi.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;
import static co.edu.udea.gradesapi.config.security.WebSecurityConfig.ADMIN;
import static co.edu.udea.gradesapi.config.security.WebSecurityConfig.TUTOR;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody SignInRequest signInRequest) {
        Optional<User> userOptional = userService.validUsernameAndPassword(signInRequest.getUsername(), signInRequest.getPassword());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(user.getId(), user.getNames(), user.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.hasUserWithUsername(signUpRequest.getUsername())) {
            throw new DuplicatedUserInfoException(String.format("Username %s is already been used", signUpRequest.getUsername()));
        }
        if (userService.hasUserWithEmail(signUpRequest.getEmail())) {
            throw new DuplicatedUserInfoException(String.format("Email %s is already been used", signUpRequest.getEmail()));
        }

        User user = userService.saveUser(createUser(signUpRequest));
        return new AuthResponse(user.getId(), user.getNames(), user.getRole());
    }


    private User createUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setNames(signUpRequest.getNames());
        user.setEmail(signUpRequest.getEmail());

        if (signUpRequest.getRole() == ADMIN) {
            user.setRole(ADMIN);
        }else if (signUpRequest.getRole() == TUTOR) {
            user.setRole(TUTOR);
        }else {
            user.setRole(WebSecurityConfig.STUDENT);
        }
        user.setIdentityNumber(signUpRequest.getIdentityNumber());
        user.setLastNames(signUpRequest.getLastNames());
        user.setPhone(signUpRequest.getPhone());
        user.setAddress(signUpRequest.getAddress());
        user.setCity(signUpRequest.getCity());
        user.setGender(signUpRequest.getGender());
        user.setGender(signUpRequest.getGender());

        return user;
    }
}
