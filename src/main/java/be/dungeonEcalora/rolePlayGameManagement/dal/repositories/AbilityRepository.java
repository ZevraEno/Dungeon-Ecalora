package be.dungeonEcalora.rolePlayGameManagement.dal.repositories;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
}
