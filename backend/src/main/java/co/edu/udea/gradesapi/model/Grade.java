package co.edu.udea.gradesapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @DecimalMax(value="5.0")
    @DecimalMin(value="0.0")
    private Double value;


    @Size(max = 200)
    private String comment;

    @Column
    @Size(max = 10)
    private String status;

    @ManyToOne
    @JoinColumn(name = "grade_definition_id")
    private GradeDefinition gradeDefinition;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User studentGrade;
}