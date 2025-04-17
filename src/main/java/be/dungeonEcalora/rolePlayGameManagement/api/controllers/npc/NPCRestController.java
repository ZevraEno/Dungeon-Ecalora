package be.dungeonEcalora.rolePlayGameManagement.api.controllers.npc;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.npc.NPCService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.NPC;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/npcs")
public class NPCRestController {

    private final NPCService npcService;

    public NPCRestController(NPCService npcService) {
        this.npcService = npcService;
    }

    @GetMapping
    public List<NPC> getAll() {
        return npcService.getAll();
    }

    @GetMapping("/{id}")
    public NPC getOne(@PathVariable Long id) {
        return npcService.getOne(id);
    }

    @PostMapping
    public NPC create(@RequestBody NPC npc) {
        return npcService.create(npc);
    }

    @PutMapping("/update")
    public NPC update(@PathVariable Long id, @RequestBody NPC npc) {
        return npcService.update(id, npc);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        npcService.delete(id);
    }
}