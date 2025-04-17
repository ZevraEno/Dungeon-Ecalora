package be.dungeonEcalora.rolePlayGameManagement.bll.services.npc.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.npc.NPCService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.NPC;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.NPCRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NPCServiceImpl implements NPCService {

    private final NPCRepository repository;

    @Override
    public NPC create(NPC npc) {
        return repository.save(npc);
    }

    @Override
    public NPC update(Long id, NPC npc) {
        NPC existing = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("PNJ non trouvé"));
        existing.setName(npc.getName());
        existing.setDescription(npc.getDescription());
        existing.setRace(npc.getRace());
        existing.setRole(npc.getRole());
        existing.setLevel(npc.getLevel());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public NPC getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("PNJ non trouvé"));
    }

    @Override
    public List<NPC> getAll() {
        return repository.findAll();
    }
}