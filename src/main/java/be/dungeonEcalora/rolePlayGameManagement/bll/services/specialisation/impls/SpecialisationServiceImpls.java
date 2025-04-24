package be.dungeonEcalora.rolePlayGameManagement.bll.services.specialisation.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.specialisation.SpecialisationService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.SpecialisationRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Charactere.Specialisation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialisationServiceImpls implements SpecialisationService {

    private final SpecialisationRepository specialisationRepository;

    public SpecialisationServiceImpls(SpecialisationRepository specialisationRepository) {
        this.specialisationRepository = specialisationRepository;
    }

    @Override
    public List<Specialisation> findAll() {
        return specialisationRepository.findAll();
    }

    @Override
    public Optional<Specialisation> findById(Long id) {
        return specialisationRepository.findById(id);
    }

    @Override
    public Specialisation save(Specialisation specialisation) {
        return specialisationRepository.save(specialisation);
    }

    @Override
    public Specialisation update(Long id, Specialisation specialisation) {
        return specialisationRepository.findById(id).map(existing -> {
            existing.setNom(specialisation.getNom());
            existing.setDescription(specialisation.getDescription());
            existing.setCompetences(specialisation.getCompetences());
            existing.setDesDeVie(specialisation.getDesDeVie());
            existing.setSorts(specialisation.getSorts());
            return specialisationRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Classe not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        specialisationRepository.deleteById(id);
    }
}
