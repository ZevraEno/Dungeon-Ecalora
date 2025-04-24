package be.dungeonEcalora.rolePlayGameManagement.bll.services.race;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {
    List<Race> findAll();
    Optional<Race> findById(Long id);
    Race save(Race race);
    Race update(Long id, Race race);
    void deleteById(Long id);
}
