package co.edu.udea.gradesapi.service;

import co.edu.udea.gradesapi.model.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();

    Institution findById(Long id);

    List<Institution> getInstitutionsContainingText(String text);

    Institution update(Institution institution);

    Institution save(Institution institution);

    void delete(Institution institution);

    Institution validateAndGetById(Long id);
}
