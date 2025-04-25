package be.dungeonEcalora.rolePlayGameManagement.dal.repositories;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
