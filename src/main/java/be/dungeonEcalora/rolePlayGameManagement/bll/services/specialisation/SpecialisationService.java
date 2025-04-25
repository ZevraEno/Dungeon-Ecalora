package be.dungeonEcalora.rolePlayGameManagement.bll.services.specialisation;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Specialisation;

import java.util.List;
import java.util.Optional;

public interface SpecialisationService {
    List<Specialisation> findAll();
    Optional<Specialisation> findById(Long id);
    Specialisation save(Specialisation specialisation);
    Specialisation update(Long id, Specialisation classe);
    void deleteById(Long id);
}
