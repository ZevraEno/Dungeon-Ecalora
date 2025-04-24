package be.dungeonEcalora.rolePlayGameManagement.bll.services.ability;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Ability;

import java.util.List;

public interface AbilityService {
    List<Ability> getAll();
    Ability getById(Long id);
    Ability create(Ability ability);
    Ability update(Long id, Ability ability);
    void delete(Long id);
}
