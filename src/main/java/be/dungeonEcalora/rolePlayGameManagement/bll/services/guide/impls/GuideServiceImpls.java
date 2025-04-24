package be.dungeonEcalora.rolePlayGameManagement.bll.services.guide.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.guide.GuideService;

import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.GuideRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Guide;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GuideServiceImpls implements GuideService {

    private final GuideRepository guideRepository;

    public GuideServiceImpls(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Override
    public List<Guide> findAll() {
        return guideRepository.findAll();
    }

    @Override
    public Optional<Guide> findById(Long id) {
        return guideRepository.findById(id);
    }

    @Override
    public Guide save(Guide guide) {
        guide.setDatePublication(LocalDate.now());
        return guideRepository.save(guide);
    }

    @Override
    public Guide update(Long id, Guide guide) {
        return guideRepository.findById(id).map(existing -> {
            existing.setTitre(guide.getTitre());
            existing.setDescription(guide.getDescription());
            existing.setContenu(guide.getContenu());
            existing.setAuteur(guide.getAuteur());
            return guideRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Guide not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        guideRepository.deleteById(id);
    }
}
