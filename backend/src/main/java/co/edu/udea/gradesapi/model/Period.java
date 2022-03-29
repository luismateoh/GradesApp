package co.edu.udea.gradesapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

import static co.edu.udea.gradesapi.utils.ValidatorConstants.REGEX_MODEL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERIODS")
public class Period {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer index;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDate startDate;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDate endDate;

    @Column(nullable = false)
    @Size(max = 35)
    private String status;

    @OneToMany(mappedBy="period")
    private Set<Subject> subjects;


}
