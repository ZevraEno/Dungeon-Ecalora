package be.dungeonEcalora.rolePlayGameManagement.bll.services.quest;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Quest;

import java.util.List;

public interface QuestService {
    Quest create(Quest quest);
    Quest update(Long id, Quest quest);
    void delete(Long id);
    Quest getOne(Long id);
    List<Quest> getAll();
}
