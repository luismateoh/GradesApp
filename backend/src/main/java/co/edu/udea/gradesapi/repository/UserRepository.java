package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByIdentityNumber(Long identityNumber);

    Optional<User> findByUsername(String username);

    List<User> findByRole(String role);
    Page<User> findByRole(String role, Pageable pageable);
}
