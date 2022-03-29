package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByTutor_Id(Long id);
    List<Subject> findByPeriod_Id(Long id);
    List<Subject> findByTutor_IdAndPeriod_Id(Long id, Long periodId);


}