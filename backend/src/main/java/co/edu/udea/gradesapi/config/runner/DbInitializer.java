package co.edu.udea.gradesapi.config.runner;

import co.edu.udea.gradesapi.model.Period;
import co.edu.udea.gradesapi.model.User;
import co.edu.udea.gradesapi.service.PeriodService;
import co.edu.udea.gradesapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static co.edu.udea.gradesapi.config.security.WebSecurityConfig.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class DbInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PeriodService periodService;

    @Override
    public void run(String... args) {
        if (!userService.getUsers().isEmpty()) {
            return;
        }
        USERS.forEach(userService::saveUser);
        getPeriods().forEach(periodService::savePeriod);
        log.info("Database initialized");
    }

    private List<Period> getPeriods() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Arrays.stream(PERIODS_STR.split("\n"))
                .map(periodInfoStr -> periodInfoStr.split(";"))
                .map(periodInfo -> Period.builder()
                        .index(Integer.parseInt(periodInfo[0]))
                        .year(Integer.parseInt(periodInfo[1]))
                        .startDate(LocalDate.parse(periodInfo[2], df))
                        .endDate(LocalDate.parse(periodInfo[3], df))
                        .build()
                ).collect(Collectors.toList());
    }

    private static final List<User> USERS = Arrays.asList(
            User.builder()
                    .username("admin")
                    .password("admin")
                    .email("admin@mail.com")
                    .names("Carlos")
                    .lastNames("Garcia")
                    .address("Calle falsa 123")
                    .phone("3001234567")
                    .city("Medellin")
                    .gender("M")
                    .identityNumber(1034651255L)
                    .role(ADMIN)
                    .build(),
            User.builder()
                    .username("student")
                    .password("student")
                    .email("student@mail.com")
                    .names("Juan")
                    .lastNames("Martinez")
                    .address("Calle falsa 456")
                    .phone("3001236547")
                    .city("Bogota")
                    .gender("M")
                    .identityNumber(123456788L)
                    .role(STUDENT)
                    .build(),
            User.builder()
                    .username("tutor")
                    .password("tutor")
                    .email("tutor@mail.com")
                    .names("Maria")
                    .lastNames("Castro")
                    .address("Calle falsa 321")
                    .phone("3004445555")
                    .city("Rionegro")
                    .gender("F")
                    .identityNumber(123456789L)
                    .role(TUTOR)
                    .build()
    );

    private static final String PERIODS_STR =
              "1;2022;2022-01-13;2022-03-15\n"
            + "2;2022;2022-03-16;2022-05-15\n"
            + "3;2022;2022-07-16;2022-09-15\n"
            + "4;2022;2022-09-16;2022-11-30\n";



}