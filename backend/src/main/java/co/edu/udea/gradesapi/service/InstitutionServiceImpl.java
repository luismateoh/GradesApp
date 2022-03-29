package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.exception.BusinessException;
import co.edu.udea.gradesapi.model.Institution;
import co.edu.udea.gradesapi.repository.InstitutionRepository;
import co.edu.udea.gradesapi.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final Logger log = LoggerFactory.getLogger(InstitutionServiceImpl.class);

    private final InstitutionRepository institutionRepository;
    //private final InstitutionService institutionService;
    private Messages messages;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Institution> getInstitutionsContainingText(String text) {
        return institutionRepository.findByNameContaining(text);
    }

    @Override
    public Institution update(Institution institution) {
        Optional<Institution> optionalInstitution = Optional.ofNullable(institutionRepository.findByName(institution.getName()));
        if(optionalInstitution.isPresent()){
            log.info("Ya se encuentra una institutcion con nombre:"+institution.getName());
            throw new BusinessException(messages.get("exception.data_duplicate_name.institution"));
        }
        optionalInstitution = institutionRepository.findById(institution.getId());
        if(!optionalInstitution.isPresent()){
            log.info("No se encuentra un institution con ID:"+institution.getId());
            throw new BusinessException(messages.get("exception.data_not_found.institution"));
        }

        log.info("Se actualizo el instiitucion con ID:"+institution.getId());
        return institutionRepository.save(institution);
    }

    @Override
    public Institution save(Institution institution) {
        Optional<Institution> optionalInstitution = Optional.ofNullable(institutionRepository.findByName(institution.getName()));
        if(optionalInstitution.isPresent()){
            log.info("Ya se encuentra una institutcion con nombre:"+institution.getName());
            throw new BusinessException(messages.get("exception.data_duplicate_name.institution"));
        }
        return institutionRepository.save(institution);
    }

    @Override
    public void delete(Institution institution) {
        institutionRepository.delete(institution);
       // institution.setActive(false);
       // institutionService.update(institution);
    }

    @Override
    public Institution validateAndGetById(Long id) {
        return institutionRepository.findById(id)
                .orElseThrow(() -> new BusinessException(messages.get("exception.data_not_found.institution {id}")));
    }
}

