package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.Period;

import java.util.List;

public interface PeriodService {

    List<Period> getPeriods();

    List<Period> getPeriodsContainingText(Integer text);

    Period validateAndGetPeriod(Long id);

    Period savePeriod(Period period);

    void deletePeriod(Period period);
}
