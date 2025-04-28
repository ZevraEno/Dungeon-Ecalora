package be.dungeonEcalora.rolePlayGameManagement.dal.repositories;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
