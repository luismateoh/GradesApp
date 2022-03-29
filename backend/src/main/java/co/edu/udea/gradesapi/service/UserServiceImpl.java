package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.exception.BusinessException;
import co.edu.udea.gradesapi.exception.UserNotFoundException;
import co.edu.udea.gradesapi.model.User;
import co.edu.udea.gradesapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //validate if user with same username exists
        if (hasUserWithUsername(user.getUsername())) {
            throw new BusinessException(String.format("User with username %s already exists", user.getUsername()));
        }
        if (hasUserWithEmail(user.getEmail())) {
            throw new BusinessException(String.format("User with email %s already exists", user.getEmail()));
        }
        if (userRepository.existsByIdentityNumber(user.getIdentityNumber())) {
            throw new BusinessException(String.format("User with identity number %s already exists", user.getIdentityNumber()));
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

    @Override
    public Optional<User> getUserById(Long studentId) {
        return userRepository.findById(studentId);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

}
