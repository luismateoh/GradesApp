package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findByName(String name);

    List<Institution> findByNameContaining(String text);
}