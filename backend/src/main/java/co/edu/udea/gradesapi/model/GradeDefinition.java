package co.edu.udea.gradesapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade_definition")
public class GradeDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @Column(nullable = false)
    @Schema(example = "Examen 1")
    @Size(max = 40)
    private String name;


    @Column(nullable = false)
    @Schema(example= "Examen sobre casos de factorización")
    @Size(max = 100)
    private String description;

    @Column(nullable = false)
    @Schema(example = "20.0")
    @DecimalMax(value="100.0")
    @DecimalMin(value="0.0")
    private Double percentage;

    @OneToMany(mappedBy = "gradeDefinition")
    private Set<Grade> grades;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}