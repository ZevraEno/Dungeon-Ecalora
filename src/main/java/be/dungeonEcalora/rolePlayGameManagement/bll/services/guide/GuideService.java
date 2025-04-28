package be.dungeonEcalora.rolePlayGameManagement.bll.services.guide;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Guide;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;

import java.util.List;
import java.util.Optional;

public interface GuideService {
    List<Guide> findAll();
    Optional<Guide> findById(Long id);
    Guide save(Guide guide);
    Guide update(Long id, Guide guide);
    void deleteById(Long id);
}
