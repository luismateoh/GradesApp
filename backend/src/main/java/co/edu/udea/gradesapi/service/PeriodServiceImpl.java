package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.exception.BusinessException;
import co.edu.udea.gradesapi.exception.DataNotFoundException;
import co.edu.udea.gradesapi.model.Period;
import co.edu.udea.gradesapi.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    private void updateStatus(LocalDate now, Period period) {
        if ((period.getStartDate().isBefore(now) || period.getStartDate().isEqual(now))
                && (period.getEndDate().isAfter(now)) || period.getEndDate().isEqual(now)) {
            period.setStatus("ACTIVE");
        }else if (period.getStartDate().isAfter(now) && period.getEndDate().isAfter(now)){
            period.setStatus("FUTURE");
        }else if (period.getStartDate().isBefore(now) && period.getEndDate().isBefore(now)){
            period.setStatus("PAST");
        }

        if (period.getStartDate().isAfter(period.getEndDate())){
            period.setStatus("INVALID");
            throw new BusinessException("Start date must be before end date");
        }else if (period.getStartDate().isEqual(period.getEndDate())){
            period.setStatus("START_& END_EQUALS");
            throw new BusinessException("Start date must be different than end date");
        }


    }

    @Override
    public List<Period> getPeriods() {
        List<Period> periods = periodRepository.findByOrderByYearAscIndexAsc();
        LocalDate now = LocalDate.now();
        for (Period period : periods) {
            updateStatus(now, period);
        }
         return periods;
    }

    @Override
    public List<Period> getPeriodsContainingText(Integer text) {
        return periodRepository.findByYear(text);
    }

    @Override
    public Period validateAndGetPeriod(Long id) {
         Period period = periodRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new DataNotFoundException(String.format("Period with id %s not found", id)));
         updateStatus(LocalDate.now(), period);
        return period;
    }

    @Override
    public Period savePeriod(Period period) {
        LocalDate now = LocalDate.now();
        updateStatus(now, period);

        if (periodRepository.existsByYearAndIndex(period.getYear(), period.getIndex())){
            throw new BusinessException(String.format("Period with year %s and index %s already exists", period.getYear(), period.getIndex()));
        }

        if (period.getIndex() < 1 || period.getIndex() > 4){
            throw new BusinessException("Number must be between 1 and 4");
        }

        return periodRepository.save(period);
    }

    @Override
    public void deletePeriod(Period period) {
        periodRepository.delete(period);
    }
}
