package co.edu.udea.gradesapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long identityNumber;
    private String username;
    private String password;
    private String email;
    private String role;
    private String names;
    private String lastNames;
    private String phone;
    private String address;
    private String city;
    private String gender;
    private String gradeStage;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "tutors_subject",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Subject subjectTutor;

    @OneToMany(mappedBy = "student")
    Set<SubjectRegistration> registrations;

    @OneToMany(mappedBy = "studentGrade")
    private List<Grade> grades = new ArrayList<>();
    
}
