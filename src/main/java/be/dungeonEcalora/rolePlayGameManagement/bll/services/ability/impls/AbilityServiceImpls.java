package be.dungeonEcalora.rolePlayGameManagement.bll.services.ability.impls;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.ability.AbilityService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.AbilityRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Ability;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityServiceImpls implements AbilityService {

    private final AbilityRepository repository;

    public AbilityServiceImpls(AbilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ability> getAll() {
        return repository.findAll();
    }

    @Override
    public Ability getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ability not found"));
    }

    @Override
    public Ability create(Ability ability) {
        return repository.save(ability);
    }

    @Override
    public Ability update(Long id, Ability updated) {
        Ability ability = getById(id);
        ability.setName(updated.getName());
        ability.setType(updated.getType());
        ability.setDescription(updated.getDescription());
        ability.setLevelRequirement(updated.getLevelRequirement());
        return repository.save(ability);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
