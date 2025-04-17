package be.dungeonEcalora.rolePlayGameManagement.bll.services.npc;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.NPC;

import java.util.List;

public interface NPCService {
    NPC create(NPC npc);
    NPC update(Long id, NPC npc);
    void delete(Long id);
    NPC getOne(Long id);
    List<NPC> getAll();
}