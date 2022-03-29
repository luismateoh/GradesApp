package co.edu.udea.gradesapi.repository;

import co.edu.udea.gradesapi.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period, String> {

    List<Period> findByYear(Integer year);

    List<Period> findByOrderByYearAscIndexAsc();
    boolean existsByYearAndIndex(Integer year, Integer index);


}
