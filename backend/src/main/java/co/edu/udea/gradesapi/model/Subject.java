package co.edu.udea.gradesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "SUBJECTS")
public class Subject {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int gradeStage;

    //Belongs to a period
    @ManyToOne
    @JoinColumn(name="period_id", nullable=false)
    private Period period;

    //Have many GradeDefinition
    @OneToMany(mappedBy = "subject")
    private Set<GradeDefinition> gradeDefinitions;

    //Have one tutor
    @OneToOne(mappedBy = "subjectTutor")
    private User tutor;

    @OneToMany(mappedBy = "subject")
    Set<SubjectRegistration> registrations;

}
