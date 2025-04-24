package be.dungeonEcalora.rolePlayGameManagement.bll.services.race.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.race.RaceService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.RaceRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpls implements RaceService {

    private final RaceRepository raceRepository;

    public RaceServiceImpls(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    @Override
    public Optional<Race> findById(Long id) {
        return raceRepository.findById(id);
    }

    @Override
    public Race save(Race race) {
        return raceRepository.save(race);
    }

    @Override
    public Race update(Long id, Race race) {
        return raceRepository.findById(id).map(existing -> {
            existing.setNom(race.getNom());
            existing.setDescription(race.getDescription());
            existing.setBonusCaracteristique(race.getBonusCaracteristique());
            existing.setTaille(race.getTaille());
            existing.setVitesse(race.getVitesse());
            return raceRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Race not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        raceRepository.deleteById(id);
    }
}
