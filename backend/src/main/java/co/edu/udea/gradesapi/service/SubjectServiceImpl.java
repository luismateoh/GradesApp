package co.edu.udea.gradesapi.service;


import co.edu.udea.gradesapi.exception.BusinessException;
import co.edu.udea.gradesapi.exception.DataNotFoundException;
import co.edu.udea.gradesapi.model.Subject;
import co.edu.udea.gradesapi.model.User;
import co.edu.udea.gradesapi.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import co.edu.udea.gradesapi.utils.Messages;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserService userService;
    private final PeriodService periodService;
    private Messages messages;

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectsByIdTutor(String text) {
        return subjectRepository.findByTutor_Id(Long.valueOf(text));
    }

    @Override
    public List<Subject> getSubjectsByPeriod(String text) {
        return subjectRepository.findByPeriod_Id(Long.valueOf(text));
    }

    @Override
    public List<Subject> getSubjectByTutorAndPeriod(String tutor, String period) {
        return subjectRepository.findByTutor_IdAndPeriod_Id(Long.valueOf(tutor),Long.valueOf(period));
    }

    @Override
    public Subject validateAndGetSubject(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("exception.data_not_found.subject",id)));
    }

    @Override
    public Subject saveSubject(Subject subject) {
        //validate if period exists
        if(periodService.validateAndGetPeriod(subject.getPeriod().getId()) == null){
            throw new BusinessException(String.format("exception.data_not_found.period",subject.getPeriod().getId()));
        }
        //validate if user exists
        if(!userService.getUserById(subject.getTutor().getId()).isPresent()){
            throw new DataNotFoundException(String.format("exception.data_not_found.user",subject.getTutor().getId()));
        }
        //validate role of user
        if(!userService.getUserById(subject.getTutor().getId()).get().getRole().equals("TUTOR")){
            throw new BusinessException(("exception.invalid_role.tutor"));
        }

        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public Subject registerTutor(Long subjectId, Long tutorId) {
        Subject subject = validateAndGetSubject(subjectId);
        Optional<User> user = userService.getUserById(tutorId);
        if(!user.isPresent()){
            throw new DataNotFoundException(String.format("exception.data_not_found.user",tutorId));

        }else{
            subject.setTutor(user.get());
        }
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);

    }
}
