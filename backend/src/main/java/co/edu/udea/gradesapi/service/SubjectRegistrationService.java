package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.SubjectRegistration;

import java.util.List;

public interface SubjectRegistrationService {

    SubjectRegistration getSubjectRegistration(Long id);

    SubjectRegistration saveSubjectRegistration(SubjectRegistration subjectRegistration);

    SubjectRegistration updateSubjectRegistration(SubjectRegistration subjectRegistration);

    void deleteSubjectRegistration(Long id);

    SubjectRegistration registerSubject(Long subjectId, Long studentId);

    public void unregisterSubject(Long subjectId, Long studentId);

    List<SubjectRegistration> registerSubjects(Long studentId, Long[] subjectIds);

    public void unregisterSubjects(Long studentId, Long[] subjectIds);

}
