package be.dungeonEcalora.rolePlayGameManagement.bll.services.quest.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.quest.QuestService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.QuestRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Quest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestServiceImpls implements QuestService {

    private final QuestRepository repository;

    @Override
    public Quest create(Quest quest) {
        return repository.save(quest);
    }

    @Override
    public Quest update(Long id, Quest quest) {
        Quest existing = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quete non trouvé"));
        existing.setNom(quest.getNom());
        existing.setDifficulté(quest.getDifficulté());
        existing.setGenre(quest.getGenre());
        existing.setNote(quest.getNote());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Quest getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quete non trouvé"));
    }

    @Override
    public List<Quest> getAll() {
        return repository.findAll();
    }
}
